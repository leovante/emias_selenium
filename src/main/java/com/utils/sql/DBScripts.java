package com.utils.sql;

import com.pages.BasePage;
import com.utils.HibernateSessionFactory;
import io.qameta.allure.Step;
import org.codehaus.plexus.util.IOUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.ParseException;
import java.util.List;

public class DBScripts extends BasePage {
    private static String connectionUrl = "jdbc:sqlserver://192.168.7.253:64783";
    private static String databaseName = "test_mo_hlt_Taldom_CRB_20190129";
    private static String userName = "mis";
    private static String password = "sagfhjkzYES!";
    private static List<File> lst;

    public DBScripts()  {
    }

    @Step("удаляю расписание этого врача")
    public static void deleteShedule(String fam) {
        String url = connectionUrl +
                ";databaseName=" + databaseName +
                ";user=" + userName +
                ";password=" + password;
        try {
            logger.info("Connecting to SQL Server ... ");
            try (Connection connection = DriverManager.getConnection(url)) {
                String sql =
                        "delete hlt_DoctorTimeTable from hlt_DoctorTimeTable dtt left outer join hlt_LPUDoctor ldoc " +
                                "on dtt.rf_LPUDoctorID = ldoc.LPUDoctorID " +
                                "where dtt.Date >= DATEADD(dd, ((DATEDIFF(dd, '17530101', GETDATE()) / 7) * 7) - 7, '17530101') " +
                                "AND ldoc.FAM_V = '" + fam + "'";
                try (Statement statement = connection.createStatement()) {
                    statement.executeUpdate(sql);
                    logger.info("Table DTT is clean.");
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
            logger.info("Connecting to SQL Server ... ");
            try (Connection connection = DriverManager.getConnection(url)) {
                String sql =
                        "delete hlt_DoctorTimeTable from hlt_DoctorTimeTable dtt left outer join hlt_LPUDoctor ldoc " +
                                "on dtt.rf_LPUDoctorID = ldoc.LPUDoctorID " +
                                "where dtt.Date >= DATEADD(dd, ((DATEDIFF(dd, '17530101', GETDATE()) / 7) * 7) - 7, '17530101') " +
                                "  AND dtt.rf_DocPRVDID = " + DocPRVDID +
                                "  AND dtt.rf_LPUDoctorID = " + LPUDoctorID;
                try (Statement statement = connection.createStatement()) {
                    statement.executeUpdate(sql);
                    logger.info("Table DTT is clean.");
//                    statement.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("Удалил расписание у LPUDoctorID: " + LPUDoctorID + " DocPRVDID: " + DocPRVDID);
    }

    @Step("завершаю вызовы оператора Темников")
    public static void finalizeCallsOperatorTemnikov() {
        String url = connectionUrl +
                ";databaseName=" + databaseName +
                ";user=" + userName +
                ";password=" + password;
        try {
            logger.info("Connecting to SQL Server ... ");
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
                    logger.info("Finalize is done.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Step("Запуск скрипта на демонстрейшн")
    public static void runSqlScript(String sql) {
        InputStream is;
        String script = null;
        try {
            is = new FileInputStream("src/main/resources/sql/disp/" + sql);
            script = IOUtil.toString(is, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        String url = connectionUrl +
                ";databaseName=" + databaseName +
                ";user=" + userName +
                ";password=" + password;
        try {
            logger.info("Connecting to SQL Server ... ");
            try (Connection connection = DriverManager.getConnection(url)) {
                try (Statement statement = connection.createStatement()) {
                    statement.executeUpdate(script);
                    logger.info("SQL scripst " + sql + " Complete!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Step("Запуск скрипта на демонстрейшн")
    public static void runSqlScriptCD(String sql) {
        InputStream is;
        String script = null;
        try {
            is = new FileInputStream("src/main/resources/sql/calldoctor/" + sql);
            script = IOUtil.toString(is, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        String url = connectionUrl +
                ";databaseName=" + databaseName +
                ";user=" + userName +
                ";password=" + password;
        try {
            logger.info("Connecting to SQL Server ... ");
            try (Connection connection = DriverManager.getConnection(url)) {
                try (Statement statement = connection.createStatement()) {
                    statement.executeUpdate(script);
                    logger.info("SQL scripst " + sql + " Complete!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Step("Создаю расписание для врача")
    public static void createSheduleDisp(int LPUDoctorID, int DocPRVDID) {
        String request = null;
        try {
            request = new DateGenerator().Shedule_Disp(LPUDoctorID, DocPRVDID);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String url = connectionUrl +
                ";databaseName=" + databaseName +
                ";user=" + userName +
                ";password=" + password;
        try {
            logger.info("Connecting to SQL Server ... ");
            try (Connection connection = DriverManager.getConnection(url)) {
                try (Statement statement = connection.createStatement()) {
                    statement.executeUpdate(request);
                    logger.info("Complete!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Step("Создаю расписание для врача")
    public static void createSheduleCD(int LPUDoctorID, int DocPRVDID)   {
        String request = null;
        try {
            request = new DateGenerator().shedule_CD(LPUDoctorID, DocPRVDID);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String url = connectionUrl +
                ";databaseName=" + databaseName +
                ";user=" + userName +
                ";password=" + password;
        try {
            logger.info("Connecting to SQL Server ... " + url);
            try (Connection connection = DriverManager.getConnection(url)) {
                try (Statement statement = connection.createStatement()) {
                    statement.executeUpdate(request);
                    logger.info("Complete!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("Создал расписание у LPUDoctorID: " + LPUDoctorID + " DocPRVDID: " + DocPRVDID);
    }

//    @Step("отменяю созданный вызов после каждого теста")
//    public static void cancelCall(String methodName) {
//        String url = connectionUrl +
//                ";databaseName=" + databaseName +
//                ";user=" + userName +
//                ";password=" + password;
//        try {
//            logger.info("Connecting to SQL Server ... ");
//            try (Connection connection = DriverManager.getConnection(url)) {
//                String sql =
//                        "update hlt_calldoctor set rf_calldoctorstatusid = 4 where CallDoctorID = " + cardMap.get(methodName);
//                if (cardMap.get(methodName) != null && cardMap.get(methodName) > 0) {
//                    try (Statement statement = connection.createStatement()) {
//                        statement.executeUpdate(sql);
//                        logger.info("Вызов взят из стека и отменён!");
//                    }
//                } else {
//                    logger.info("вызов не отменен!: " + cardMap.get(methodName));
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

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