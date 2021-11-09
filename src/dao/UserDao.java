package dao;

import bean.Token;
import bean.User;

public interface UserDao {
    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return 如果返回 null,说明没有这个用户。反之亦然
     */
    public User queryUserByUsername(String username);
    /**
     * @Description //TODO 根据username查询userID
     * @Param [username]
     * @return bean.User
     **/
    public int queryUserIdByUsername(String username);
    /**
     * 根据 用户名和密码查询用户信息
     * @param username 用户名
     * @param password 密 码
     * @return 如果返回 null,说明用户名或密码错误,反之亦然
     */
    public User queryUserByUsernameAndPassword(String username, String password);

    /**
     * 保存用户信息
     * @param user 封装了用户信息的javaBean
     * @return 返回-1 表示操作失败，其他是 sql 语句影响的行数
     */
    public int saveUser(User user);

    /**
     * 根据token查询用户是否登入
     * @param token token令牌
     * @return 如果返回null,说明用户未登入,反之亦然
     */
    public Token queryToken(String token);

    /**
     * 保存token令牌
     * @param user_id 用户id
     * @param userName 用户名
     * @param token token字符串
     * @return 返回-1表示操作失败,其他是 sql 语句影响的行数
     */
    public int saveToken(int user_id, String userName, String token);

    /**
     * 删除用户的token
     * @param token token字符串
     * @return 若返回-1则代表操作失败,反之亦然
     */
    public int deleteToken(String token);

    /**
     * 更新用户信息
     * @param user 用户类
     * @return 若返回-1则代表操作失败,反之亦然
     */
    public int updateUser(User user);

    /**
     * 修改用户密码
     * @param username 用户名
     * @param password 新密码
     * @return 若返回-1则代表操作失败,反之亦然
     */
    public int updateUserPassword(String username, String password);

    /**
     * 根据用户id更新用户名
     * @param id 用户id
     * @param username 用户名
     * @return
     */
    public int updateTokenUsername(int id, String username);
}
