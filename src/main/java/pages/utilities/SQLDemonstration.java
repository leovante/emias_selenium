package pages.utilities;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Step;
import pages.AbstractPage;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Map;

public class SQLDemonstration extends AbstractPage {
    private static String connectionUrl = "jdbc:sqlserver://12.8.1.66";
    private static String databaseName = "hlt_demonstration";
    private static String userName = "sa";
    private static String password = "sagfhjkzYES!";

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
            System.out.println("Connecting to SQL Server ... ");
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
            System.out.println("Connecting to SQL Server ... ");
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
            System.out.println("Connecting to SQL Server ... ");
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
    public static void finalizePacientNumberPol(String profile) throws IOException {
        File reader = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\" + profile + ".json");
        Map proData = new ObjectMapper().readValue(reader, Map.class);

        String url = connectionUrl +
                ";databaseName=" + databaseName +
                ";user=" + userName +
                ";password=" + password;
        try {
            System.out.println("Connecting to SQL Server ... ");
            try (Connection connection = DriverManager.getConnection(url)) {
                String sql =
                        "update hlt_CallDoctor " +
                                "set rf_CallDoctorStatusID = 3 " +
                                "where NumberPol = '" + proData.get("nomerPol") + "'";

                try (Statement statement = connection.createStatement()) {
                    statement.executeUpdate(sql);
                    System.out.println("Pacient - " + proData.get("nomerPol") + " finalize is done.");
                }
            }
        } catch (Exception e) {
            System.out.println();
            e.printStackTrace();
        }
    }


}