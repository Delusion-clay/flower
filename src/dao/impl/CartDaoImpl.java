package dao.impl;

import bean.CartItem;
import bean.Flower;
import dao.CartDao;

public class CartDaoImpl extends BaseDao implements CartDao {
    @Override
    public int addCart(CartItem cartItem) {
        String sql = "insert into flower.cart(`id`,`img_path`,`type`,`count`,`price`,`paymentMethod`) values(?,?,?,?,?,?)";
        return update(sql,cartItem.getId(),cartItem.getImg_path(),cartItem.getType(),cartItem.getCount(),cartItem.getPrice(),cartItem.getPaymentMethod());
    }

    @Override
    public int deleteCartItem(Integer id,String imgpath) {
        String sql = "delete from cart where id=? and img_path=?";
        return update(sql,id,imgpath);
    }

    @Override
    public boolean queryCartItem(int id,String img_path) {
        String sql = "select * from flower.cart where id=? and img_path=?";
        CartItem item = queryForOne(CartItem.class, sql, id,img_path);
        if (item==null){
            return false;
        }
        return true;
    }

    @Override
    public int queryCount(String img_path) {
       String sql = "select * from flower.cart where img_path=?";
        CartItem item = queryForOne(CartItem.class, sql, img_path);
        return item.getCount();
    }

    @Override
    public int updateCount(String img_path,int count) {
        String sql = "update flower.cart set `count`=? where img_path=?";
        return update(sql,count,img_path);
    }
}
