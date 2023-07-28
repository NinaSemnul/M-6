import DTO.Client;
import DTO.Project;
import DTO.ProjectWorker;
import DTO.Worker;

import java.sql.Connection;
import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.SQLException;

public class PreparedStatement {


    public static void main(String[] args) throws SQLException, IOException, ParseException {
        Connection connection = Database.getInstance().getConnection();

        find_min_max_salary_worker(connection, MinMax.MIN);  // +

        add_Workers(connection, addWorkersForTest());  // +
        find_all_worker(connection);  // +

        add_Clients(connection, add_ClientsForTest());  // +
        find_all_client(connection);  // +

        add_Projekts(connection, addProjektsForTest());  // +
        find_all_projekt(connection);  // +


        add_Projekt_Worker(connection, addProjektsWForTest());  // +
        find_all_projekt_worker(connection);  // +


        Database.getInstance().closeConnection();
    }

    public static ArrayList find_min_max_salary_worker(Connection connection, MinMax x) throws SQLException, IOException {

        String sqlTemplate = "SELECT * FROM worker WHERE SALARY = (SELECT " + x.toString() + "(SALARY) FROM worker)";
        ArrayList <Worker> min_max_salary_list = new ArrayList<Worker>();


        try {
            java.sql.PreparedStatement queryStatement = connection.prepareStatement(sqlTemplate);
            ResultSet rs = queryStatement.executeQuery();

            while(rs.next()) {

                Worker max_salary = new Worker(rs.getString("ID"),
                        rs.getString("name"),
                        rs.getString("LEVEL"),
                        LocalDate.parse(rs.getString("BIRTHDAY")),
                        rs.getString("SALARY"));

                min_max_salary_list.add(max_salary);
            }

            System.out.println(min_max_salary_list);
            System.out.println("Successfully create tables");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("False find_max_salary_worker");
        }
        return min_max_salary_list;
    }

    private static void add_Workers(Connection connection, ArrayList <Worker> workers) throws SQLException, IOException {
        String sqlTemplate  = "INSERT INTO worker(ID, name, birthday, level, salary) VALUES (?, ?, ?, ?, ?)";

        try {

            java.sql.PreparedStatement queryStatement = connection.prepareStatement(sqlTemplate);

            for (Worker worker:
                 workers) {
                queryStatement.setString(1, worker.getID());
                queryStatement.setString(2, worker.getName());
                queryStatement.setString(3, String.valueOf(worker.getBirthday()));
                queryStatement.setString(4, worker.getLEVEL());
                queryStatement.setString(5, worker.getSALARY());
                queryStatement.addBatch();

            }
            queryStatement.executeBatch();
            System.out.println("Successfully stuff table worker");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("False, no stuff table worker");
        }
    }

    private static void add_Clients(Connection connection, ArrayList <Client> clients) throws SQLException, IOException {
        String sqlTemplate  = "INSERT INTO client(ID, name) VALUES (?, ?) ";

        try {

            java.sql.PreparedStatement queryStatement = connection.prepareStatement(sqlTemplate);

            for (Client client:
                    clients) {
                queryStatement.setString(1, client.getID());
                queryStatement.setString(2, client.getName());
                queryStatement.addBatch();

            }
            queryStatement.executeBatch();
            System.out.println("Successfully stuff table client");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("False, no stuff table client");
        }
    }

