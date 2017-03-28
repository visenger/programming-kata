package de.bhtb.external.data.dao.postgresql;

import de.bhtb.external.data.dao.entities.Order;
import de.bhtb.external.data.dao.entities.OrderDAO;

import java.sql.Connection;

/**
 * Created by visenger on 28/03/17.
 */
public class PostgresqlOrderDAO implements OrderDAO {
    private Connection connection = null;

    public PostgresqlOrderDAO(Connection con) {
        this.connection = con;
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
