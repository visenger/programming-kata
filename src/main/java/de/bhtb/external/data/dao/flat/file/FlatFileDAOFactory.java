package de.bhtb.external.data.dao.flat.file;

import de.bhtb.external.data.dao.DAOFactory;
import de.bhtb.external.data.dao.entities.CustomerDAO;
import de.bhtb.external.data.dao.entities.OrderDAO;

/**
 * Created by visenger on 28/03/17.
 */
public class FlatFileDAOFactory extends DAOFactory {

    private String pathForCustomerFile = "???";
    private String pathForOrderFile = "???";

    @Override
    public CustomerDAO getCustomerDAO() {
        return new FlatFileCustomerDAO(pathForCustomerFile);
    }

    @Override
    public OrderDAO getOrderDAO() {
        return new FlatFileOrderDAO(pathForOrderFile);
    }
}
