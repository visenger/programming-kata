package de.bhtb.external.data.dao.flat.file;

import de.bhtb.external.data.dao.entities.Order;
import de.bhtb.external.data.dao.entities.OrderDAO;

/**
 * Created by visenger on 28/03/17.
 */
public class FlatFileOrderDAO implements OrderDAO {
    private String path = "";

    public FlatFileOrderDAO(String pathForOrderFile) {
        this.path = pathForOrderFile;
    }

    @Override
    public int insertOrder(Order order) {
        return 0;
    }

    @Override
    public boolean deleteOrder(Order order) {
        return false;
    }

    @Override
    public Order findOrder(String id) {
        return null;
    }

    @Override
    public boolean updateOrder(Order order) {
        return false;
    }
}
