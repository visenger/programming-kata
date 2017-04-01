package de.bhtb.external.data.dao.postgresql;

import de.bhtb.external.data.dao.entities.Customer;
import de.bhtb.external.data.dao.entities.CustomerDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by visenger on 28/03/17.
 */
public class PostgresqlCulstomerDAO implements CustomerDAO {
    Connection con = null;

    public PostgresqlCulstomerDAO(Connection con) {
        this.con = con;
    }

    @Override
    public int insertCustomer(Customer customer) {
        int inserted = -1;

        return inserted;
    }

    @Override
    public boolean deleteCustomer(Customer customer) {
        return false;
    }

    @Override
    public Customer findCustomer(String id) {
        Customer customer = null;
        String query = String.format("SELECT tid, a, b FROM tb_simpleabc WHERE tid=%s;", id);
        //A Statement is an interface that represents an SQL statement.
        try (Statement stmt = con.createStatement()) {
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {
                int tid = result.getInt("tid");
                String a = result.getString("a");
                customer = new Customer(tid, a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        return false;
    }
}