    private static void add_Projekts(Connection connection, ArrayList <Project> projects) throws SQLException, IOException {
        String sqlTemplate  = "INSERT INTO project(ID, CLIENT_ID, START_DATE, FINISH_DATE) VALUES (?, ?, ?, ?)";

        try {

            java.sql.PreparedStatement queryStatement = connection.prepareStatement(sqlTemplate);

            for (Project project:
                    projects) {
                queryStatement.setString(1, project.getID());
                queryStatement.setString(2, project.getCLIENT_ID());
                queryStatement.setString(3, String.valueOf(project.getSTART_DATE()));
                queryStatement.setString(4, String.valueOf(project.getFINISH_DATE()));
                queryStatement.addBatch();

            }
            queryStatement.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void add_Projekt_Worker(Connection connection, ArrayList <ProjectWorker> projects) throws SQLException, IOException {
        String sqlTemplate  = "INSERT INTO PROJECT_WORKER(PROJECT_ID, WORKER_ID) VALUES (?, ?)";

        try {

            java.sql.PreparedStatement queryStatement = connection.prepareStatement(sqlTemplate);

            for (ProjectWorker project:
                    projects) {
                queryStatement.setString(1, project.getPROJECT_ID());
                queryStatement.setString(2, project.getWORKER_ID());
                queryStatement.addBatch();

            }
            queryStatement.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList addWorkersForTest() throws ParseException {
        ArrayList <Worker> workers = new ArrayList<>();

        Worker w = new Worker("88338","Gola Albul",  "Junior", LocalDate.parse("1998-10-14"), "600");
        workers.add(w);
        w = new Worker("16171","Amara Li",  "Junior", LocalDate.parse("1998-11-23"), "550");
        workers.add(w);

        return workers;
    }

    public static ArrayList add_ClientsForTest() throws ParseException {
        ArrayList <Client> clients = new ArrayList<Client>();

        Client c = new Client("10114","Samanta Li");
        clients.add(c);
        c = new Client("14114","Geordge Ai");
        clients.add(c);

        return clients;
    }

    public static ArrayList addProjektsForTest() throws ParseException {
        ArrayList <Project> Projects = new ArrayList<Project>();

        Project w = new Project("5481","14114", LocalDate.parse("2023-07-14"), LocalDate.parse("2023-10-14"));
        Projects.add(w);
        w = new Project("8541","10114", LocalDate.parse("2023-01-23"), LocalDate.parse("2023-11-14"));
        Projects.add(w);

        return Projects;
    }

    public static ArrayList addProjektsWForTest() throws ParseException {
        ArrayList <ProjectWorker> ProjectsW = new ArrayList<ProjectWorker>();

        ProjectWorker w = new ProjectWorker("5481","88338");
        ProjectsW.add(w);
        w = new ProjectWorker("8541","16171");
        ProjectsW.add(w);

        return ProjectsW;
    }
    public static ArrayList find_all_worker(Connection connection) throws SQLException, IOException {

        String sqlTemplate = "SELECT * FROM worker";
        ArrayList <Worker> all_worker = new ArrayList<Worker>();


        try {
            java.sql.PreparedStatement queryStatement = connection.prepareStatement(sqlTemplate);
            ResultSet rs = queryStatement.executeQuery();

            while(rs.next()) {

                Worker max_salary = new Worker(rs.getString("ID"),
                        rs.getString("name"),
                        rs.getString("LEVEL"),
                        LocalDate.parse(rs.getString("BIRTHDAY")),
                        rs.getString("SALARY"));

                all_worker.add(max_salary);
            }

            System.out.println(all_worker);
            System.out.println("Successfully create tables");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("False find_max_salary_worker");
        }
        return all_worker;
    }

    public static ArrayList find_all_client(Connection connection) throws SQLException, IOException {

        String sqlTemplate = "SELECT * FROM client";
        ArrayList <Client> all_Client = new ArrayList<Client>();


        try {
            java.sql.PreparedStatement queryStatement = connection.prepareStatement(sqlTemplate);
            ResultSet rs = queryStatement.executeQuery();

            while(rs.next()) {

                Client c = new Client(rs.getString("ID"),
                        rs.getString("name"));

                all_Client.add(c);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return all_Client;
    }

    public static ArrayList find_all_projekt(Connection connection) throws SQLException, IOException {

        String sqlTemplate = "SELECT * FROM project";
        ArrayList <Project> all_Project = new ArrayList<Project>();


        try {
            java.sql.PreparedStatement queryStatement = connection.prepareStatement(sqlTemplate);
            ResultSet rs = queryStatement.executeQuery();

            while(rs.next()) {

                Project p = new Project(rs.getString("ID"),
                        rs.getString("CLIENT_ID"),
                        LocalDate.parse(rs.getString("START_DATE")),
                        LocalDate.parse(rs.getString("FINISH_DATE")));

                all_Project.add(p);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return all_Project;
    }

    public static ArrayList find_all_projekt_worker(Connection connection) throws SQLException, IOException {

        String sqlTemplate = "SELECT * FROM PROJECT_WORKER";
        ArrayList <ProjectWorker> all_ProjectW = new ArrayList<ProjectWorker>();


        try {
            java.sql.PreparedStatement queryStatement = connection.prepareStatement(sqlTemplate);
            ResultSet rs = queryStatement.executeQuery();

            while(rs.next()) {

                ProjectWorker p = new ProjectWorker(rs.getString("PROJECT_ID"),
                        rs.getString("WORKER_ID"));

                all_ProjectW.add(p);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return all_ProjectW;
    }


};
