import DTO.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

public class DatabaseQueryService {
    public static void main(String[] args) throws SQLException, IOException {
        Connection connection = Database.getInstance().getConnection();

        find_max_salary_worker(connection);
        find_max_projects_client(connection);
        find_longest_project(connection);
        find_youngest_eldest_workers(connection);
        print_project_prices(connection);

        Database.getInstance().closeConnection();
    }
    public static ArrayList find_max_salary_worker(Connection connection) throws SQLException, IOException {
        String query  = Files.readString(Path.of("sql/find_max_salary_worker.sql"));
        ArrayList <Worker> max_salary_list = new ArrayList<Worker>();

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while(rs.next()) {

                Worker max_salary = new Worker(rs.getString("ID"),
                        rs.getString("name"),
                        rs.getString("LEVEL"),
                        LocalDate.parse(rs.getString("BIRTHDAY")),
                        rs.getString("SALARY"));

                max_salary_list.add(max_salary);
            }

            System.out.println(max_salary_list);
            System.out.println("Successfully create tables");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("False find_max_salary_worker");
        }
        return max_salary_list;
    }
    public static ArrayList find_max_projects_client(Connection connection) throws SQLException, IOException {
        String query  = Files.readString(Path.of("sql/find_max_projects_client.sql"));
        ArrayList <MaxProjectsClient> max_projects_list = new ArrayList<MaxProjectsClient>();

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while(rs.next()) {

                MaxProjectsClient max_projects = new MaxProjectsClient(rs.getString("name"),
                        rs.getString("PROJECT_COUNT"));
                max_projects_list.add(max_projects);
            }
                    } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("False find_max_projects_client");
        }
        return  max_projects_list;
    }
    public static ArrayList find_longest_project(Connection connection) throws SQLException, IOException {
        String query  = Files.readString(Path.of("sql/find_longest_project.sql"));
        ArrayList <LongestProject> longest_project_list = new ArrayList<LongestProject>();

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while(rs.next()) {

                LongestProject longest_project = new LongestProject(rs.getString("ID"),
                        rs.getString("MONTH_COUNT"));

                longest_project_list.add(longest_project);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("False find_longest_project");
        }
        return longest_project_list;
    }
    public static ArrayList find_youngest_eldest_workers(Connection connection) throws SQLException, IOException {
        String query  = Files.readString(Path.of("sql/find_youngest_eldest_workers.sql"));
        ArrayList <YoungestEldestWorkers> youngest_eldest_workers_list = new ArrayList<YoungestEldestWorkers>();

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while(rs.next()) {

                YoungestEldestWorkers youngest_eldest_workers = new YoungestEldestWorkers(rs.getString("TYPE"),
                rs.getString("name"),
                        LocalDate.parse(rs.getString("BIRTHDAY")));

                youngest_eldest_workers_list.add(youngest_eldest_workers);

            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("False find_youngest_eldest_workers");
        }
        return youngest_eldest_workers_list;
    }
    public static ArrayList print_project_prices(Connection connection) throws SQLException, IOException {
        String query  = Files.readString(Path.of("sql/print_project_prices.sql"));
        ArrayList <ProjectPrices> project_prices_list = new ArrayList<ProjectPrices>();

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while(rs.next()) {

                ProjectPrices project_prices = new ProjectPrices(rs.getString("ID"),
                        rs.getString("PRICE"));

                project_prices_list.add(project_prices);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("False print_project_prices");
        }
        return project_prices_list;
    }
}





