package service;


import bean.User;

public interface UserService {
    /**
     * 注册用户
     * @param user 用户javaBean
     */
    public int registUser(User user);

    /**
     * 登录用户
     * @param username
     * @param password
     * @return 若查询到则返回登录用户javaBean的json字符串
     */
    public String login(String username, String password);

    /**
     * 查询用户是否可用
     * @param username 用户名
     * @return 若返回true则表示可用,否则不可用
     */
    public User existsUsername(String username);

    /**
     * 删除用户对应的token
     * @param token
     * @return
     */
    public int delete(String token);

    /**
     * 判断用户是否登录
     * @param token token字符串
     * @return 返回一个状态javaBean
     */
    public String isLogin(String token);

    /**
     * 获取用户信息
     * @param username 用户名
     * @return 返回一个json字符串
     */
    public String getUser(String username);

    /**
     * 更新用户信息
     * @param user 用户类
     * @return 若返回-1则代表操作失败,反之亦然
     */
    public int updateUserInfo(User user);

    /**
     * 更新用户密码
     * @param username 用户名
     * @param password 用户新密码
     * @return 若返回-1则代表操作失败,反之亦然
     */
    public int updatePassword(String username, String password);
    /**
     * @Description //TODO 返回登录用户的id
     * @Date 21:57 2020/12/17
     * @Param [username]
     * @return java.lang.String
     **/
    public int getIdByUsername(String username);
}
