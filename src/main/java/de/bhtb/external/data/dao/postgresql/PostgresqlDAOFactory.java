package de.bhtb.external.data.dao.postgresql;

import de.bhtb.external.data.dao.DAOFactory;
import de.bhtb.external.data.dao.entities.CustomerDAO;
import de.bhtb.external.data.dao.entities.OrderDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Postgresql concrete DAO Factory implementation;
 */
public class PostgresqlDAOFactory extends DAOFactory {
    Connection con = null;

    public static final String URL = "jdbc:postgresql://localhost:5432/unittest";

    public PostgresqlDAOFactory() {
        try {
            con = getConnection("tester", "tester");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Connection getConnection(String userName, String pwd) throws SQLException, ClassNotFoundException {
       // Class.forName("org.postgresql.Driver");
        DriverManager.registerDriver(new org.postgresql.Driver());
        //todo: Best practises: Use connection pool to obtain a connection;
        return DriverManager.getConnection(URL, userName, pwd);
    }

    @Override
    public CustomerDAO getCustomerDAO() {
        return new PostgresqlCulstomerDAO(con);
    }

    @Override
    public OrderDAO getOrderDAO() {
        return new PostgresqlOrderDAO(con);
    }
}
