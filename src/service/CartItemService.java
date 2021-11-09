package service;

import bean.CartItem;


public interface CartItemService {
    public void addCart(CartItem cartItem);
    public void deleteCartItem(Integer id,String imgpath);
    public boolean queryCartItem(int id,String img_path);
    public int queryCount(String img_path);
    public int updateCount(String img_path,int count);
}
