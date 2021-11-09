package dao;

import bean.CartItem;


public interface CartDao {
    public int addCart(CartItem cartItem);
    public int deleteCartItem(Integer id,String imgpath);
    public boolean queryCartItem(int id,String img_path);
    public int queryCount(String img_path);
    public int updateCount(String img_path,int count);
}
