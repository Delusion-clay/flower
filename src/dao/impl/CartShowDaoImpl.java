package dao.impl;

import bean.CartItem;
import dao.CartShowDao;

import java.util.List;


public class CartShowDaoImpl extends BaseDao implements CartShowDao {
    @Override
    public List<CartItem> findAll(int id) {
        String sql = "select * from cart where id=?";
        return queryForList(CartItem.class,sql,id);
    }
}
