package utils.sql;

import io.qameta.allure.Step;
import org.codehaus.plexus.util.IOUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import pages.AbstractPage;
import utils.HibernateSessionFactory;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.ParseException;
import java.util.List;

public class DBScripts extends AbstractPage {
    private static String connectionUrl = "jdbc:sqlserver://192.168.7.48:50004";
    private static String databaseName = "hlt_demonstration2";
    private static String userName = "sa";
    private static String password = "sagfhjkzYES!";
    private static List<File> lst;

    @Step("удаляю расписание этого врача")
    public static void deleteShedule(String fam) {
        String url = connectionUrl +
                ";databaseName=" + databaseName +
                ";user=" + userName +
                ";password=" + password;
        try {
            LOGGER.info("Connecting to SQL Server ... ");
            try (Connection connection = DriverManager.getConnection(url)) {
                String sql =
                        "delete hlt_DoctorTimeTable from hlt_DoctorTimeTable dtt left outer join hlt_LPUDoctor ldoc " +
                                "on dtt.rf_LPUDoctorID = ldoc.LPUDoctorID " +
                                "where dtt.Date >= DATEADD(dd, ((DATEDIFF(dd, '17530101', GETDATE()) / 7) * 7) - 7, '17530101') " +
                                "AND ldoc.FAM_V = '" + fam + "'";
                try (Statement statement = connection.createStatement()) {
                    statement.executeUpdate(sql);
                    LOGGER.info("Table DTT is clean.");
                    statement.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Step("удаляю расписание этого врача")
    public static void deleteShedule(int LPUDoctorID, int DocPRVDID) {
        String url = connectionUrl +
                ";databaseName=" + databaseName +
                ";user=" + userName +
                ";password=" + password;
        try {
            LOGGER.info("Connecting to SQL Server ... ");
            LOGGER.info("Connecting to SQL Server ... ");
            try (Connection connection = DriverManager.getConnection(url)) {
                String sql =
                        "delete hlt_DoctorTimeTable from hlt_DoctorTimeTable dtt left outer join hlt_LPUDoctor ldoc " +
                                "on dtt.rf_LPUDoctorID = ldoc.LPUDoctorID " +
                                "where dtt.Date >= DATEADD(dd, ((DATEDIFF(dd, '17530101', GETDATE()) / 7) * 7) - 7, '17530101') " +
                                "  AND dtt.rf_DocPRVDID = " + DocPRVDID +
                                "  AND dtt.rf_LPUDoctorID = " + LPUDoctorID;
                try (Statement statement = connection.createStatement()) {
                    statement.executeUpdate(sql);
                    LOGGER.info("Table DTT is clean.");
//                    statement.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        LOGGER.info("Удалил расписание у LPUDoctorID: " + LPUDoctorID + " DocPRVDID: " + DocPRVDID);
    }

    @Step("завершаю вызовы оператора Темников")
    public static void finalizeCallsOperatorTemnikov() {
        String url = connectionUrl +
                ";databaseName=" + databaseName +
                ";user=" + userName +
                ";password=" + password;
        try {
            LOGGER.info("Connecting to SQL Server ... ");
            try (Connection connection = DriverManager.getConnection(url)) {
                String sql =
                        "update hlt_calldoctor " +
                                "set rf_calldoctorstatusid = 3 " +
                                "from hlt_calldoctor cl " +
                                "inner join oms_DocumentHistory dh on cl.guid = dh.rf_documentguid " +
                                "where dh.Editor = 'Темников Дмитрий Олегович' " +
                                "and cl.rf_calldoctorstatusid in (2, 5, 7)";
                try (Statement statement = connection.createStatement()) {
                    statement.executeUpdate(sql);
                    LOGGER.info("Finalize is done.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Step("завершаю вызовы пациента по полису")
    public static void finalizeCall_NPol(String number) {

        String url = connectionUrl +
                ";databaseName=" + databaseName +
                ";user=" + userName +
                ";password=" + password;
        try {
            LOGGER.info("Connecting to SQL Server ... ");
            try (Connection connection = DriverManager.getConnection(url)) {
                String sql =
                        "update hlt_CallDoctor " +
                                "set rf_CallDoctorStatusID = 3 " +
                                "where numberPol = '" + number + "'";
                try (Statement statement = connection.createStatement()) {
                    statement.executeUpdate(sql);
                    LOGGER.info("Pacient - " + number + " finalize is done.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        LOGGER.info("Вызов завершен!");
    }

    @Step("Сбросить мероприятия у карты вызова")
    public static void setDefaultServices(String cardID) { // TODO: 04.09.2018 доделать обнуление заключения
        String url = connectionUrl +
                ";databaseName=" + databaseName +
                ";user=" + userName +
                ";password=" + password;
        try {
            LOGGER.info("Connecting to SQL Server ... ");
            try (Connection connection = DriverManager.getConnection(url)) {
                String sql =
                        "update hlt_disp_Exam" +
                                " set IsDeviation = 0," +
                                " IsOtkaz = 0," +
                                " IsSigned = 0" +
                                " from hlt_disp_Card dc" +
                                " inner join hlt_disp_Exam de on dc.Guid = de.rf_CardGuid" +
                                " where dc.disp_CardID = '" + cardID + "'";
                try (Statement statement = connection.createStatement()) {
                    statement.executeUpdate(sql);
                    LOGGER.info("Card: " + cardID + " is default!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Step("Запуск скрипта на демонстрейшн")
    public static void runSqlScript(String sql) throws IOException {
        InputStream is = new FileInputStream("src/main/resources/sql/disp/" + sql);
        String script = IOUtil.toString(is, "UTF-8");
        String url = connectionUrl +
                ";databaseName=" + databaseName +
                ";user=" + userName +
                ";password=" + password;
        try {
            LOGGER.info("Connecting to SQL Server ... ");
            try (Connection connection = DriverManager.getConnection(url)) {
                try (Statement statement = connection.createStatement()) {
                    statement.executeUpdate(script);
                    LOGGER.info("SQL scripst " + sql + " Complete!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Step("Создаю расписание для врача {docprvdid} (Ай Бо Лит АвтоТест)")
    public static void createShedule(int LPUDoctorID, int DocPRVDID) throws FileNotFoundException, ParseException {
        String request = new DateGenerator().doctorShedule_Disp(LPUDoctorID, DocPRVDID);
        String url = connectionUrl +
                ";databaseName=" + databaseName +
                ";user=" + userName +
                ";password=" + password;
        try {
            LOGGER.info("Connecting to SQL Server ... ");
            try (Connection connection = DriverManager.getConnection(url)) {
                try (Statement statement = connection.createStatement()) {
                    statement.executeUpdate(request);
                    LOGGER.info("Complete!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Step("Создаю расписание для врача {docprvdid} (Ай Бо Лит АвтоТест)")
    public static void createSheduleCD(int LPUDoctorID, int DocPRVDID) throws FileNotFoundException, ParseException {
        String request = new DateGenerator().doctorShedule_CD(LPUDoctorID, DocPRVDID);
        String url = connectionUrl +
                ";databaseName=" + databaseName +
                ";user=" + userName +
                ";password=" + password;
        try {
            System.out.print("Connecting to SQL Server ... ");
            System.out.print(url);
            try (Connection connection = DriverManager.getConnection(url)) {
                try (Statement statement = connection.createStatement()) {
                    statement.executeUpdate(request);
                    System.out.println("Complete!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Step("отменяю созданный вызов после каждого теста")
    public static void cancelCall(String methodName) {
        String url = connectionUrl +
                ";databaseName=" + databaseName +
                ";user=" + userName +
                ";password=" + password;
        try {
            LOGGER.info("Connecting to SQL Server ... ");
            try (Connection connection = DriverManager.getConnection(url)) {
                String sql =
                        "update hlt_calldoctor set rf_calldoctorstatusid = 4 where CallDoctorID = " + cardMap.get(methodName);
                if (cardMap.get(methodName) != null && cardMap.get(methodName) > 0) {
                    try (Statement statement = connection.createStatement()) {
                        statement.executeUpdate(sql);
                        LOGGER.info("Вызов взят из стека и отменён!");
                    }
                } else {
                    LOGGER.info("вызов не отменен!: " + cardMap.get(methodName));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Step("Получаю адрес стринг из кладр")
    public static List getAddressStringHiber() {
        SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        Query q1 = session.createQuery(
                "select " +
                        "kl.addressString " +
                        "from KlaAddressEntity kl " +
                        "where kl.flags = 1 " +
                        "group by " +
                        "kl.addressString");
        return q1.list();
    }

    @Step("Проверяю flag по коду")
    public static boolean verifyKladrCodeHiber(String fullKLADRCodeAddress) {
        SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        Object q1 = null;
        if (fullKLADRCodeAddress.length() == 13) {
            q1 = session.createQuery(
                    "select ks.flags " +
                            "from KlaStreetEntity ks " +
                            "where ks.code = :code1")
                    .setParameter("code1", fullKLADRCodeAddress)
                    .uniqueResult();
        }
        if (fullKLADRCodeAddress.length() == 17) {
            q1 = session.createQuery(
                    "select ks.flags " +
                            "from KlaKlAdrEntity ks " +
                            "where ks.code = :code1")
                    .setParameter("code1", fullKLADRCodeAddress)
                    .uniqueResult();
        }
        if (q1 != null && q1.equals("1"))
            return true;
        return false;
    }
}