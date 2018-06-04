package pages.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CleanDoctorTimeTableSQL {
    String connectionUrl = "jdbc:sqlserver://12.8.1.66";
    String databaseName = "hlt_demonstration";
    String userName = "sa";
    String password = "sagfhjkzYES!";

//    String connectionUrl = "jdbc:sqlserver://12.8.1.62";
//    String databaseName = "test_emias";
//    String userName = "sa";
//    String password = "b635Oap5YE33k1S";

    public void deleteShedule(String name) throws ClassNotFoundException {
        System.out.println("Clean base - " + name);
        String url = this.connectionUrl +
                ";databaseName=" + this.databaseName +
                ";user=" + this.userName +
                ";password=" + this.password;
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
                    System.out.println("Done.");
                }
                System.out.println("Clean is done.\n");
            }
        } catch (Exception e) {
            System.out.println();
            e.printStackTrace();
        }
    }


    public void finalizeCallDoctor() throws ClassNotFoundException {
        String url = this.connectionUrl +
                ";databaseName=" + this.databaseName +
                ";user=" + this.userName +
                ";password=" + this.password;
        try {
            System.out.print("Connecting to SQL Server ... ");
            try (Connection connection = DriverManager.getConnection(url)) {
                String sql =
                        "update hlt_calldoctor set rf_calldoctorstatusid = 3";

                try (Statement statement = connection.createStatement()) {
                    statement.executeUpdate(sql);
                    System.out.println("Done.");
                }
                System.out.println("Clean is done.\n");
            }
        } catch (Exception e) {
            System.out.println();
            e.printStackTrace();
        }
    }
}

// Configure Hibernate logging to only log SEVERE errors
//        @SuppressWarnings("unused")
//        org.jboss.logging.Logger logger = org.jboss.logging.Logger.getLogger("org.hibernate");
//        java.util.logging.Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.SEVERE);
//
//        System.out.println("**Java CRUD sample with Hibernate and SQL Server **\n");
//        try {
//            // We're creating the Hibernate configuration via code. An alternative is to use a 'hibernate.cfg.xml' file.
//            Configuration cfg = createHibernateConfiguration();
//
//            // We're mapping POJO classes to Tables via Hibernate Annotations. An alternative is to use Hibernate mapping xml files.
//            cfg.addAnnotatedClass(User.class);
//            cfg.addAnnotatedClass(Task.class);
//
//            // Hibernate needs an existing database. Use JDBC to create one for this sample.
//            createSampleDatabase();
//
//            // Create the Hibernate SessionFactory and Session.
//            // This causes Hibernate to create Tables and Relationships in the database from our Annotated classes.
//            try (SessionFactory sessionFactory = cfg.buildSessionFactory();
//                 Session session = sessionFactory.openSession()) {
//
//                System.out.println("Created database schema from Java classes.\n");
//                session.beginTransaction();
//
//                // Create demo: Create a User instance and save it to the database
//                User newUser = new User("Anna", "Shrestinian");
//                session.save(newUser);
//                System.out.println("Created User: " + newUser.toString());
//
//                // Create demo: Create a Task instance and save it to the database
//                SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
//                Task newTask = new Task("Ship Helsinki", sdf.parse("04-01-2017"));
//                session.save(newTask);
//                System.out.println("Created Task: " + sessionFactory.toString());
//
//                // Association demo: Assign task to user
//                newTask.setUser(newUser);
//                session.save(newTask);
//                System.out.println("Assigned Task: '" + newTask.getTitle() + "' to user '" + newUser.getFullName() + "'\n");
//
//                // Read demo: find incomplete tasks assigned to user 'Anna'
//                System.out.println("Incomplete tasks assigned to 'Anna':");
//                String hqlQuery = "from Task where isComplete = false and user.firstName = :paramFirstName";
//                List<Task> incompleteTasks = session.createQuery(hqlQuery, Task.class)
//                        .setParameter("paramFirstName", "Anna")
//                        .getResultList();
//                for (Task theTask : incompleteTasks) {
//                    System.out.println(theTask.toString());
//                }
//
//                // Update demo: change the 'dueDate' of a task
//                hqlQuery = "from Task";
//                Task taskToUpdate = session.createQuery(hqlQuery, Task.class)
//                        .getResultList()
//                        .get(0); // get the first task
//                System.out.println("\nUpdating task: " + taskToUpdate.toString());
//                taskToUpdate.setDueDate(sdf.parse("06-30-2016"));
//                session.save(taskToUpdate);
//                System.out.println("dueDate changed: " + taskToUpdate.toString());
//
//                // Delete demo: delete all tasks with a dueDate in 2016
//                System.out.println("\nDeleting all tasks with a dueDate in 2016");
//                hqlQuery = "from Task where dueDate < :paramDate";
//                List<Task> tasksToDelete = session.createQuery(hqlQuery, Task.class)
//                        .setParameter("paramDate", sdf.parse("12-31-2016"))
//                        .getResultList();
//                for (Task theTask : tasksToDelete) {
//                    System.out.println("Deleting task:" + theTask.toString());
//                    session.delete(theTask);
//                }
//
//                // Show tasks after the 'Delete' operation - there should be 0 tasks
//                System.out.println("\nTasks after delete:");
//                hqlQuery = "from Task";
//                List<Task> tasksAfterDelete = session.createQuery(hqlQuery, Task.class)
//                        .getResultList();
//                if (tasksAfterDelete.isEmpty()) {
//                    System.out.println("[None]");
//                } else {
//                    for (Task theTask : tasksAfterDelete) {
//                        System.out.println(theTask.toString());
//                    }
//                }
//
//                session.getTransaction().commit();
//            }
//            System.out.println("All done.");
//
//        } catch (Exception e) {
//            System.out.println();
//            e.printStackTrace();
//        }
//    }


