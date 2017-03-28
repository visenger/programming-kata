package de.bhtb.external.data.dao.flat.file;

import de.bhtb.external.data.dao.entities.Customer;
import de.bhtb.external.data.dao.entities.CustomerDAO;

/**
 * Created by visenger on 28/03/17.
 */
public class FlatFileCustomerDAO implements CustomerDAO {
    private String path = "";

    public FlatFileCustomerDAO(String pathForCustomerFile) {
        this.path = pathForCustomerFile;
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
