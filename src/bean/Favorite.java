package bean;

public class Favorite {
    private Integer id;
    private String img_path;
    private String type;
    private String price;

    public Favorite() {
    }

    @Override
    public String toString() {
        return "favorites{" +
                "id=" + id +
                ", img_path='" + img_path + '\'' +
                ", type='" + type + '\'' +
                ", price='" + price + '\'' +
                '}';
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Favorite(Integer id, String img_path, String type, String price) {
        this.id = id;
        this.img_path = img_path;
        this.type = type;
        this.price = price;
    }
}
