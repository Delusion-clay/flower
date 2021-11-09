package test;


import bean.CartItem;
import dao.impl.CartDaoImpl;

public class CartTest  {
    public static void main(String[] args) {
        CartDaoImpl cartDao = new CartDaoImpl();
//        String sql = "select * from flower.cart where img_path=?";
//        String img_path = "images/default_img8.png";
//        CartItem item = cartDao.queryForOne(CartItem.class, sql, img_path);
//        System.out.println(item.getCount());
        //new CartItem(8,"images/default_img8.png","百合花",1,69,"支付宝支付");
        CartItem item = new CartItem(8, "images/default_img8.png", "百合花", 1, "69", "支付宝");
        cartDao.addCart(item);
    }
}