//        private void createSampleDatabase () throws java.sql.SQLException {
//        // Load SQL Server JDBC driver and establish connection.
//        String url = this.connectionUrl + ";databaseName=master;" + "user=" + this.userName + ";password="
//                + this.password;

//        System.out.print("Connecting to SQL Server ... ");
//        try (Connection connection = DriverManager.getConnection(url)) {
//            System.out.println("Done.");
//            System.out.print("Dropping and creating database '" + this.sampleDatabaseName + "' ... ");
//            String sql = "DROP DATABASE IF EXISTS [" + this.sampleDatabaseName + "]; CREATE DATABASE ["
//                    + this.sampleDatabaseName + "]";
//            try (Statement statement = connection.createStatement()) {
//                statement.executeUpdate(sql);
//                System.out.println("Done.\n");
//            }
//        }
//        }


//    private Configuration createHibernateConfiguration() {
//        String url = this.connectionUrl + ";databaseName=" + this.sampleDatabaseName;
//        Configuration cfg = new Configuration()
//                .setProperty("hibernate.connection.driver_class", "com.microsoft.sqlserver.jdbc.SQLServerDriver")
//                .setProperty("hibernate.connection.url", url)
//                .setProperty("hibernate.connection.username", this.userName)
//                .setProperty("hibernate.connection.password", this.password)
//                .setProperty("hibernate.connection.autocommit", "true")
//                .setProperty("hibernate.show_sql", "false");
//
//        // Tell Hibernate to use the 'SQL Server' dialect when dynamically
//        // generating SQL queries
//        cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.SQLServerDialect");
//
//        // Tell Hibernate to show the generated T-SQL
//        cfg.setProperty("hibernate.show_sql", "false");
//
//        // This is ok during development, but not recommended in production
//        // See: http://stackoverflow.com/questions/221379/hibernate-hbm2ddl-auto-update-in-production
//        cfg.setProperty("hibernate.hbm2ddl.auto", "update");
//        return cfg;
//    }
//    }
