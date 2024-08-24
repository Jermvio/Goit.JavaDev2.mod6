import entities.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {

    public String sqlToString(String pathToSqlFile) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(pathToSqlFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
       return sb.toString();
    }

    public ResultSet getSetFromSql(String sql) {
        ResultSet resultSet;
        try {
            Statement statement = Database.getInstance().getConnection().createStatement();
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultSet;
    }

    public List<LongestProjects> findLongestProjects() {

        ResultSet resultSet = getSetFromSql(sqlToString("src/sql/find_longest_project.sql"));
        List<LongestProjects> longestProjectsList = new ArrayList<>();

        try {
            while (resultSet.next()) {
                LongestProjects lp = new LongestProjects();

                lp.setId(resultSet.getInt("id"));
                lp.setLengthInMonths(resultSet.getLong("length_in_months"));
                longestProjectsList.add(lp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return longestProjectsList;
    }

    public List<MaxProjectsClients> findMaxProjectsPerClient() {
        ResultSet resultSet = getSetFromSql(sqlToString("src/sql/find_max_projects_client.sql"));
        List<MaxProjectsClients> maxProjectsClientsList = new ArrayList<>();

        try {
            while (resultSet.next()) {
                MaxProjectsClients mpc = new MaxProjectsClients();

                mpc.setName(resultSet.getString("name"));
                mpc.setProjectsCount(resultSet.getInt("frequency"));
                maxProjectsClientsList.add(mpc);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return maxProjectsClientsList;
    }

    public List<MaxSalaryWorkers> findMaxSalaryWorker() {
        ResultSet resultSet = getSetFromSql(sqlToString("src/sql/find_max_salary_worker.sql"));
        List<MaxSalaryWorkers> maxSalaryWorkersList = new ArrayList<>();

        try {
            while (resultSet.next()) {
                MaxSalaryWorkers msw = new MaxSalaryWorkers();

                msw.setName(resultSet.getString("name"));
                msw.setSalary(resultSet.getInt("salary"));
                maxSalaryWorkersList.add(msw);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return maxSalaryWorkersList;
    }

    public List<YoungestEldestWorkers> findYoungestEldestWorkers() {
        ResultSet resultSet = getSetFromSql(sqlToString("src/sql/find_youngest_eldest_workers.sql"));
        List<YoungestEldestWorkers> youngestEldestWorkersList = new ArrayList<>();

        try {
            while (resultSet.next()) {
                YoungestEldestWorkers yew = new YoungestEldestWorkers();

                yew.setName(resultSet.getString("name"));
                yew.setBirthday(resultSet.getDate("birthday"));
                youngestEldestWorkersList.add(yew);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return youngestEldestWorkersList;
    }

    public List<ProjectPrices> findProjectPrices() {
        ResultSet resultSet = getSetFromSql(sqlToString("src/sql/print_project_prices.sql"));
        List<ProjectPrices> projectPricesList = new ArrayList<>();

        try {
            while (resultSet.next()) {
                ProjectPrices pp = new ProjectPrices();

                pp.setId(resultSet.getInt("project_id"));
                pp.setCost(resultSet.getInt("project_cost"));
                projectPricesList.add(pp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return projectPricesList;
    }

}
