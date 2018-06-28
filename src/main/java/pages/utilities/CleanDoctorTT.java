package pages.utilities;

import io.qameta.allure.Step;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CleanDoctorTT {
    static String connectionUrl = "jdbc:sqlserver://12.8.1.66";
    static String databaseName = "hlt_demonstration";
    static String userName = "sa";
    static String password = "sagfhjkzYES!";

    @Step
    public static void deleteShedule(String name) throws ClassNotFoundException {
        System.out.println("Start clean base - " + name);
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
                                "AND ldoc.FAM_V = '" + name + "'";

                try (Statement statement = connection.createStatement()) {
                    statement.executeUpdate(sql);
                    System.out.println("Clean is done.");
                    statement.close();
                }
            }
        } catch (Exception e) {
            System.out.println();
            e.printStackTrace();
        }
    }

    @Step
    public void finalizeCallDoctor() throws ClassNotFoundException {
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
}