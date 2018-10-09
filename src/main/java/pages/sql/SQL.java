package pages.sql;

import io.qameta.allure.Step;
import pages.AbstractPage;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;

public class SQL extends AbstractPage {
    private static String connectionUrl = "jdbc:sqlserver://12.8.1.66";
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
            System.out.print("Connecting to SQL Server ... ");
            try (Connection connection = DriverManager.getConnection(url)) {
                String sql =
                        "delete hlt_DoctorTimeTable from hlt_DoctorTimeTable dtt left outer join hlt_LPUDoctor ldoc " +
                                "on dtt.rf_LPUDoctorID = ldoc.LPUDoctorID " +
                                "where dtt.Date >= DATEADD(dd, ((DATEDIFF(dd, '17530101', GETDATE()) / 7) * 7) - 7, '17530101') " +
                                "AND ldoc.FAM_V = '" + fam + "'";

                try (Statement statement = connection.createStatement()) {
                    statement.executeUpdate(sql);
                    System.out.println("Table DTT is clean.");
                    statement.close();
                }
            }
        } catch (Exception e) {
            System.out.println();
            e.printStackTrace();
        }
    }

    @Step("завершаю все существующие вызовы")
    public static void finalizeAllCalls() {
        String url = connectionUrl +
                ";databaseName=" + databaseName +
                ";user=" + userName +
                ";password=" + password;
        try {
            System.out.print("Connecting to SQL Server ... ");
            try (Connection connection = DriverManager.getConnection(url)) {
                String sql =
                        "update hlt_calldoctor set rf_calldoctorstatusid = 3";

                try (Statement statement = connection.createStatement()) {
                    statement.executeUpdate(sql);
                    System.out.println("Finalize is done.");
                }
            }
        } catch (Exception e) {
            System.out.println();
            e.printStackTrace();
        }
    }

    @Step("завершаю все существующие вызовы")
    public static void finalizeAllTestCalls() {
        String url = connectionUrl +
                ";databaseName=" + databaseName +
                ";user=" + userName +
                ";password=" + password;
        try {
            System.out.print("Connecting to SQL Server ... ");
            try (Connection connection = DriverManager.getConnection(url)) {
                String sql =
                        "update hlt_calldoctor " +
                                "set rf_CallDoctorStatusID = 3 " +
                                "where rf_CallDoctorStatusID != 3 " +
                                "and Complaint like '%тест%'";

                try (Statement statement = connection.createStatement()) {
                    statement.executeUpdate(sql);
                    System.out.println("Finalize is done.");
                }
            }
        } catch (Exception e) {
            System.out.println();
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
            System.out.print("Connecting to SQL Server ... ");
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
                    System.out.println("Doctor: " + doctorName + " is finalize.");
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
            System.out.print("Connecting to SQL Server ... ");
            try (Connection connection = DriverManager.getConnection(url)) {
                String sql =
                        "update hlt_CallDoctor " +
                                "set rf_CallDoctorStatusID = 3 " +
                                "where Name = '" + pacientName + "'";

                try (Statement statement = connection.createStatement()) {
                    statement.executeUpdate(sql);
                    System.out.println("Pacient - " + pacientName + " finalize is done.");
                }
            }
        } catch (Exception e) {
            System.out.println();
            e.printStackTrace();
        }
    }

    @Step("завершаю вызовы пациента по полису")
    public static void finalizeCall_NPol(int number) {
//        File reader = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\" + profile + ".json");
//        Map proData = new ObjectMapper().readValue(reader, Map.class);

        String url = connectionUrl +
                ";databaseName=" + databaseName +
                ";user=" + userName +
                ";password=" + password;
        try {
            System.out.print("Connecting to SQL Server ... ");
            try (Connection connection = DriverManager.getConnection(url)) {
                String sql =
                        "update hlt_CallDoctor " +
                                "set rf_CallDoctorStatusID = 3 " +
                                "where numberPol = '" + number + "'";

                try (Statement statement = connection.createStatement()) {
                    statement.executeUpdate(sql);
                    System.out.println("Pacient - " + number + " finalize is done.");
                }
            }
        } catch (Exception e) {
            System.out.println();
            e.printStackTrace();
        }
        System.out.println("Вызов завершен для портала!");
    }

    @Step("Сбросить мероприятия у карты вызова")
    public static void setDefaultServices(String cardID) { // TODO: 04.09.2018 доделать обнуление заключения
        String url = connectionUrl +
                ";databaseName=" + databaseName +
                ";user=" + userName +
                ";password=" + password;
        try {
            System.out.print("Connecting to SQL Server ... ");
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
                    System.out.println("Card: " + cardID + " is default!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Step("Запуск скрипта на демонстрейшн")
    public static void runSqlScript(String sql) throws FileNotFoundException {
        FileInputStream fstream = new FileInputStream("src/main/resources/sql/" + sql);
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

        String url = connectionUrl +
                ";databaseName=" + databaseName +
                ";user=" + userName +
                ";password=" + password;
        try {
            System.out.print("Connecting to SQL Server ... ");
            try (Connection connection = DriverManager.getConnection(url)) {
                String sql2 = br.readLine();
                try (Statement statement = connection.createStatement()) {
                    statement.executeUpdate(sql2);
                    System.out.println("SQL scripst " + sql + " Complete!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Step("Запуск скрипта на демонстрейшн")
    public static void runSqlScriptCD(String path) throws FileNotFoundException {
        FileInputStream fstream = new FileInputStream(path);
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

        String url = connectionUrl +
                ";databaseName=" + databaseName +
                ";user=" + userName +
                ";password=" + password;
        try {
            System.out.print("Connecting to SQL Server ... ");
            try (Connection connection = DriverManager.getConnection(url)) {
                String sql2 = br.readLine();
                try (Statement statement = connection.createStatement()) {
                    statement.executeUpdate(sql2);
                    System.out.println("SQL scripst Complete!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getScripts() throws FileNotFoundException {
        File dir = new File("src/main/resources/sql/calldoctor");
//        File dir = new File(SQLDemonstration.class.getClassLoader().getResource("sql/calldoctor").getFile());
        File[] files = dir.listFiles();
        File[] scriptList = files;
        for (File script : scriptList) {
            runSqlScriptCD(script.toString());
        }
    }

    @Step("Создаю расписание для врача {docprvdid} (Ай Бо Лит АвтоТест)")
    public static void createShedule(String docprvdid) throws FileNotFoundException {
        //сгенерировать одну ячейку на сегодня
        FileInputStream fstream = new FileInputStream("src/main/resources/sql/" + "select_top_10000___from_hlt_DoctorTimeTa.tsv");
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

        String url = connectionUrl +
                ";databaseName=" + databaseName +
                ";user=" + userName +
                ";password=" + password;
        try {
            System.out.print("Connecting to SQL Server ... ");
            try (Connection connection = DriverManager.getConnection(url)) {

                String sql2 = br.readLine();

                try (Statement statement = connection.createStatement()) {
                    statement.executeUpdate(sql2);
                    System.out.println("Complete!");
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
            System.out.print("Connecting to SQL Server ... ");
            try (Connection connection = DriverManager.getConnection(url)) {
                String sql =
                        "delete hlt_DoctorTimeTable from hlt_DoctorTimeTable where rf_DocPRVDID = '1285'";
                try (Statement statement = connection.createStatement()) {
                    statement.executeUpdate(sql);
                    System.out.println("Table DTT is clean.");
                    statement.close();
                }
            }
        } catch (Exception e) {
            System.out.println();
            e.printStackTrace();
        }
    }
}