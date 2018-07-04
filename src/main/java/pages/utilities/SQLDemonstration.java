package pages.utilities;

import io.qameta.allure.Step;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SQLDemonstration {
    static String connectionUrl = "jdbc:sqlserver://12.8.1.66";
    static String databaseName = "hlt_demonstration";
    static String userName = "sa";
    static String password = "sagfhjkzYES!";

    @Step
    public static void deleteShedule(String name) {
        String url = connectionUrl +
                ";databaseName=" + databaseName +
                ";user=" + userName +
                ";password=" + password;
        try {
            System.out.println("Connecting to SQL Server ... ");
            try (Connection connection = DriverManager.getConnection(url)) {
                String sql =
                        "delete hlt_DoctorTimeTable from hlt_DoctorTimeTable dtt left outer join hlt_LPUDoctor ldoc " +
                                "on dtt.rf_LPUDoctorID = ldoc.LPUDoctorID " +
                                "where dtt.Date >= DATEADD(dd, ((DATEDIFF(dd, '17530101', GETDATE()) / 7) * 7) - 7, '17530101') " +
                                "AND ldoc.FAM_V = '" + name + "'";

                try (Statement statement = connection.createStatement()) {
                    statement.executeUpdate(sql);
                    System.out.println("Doctor Time Table clean is done.");
                    statement.close();
                }
            }
        } catch (Exception e) {
            System.out.println();
            e.printStackTrace();
        }
    }

    @Step("Завершаю все существующие вызовы")
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

    @Step("Завершаю вызовы этого врача")
    public static void finalizeCallLpuDoctor(String doctorName) {
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
                                "from hlt_CallDoctor cd  inner join hlt_LPUDoctor ldoc on cd.rf_LPUDoctorID = ldoc.LPUDoctorID " +
                                "where ldoc.FAM_V = '" + doctorName + "'";

                try (Statement statement = connection.createStatement()) {
                    statement.executeUpdate(sql);
                    System.out.println("Doctor - " + doctorName + " finalize is done.");
                }
            }
        } catch (Exception e) {
            System.out.println();
            e.printStackTrace();
        }
    }

    @Step("Завершаю вызовы пациента по имени")
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

    @Step("Завершаю вызовы пациента по полису")
    public static void finalizePacientNumberPol(String NumberPol) {
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
                                "where NumberPol = '" + NumberPol + "'";

                try (Statement statement = connection.createStatement()) {
                    statement.executeUpdate(sql);
                    System.out.println("Pacient - " + NumberPol + " finalize is done.");
                }
            }
        } catch (Exception e) {
            System.out.println();
            e.printStackTrace();
        }
    }
}