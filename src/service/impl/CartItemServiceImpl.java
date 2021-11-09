package service.impl;

import bean.CartItem;
import dao.CartDao;
import dao.impl.CartDaoImpl;
import service.CartItemService;

public class CartItemServiceImpl implements CartItemService {
    CartDao cartDao = new CartDaoImpl();
    @Override
    public void addCart(CartItem cartItem) {
        cartDao.addCart(cartItem);
    }

    @Override
    public void deleteCartItem(Integer id,String imgpath) {
        cartDao.deleteCartItem(id,imgpath);
    }

    @Override
    public boolean queryCartItem(int id,String img_path) {
        return cartDao.queryCartItem(id,img_path);
    }

    @Override
    public int queryCount(String img_path) {
        return cartDao.queryCount(img_path);
    }

    @Override
    public int updateCount(String img_path, int count) {
        return cartDao.updateCount(img_path,count);
    }
}
