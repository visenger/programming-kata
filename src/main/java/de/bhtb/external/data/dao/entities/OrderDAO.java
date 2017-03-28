package de.bhtb.external.data.dao.entities;

/**
 * Created by visenger on 28/03/17.
 */
public interface OrderDAO {

    public int insertOrder( Order order);

    public boolean deleteOrder( Order order);

    public Order findOrder(String id);

    public boolean updateOrder( Order order);
}
