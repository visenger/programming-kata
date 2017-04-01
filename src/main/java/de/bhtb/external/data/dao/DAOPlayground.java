package de.bhtb.external.data.dao;

import de.bhtb.external.data.dao.entities.Customer;
import de.bhtb.external.data.dao.entities.CustomerDAO;

import java.util.Optional;


public class DAOPlayground {

    public static void main(String... args) {
        Optional<DAOFactory> daoFactory = DAOFactory.getDAOFactory(Type.POSTGRESQL);
        Optional<Customer> customer = daoFactory.map(factory -> {
            CustomerDAO customerDAO = factory.getCustomerDAO();
            Customer customerEntity = customerDAO.findCustomer("5");
            return customerEntity;
        });

        System.out.printf("the customer results: %s", customer.get().getName());
    }
}
