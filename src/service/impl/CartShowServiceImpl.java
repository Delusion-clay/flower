package service.impl;

import bean.CartItem;
import dao.CartShowDao;
import dao.impl.CartShowDaoImpl;
import service.CartShowService;

import java.util.List;



public class CartShowServiceImpl implements CartShowService {
    CartShowDao pageDao = new CartShowDaoImpl();
    @Override
    public List<CartItem> findAll(int id) {
        return pageDao.findAll(id);
    }
}
