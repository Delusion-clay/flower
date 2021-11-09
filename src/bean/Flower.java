package bean;

public class Flower {
    private String img_path;
    private String type;
    private Integer price;
    private String color = "红色";

    public Flower() {
    }

    public Flower(String img_path, String type, Integer price, String color) {
        this.img_path = img_path;
        this.type = type;
        this.price = price;
        this.color = color;
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "flower{" +
                "img_path='" + img_path + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }
}
