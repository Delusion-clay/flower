package bean;



public class CartItem {
    private Integer id;
    private String img_path;
    private String type;
    private Integer count = 1;
    private String price;
    private String PaymentMethod = "余额宝支付";

    public CartItem() {
    }
    public CartItem(Integer id, String img_path, String type,  String price,Integer count) {
        this.id = id;
        this.img_path = img_path;
        this.type = type;
        this.price = price;
        this.count = count;
    }
    public CartItem(Integer id, String img_path, String type,  String price) {
        this.id = id;
        this.img_path = img_path;
        this.type = type;
        this.price = price;
    }
    public CartItem(Integer id, String img_path, String type,Integer count , String price) {
        this.id = id;
        this.img_path = img_path;
        this.type = type;
        this.price = price;
        this.count = count;
    }
    public CartItem(Integer id, String img_path, String type, Integer count, String price, String paymentMethod) {
        this.id = id;
        this.img_path = img_path;
        this.type = type;
        this.count = count;
        this.price = price;
        this.PaymentMethod = paymentMethod;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImg_path() {
        return img_path;
    }

    public void setImg_path(String img_path) {
        this.img_path = img_path;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPaymentMethod() {
        return PaymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        PaymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", img_path='" + img_path + '\'' +
                ", type='" + type + '\'' +
                ", count=" + count +
                ", price=" + price +
                ", PaymentMethod='" + PaymentMethod + '\'' +
                '}';
    }
}
