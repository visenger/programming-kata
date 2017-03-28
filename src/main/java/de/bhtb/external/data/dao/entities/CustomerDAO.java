package de.bhtb.external.data.dao.entities;

/**
 * Created by visenger on 28/03/17.
 */
public interface CustomerDAO {

    public int insertCustomer(Customer customer);

    public boolean deleteCustomer(Customer customer);

    public Customer findCustomer(String id);

    public boolean updateCustomer(Customer customer);

}
