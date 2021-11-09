package dao;

import bean.CartItem;

import java.util.List;


public interface CartShowDao {
    public List<CartItem> findAll(int id);
}
