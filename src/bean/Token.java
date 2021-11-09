package bean;

/**
 * @describe token表对应的javaBean
 */
public class Token {
    private String user_name;
    private String tokenStr;
    private int user_id;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getTokenStr() {
        return tokenStr;
    }

    public void setTokenStr(String tokenStr) {
        this.tokenStr = tokenStr;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Token{" +
                "user_name='" + user_name + '\'' +
                ", tokenStr='" + tokenStr + '\'' +
                ", user_id=" + user_id +
                '}';
    }

    public Token(String user_name, String tokenStr, int user_id) {
        this.user_name = user_name;
        this.tokenStr = tokenStr;
        this.user_id = user_id;
    }

    public Token() {
    }
}
