package service;

import bean.CartItem;


import java.util.List;


public interface CartShowService {
    /**
     * @Description //TODO 查询购物车
     * @Param [id]
     * @return java.util.List<Page>
     **/
    public List<CartItem> findAll(int id);
}
