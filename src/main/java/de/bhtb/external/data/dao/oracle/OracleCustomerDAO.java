package de.bhtb.external.data.dao.oracle;

import de.bhtb.external.data.dao.entities.Customer;
import de.bhtb.external.data.dao.entities.CustomerDAO;

import java.sql.Connection;

/**
 * Created by visenger on 28/03/17.
 */
public class OracleCustomerDAO implements CustomerDAO {
    private Connection connection = null;

    public OracleCustomerDAO(Connection con) {
        this.connection = con;
    }

    @Override
    public int insertCustomer(Customer customer) {
        return 0;
    }

    @Override
    public boolean deleteCustomer(Customer customer) {
        return false;
    }

    @Override
    public Customer findCustomer(String id) {
        return null;
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        return false;
    }
}
