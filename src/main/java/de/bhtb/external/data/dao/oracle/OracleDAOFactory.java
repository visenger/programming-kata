package de.bhtb.external.data.dao.oracle;

import de.bhtb.external.data.dao.DAOFactory;
import de.bhtb.external.data.dao.entities.CustomerDAO;
import de.bhtb.external.data.dao.entities.OrderDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by visenger on 28/03/17.
 */
public class OracleDAOFactory extends DAOFactory {
    Connection con = null;

    public static final String URL = "jdbc:postgresql://localhost:5432/unittest";

    public OracleDAOFactory() {
        try {
            this.con = getConnection("user", "xxx");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Connection getConnection(String user, String pwd) throws SQLException {
        return DriverManager.getConnection(URL, user, pwd);
    }

    @Override
    public CustomerDAO getCustomerDAO() {
        return new OracleCustomerDAO(con);
    }

    @Override
    public OrderDAO getOrderDAO() {
        return new OracleOrderDAO(con);
    }
}
