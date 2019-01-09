package pages.sql;

import io.qameta.allure.Step;
import org.codehaus.plexus.util.IOUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.Assert;
import pages.AbstractPage;
import utilities.HibernateSessionFactory;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

//import system.model.HltDispExamEntity;

public class SQLDemonstration extends AbstractPage {
    private static String connectionUrl = "jdbc:sqlserver://192.168.7.48:50004";
    private static String databaseName = "hlt_demonstration";
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
                    statement.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        LOGGER.info("Удалил расписание у LPUDoctorID: " + LPUDoctorID + " DocPRVDID: " + DocPRVDID);
    }

    @Deprecated
    @Step("завершаю все существующие вызовы")
    public static void finalizeAllCalls() {
        String url = connectionUrl +
                ";databaseName=" + databaseName +
                ";user=" + userName +
                ";password=" + password;
        try {
            LOGGER.info("Connecting to SQL Server ... ");
            try (Connection connection = DriverManager.getConnection(url)) {
                String sql =
                        "update hlt_calldoctor set rf_calldoctorstatusid = 3";

                try (Statement statement = connection.createStatement()) {
                    statement.executeUpdate(sql);
                    LOGGER.info("Finalize is done.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    @Step("завершаю вызовы этого врача")
    public static void finalizeCallLpuDoctor(String doctorName) {
        String url = connectionUrl +
                ";databaseName=" + databaseName +
                ";user=" + userName +
                ";password=" + password;
        try {
            LOGGER.info("Connecting to SQL Server ... ");
            try (Connection connection = DriverManager.getConnection(url)) {
                String sql =
//                        "update hlt_CallDoctor " +
//                                "set rf_CallDoctorStatusID = 3 " +
//                                "from hlt_CallDoctor cd  inner join hlt_LPUDoctor ldoc on cd.rf_LPUDoctorID = ldoc.LPUDoctorID " +
//                                "where ldoc.FAM_V = '" + doctorName + "'";
                        "update " +
                                "hlt_CallDoctor " +
                                "set " +
                                "rf_CallDoctorStatusID = 3 " +
                                "from hlt_LPUDoctor ldoc " +
                                "inner join hlt_DocPRVD dvd on ldoc.LPUDoctorID = dvd.rf_LPUDoctorID " +
                                "inner join hlt_CallDoctor cd on cd.rf_DocPRVDID = dvd.DocPRVDID " +
                                "where ldoc.FAM_V = '" + doctorName + "' and " +
                                "cd.rf_CallDoctorStatusID != 3";

                try (Statement statement = connection.createStatement()) {
                    statement.executeUpdate(sql);
                    LOGGER.info("Doctor: " + doctorName + " is finalize.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Step("завершаю вызовы пациента по имени")
    public static void finalizePacientName(String pacientName) {
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
                                "where Name = '" + pacientName + "'";

                try (Statement statement = connection.createStatement()) {
                    statement.executeUpdate(sql);
                    LOGGER.info("Pacient - " + pacientName + " finalize is done.");
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
//        HltDispExamService hltDispExamService = new HltDispExamService();
//        HltDispExamEntity hltDispExamEntity = new HltDispExamEntity();
//        hltDispExamEntity.setFlags(1);
//        hltDispExamService.saveExam(hltDispExamEntity);
//
//        Query query = session.createQuery("select * from HltDispExamEntity");
//        query.setParameter("id", "255");
//        List list = query.list();

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

    @Step("Запуск скрипта на демонстрейшн")
    public static void scriptTxt(String script) {
        String url = connectionUrl +
                ";databaseName=" + databaseName +
                ";user=" + userName +
                ";password=" + password;
        try {
            LOGGER.info("Connecting to SQL Server ... ");
            try (Connection connection = DriverManager.getConnection(url)) {
                try (Statement statement = connection.createStatement()) {
                    statement.executeUpdate(script);
                    LOGGER.info("SQL scripst Complete!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Deprecated
    public static void scriptsToCalldoctor() throws IOException {
        File dir = new File("src/main/resources/sql/calldoctor");
        File[] files = dir.listFiles();
        File[] scriptList = files;
        for (File scriptPath : scriptList) {
            InputStream is = new FileInputStream(scriptPath);
            String script = IOUtil.toString(is, "UTF-8");
            scriptTxt(script);
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

    @Step("Удаляю расписание врача {docprvdid} (Ай Бо Лит АвтоТест)")
    public static void deleteSheduleByPrvdid(String docprvdid) {
        String url = connectionUrl +
                ";databaseName=" + databaseName +
                ";user=" + userName +
                ";password=" + password;
        try {
            LOGGER.info("Connecting to SQL Server ... ");
            try (Connection connection = DriverManager.getConnection(url)) {
                String sql =
                        "delete hlt_DoctorTimeTable from hlt_DoctorTimeTable where rf_DocPRVDID = '1285'";
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

    @Step("Обновляю БД для тестов на случай её изменения")
    public static void updateDB() throws IOException {
        SQLDemonstration.scriptsToCalldoctor();
    }

    @Step("Создание расписания для врачей")
    public static void createShedule() throws FileNotFoundException, ParseException {
        SQLDemonstration.deleteShedule(2078, 1220);
        SQLDemonstration.deleteShedule(1958, 1253);
        SQLDemonstration.deleteShedule(2075, 1244);
        SQLDemonstration.deleteShedule(1932, 1249);
        SQLDemonstration.deleteShedule(1941, 1278);
        SQLDemonstration.deleteShedule(2062, 1202);

        SQLDemonstration.createSheduleCD(2078, 1220);
        SQLDemonstration.createSheduleCD(1958, 1253);
        SQLDemonstration.createSheduleCD(2075, 1244);
        SQLDemonstration.createSheduleCD(1932, 1249);
        SQLDemonstration.createSheduleCD(1941, 1278);
        SQLDemonstration.createSheduleCD(2062, 1202);
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
    public static String getRandomAddressString(int addressID) {
        String addressString = null;
        String url = connectionUrl +
                ";databaseName=" + databaseName +
                ";user=" + userName +
                ";password=" + password;
        try {
            LOGGER.info("Connecting to SQL Server ... ");
            try (Connection connection = DriverManager.getConnection(url)) {
                String sql = "SELECT TOP 1 addressstring FROM kla_address where flags = 1 ORDER BY NEWID()";

                try (Statement statement = connection.createStatement()) {
                    ResultSet rs = statement.executeQuery(sql);
                    while (rs.next()) {
                        addressString = rs.getString("addressstring");
                        LOGGER.info("гет стринг: " + rs.getString("addressstring"));
                    }
                    LOGGER.info("Table DTT is clean.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertTrue("адрес вернулся null", addressString != null);
        return addressString;
    }

    @Step("Получаю адрес стринг из кладр")
    public static List getAddressString(int addressID) {
        String addressString1 = null;
        ResultSet rs;
        List<String> addressStringList = new ArrayList<>();
        String url = connectionUrl +
                ";databaseName=" + databaseName +
                ";user=" + userName +
                ";password=" + password;
        try {
            LOGGER.info("Connecting to SQL Server ... ");
            try (Connection connection = DriverManager.getConnection(url)) {
                String sql = "SELECT addressstring FROM kla_address where flags = 1 group by addressString";

                try (Statement statement = connection.createStatement()) {
                    rs = statement.executeQuery(sql);
                    while (rs.next()) {
                        addressString1 = rs.getString("addressstring");
                        addressStringList.add(addressString1);
                        LOGGER.info("гет стринг: " + addressString1);
                    }
                    LOGGER.info("Table DTT is clean.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertTrue("адрес вернулся null", addressString1 != null);
        return addressStringList;
    }

    @Step("Получаю адрес стринг из кладр")
    public static List getAddressStringHiber(int addressID) {
        SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        Query q1 = session.createQuery(
                "select " +
                        "kl.addressString " +
                        "from KlaAddressEntity kl " +
                        "where kl.flags = 1 " +
                        "group by " +
                        "kl.addressString");
        System.out.println(q1);
        System.out.println(q1.list());
        return q1.list();


//        String addressString1 = null;
//        ResultSet rs;
//        List<String> addressStringList = new ArrayList<>();
//        String url = connectionUrl +
//                ";databaseName=" + databaseName +
//                ";user=" + userName +
//                ";password=" + password;
//        try {
//            LOGGER.info("Connecting to SQL Server ... ");
//            try (Connection connection = DriverManager.getConnection(url)) {
//                String sql = "SELECT addressstring FROM kla_address where flags = 1 group by addressString";
//
//                try (Statement statement = connection.createStatement()) {
//                    rs = statement.executeQuery(sql);
//                    while (rs.next()) {
//                        addressString1 = rs.getString("addressstring");
//                        addressStringList.add(addressString1);
//                        LOGGER.info("гет стринг: " + addressString1);
//                    }
//                    LOGGER.info("Table DTT is clean.");
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        Assert.assertTrue("адрес вернулся null", addressString1 != null);
//        return addressStringList;
    }

    @Step("Проверяю flag по коду")
    public static String verifyCodeAddress(String fullKLADRCodeAddress) {
        String addressString = null;
        String url = connectionUrl +
                ";databaseName=" + databaseName +
                ";user=" + userName +
                ";password=" + password;
        try {
            LOGGER.info("Connecting to SQL Server ... ");
            try (Connection connection = DriverManager.getConnection(url)) {
                String sql = "select * from kla_street where code = " + fullKLADRCodeAddress;
                try (Statement statement = connection.createStatement()) {
                    ResultSet rs = statement.executeQuery(sql);
                    while (rs.next()) {
                        addressString = rs.getString("addressstring");
                        LOGGER.info("гет стринг: " + rs.getString("addressstring"));
                    }
                    LOGGER.info("Table DTT is clean.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertTrue("адрес вернулся null", addressString != null);
        return addressString;
    }
}