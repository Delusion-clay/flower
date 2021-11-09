package bean;

/**
 * @describe c_user表对应的javaBean
 */

public class User {
    private int id;
    private String user_name;
    private String password;
    private String email;
    private String provinal;
    private String city;
    private String addr;


    @Override
    public String toString() {
        return "User{" +
                "user_id=" + id +
                ", user_name='" + user_name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", provinal='" + provinal + '\'' +
                ", city='" + city + '\'' +
                ", addr='" + addr + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProvinal() {
        return provinal;
    }

    public void setProvinal(String provinal) {
        this.provinal = provinal;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public User(int id, String user_name, String password, String email, String provinal, String city, String addr) {
        this.id = id;
        this.user_name = user_name;
        this.password = password;
        this.email = email;
        this.provinal = provinal;
        this.city = city;
        this.addr = addr;
    }

    public User() {
    }
}
