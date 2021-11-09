package dao.impl;

import bean.Token;
import bean.User;
import dao.UserDao;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User queryUserByUsername(String username) {
        String sql = "select * from c_user where user_name=?";
        return queryForOne(User.class,sql,username);
    }

    @Override
    public int queryUserIdByUsername(String username) {
        String sql = "select id from c_user where user_name=?";
        User user = queryForOne(User.class, sql, username);
        return user.getId();
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select * from c_user where user_name=? and password=?";
        return queryForOne(User.class,sql,username,password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into c_user values(null,?,?,?,?,?,?)";
        return update(sql,user.getUser_name(),user.getPassword(),user.getEmail(),user.getProvinal(),user.getCity(),user.getAddr());
    }

    @Override
    public Token queryToken(String token) {
        String sql = "select * from token where tokenStr=?";
        return queryForOne(Token.class,sql,token);
    }

    @Override
    public int saveToken(int user_id,String userName, String token) {
        String sql = "insert into token values(?,?,?)";
        return update(sql,token,user_id,userName);
    }

    @Override
    public int deleteToken(String token) {
        String sql = "delete from token where tokenStr=?";
        return update(sql,token);
    }

    @Override
    public int updateUser(User user) {
        String sql = "update c_user set user_name=?,email=?,provinal=?,city=?,addr=? where id=?";
        return update(sql,user.getUser_name(),user.getEmail(),user.getProvinal(),user.getCity(),user.getAddr(),user.getId());
    }

    @Override
    public int updateUserPassword(String username, String password) {
        String sql = "update c_user set password=? where user_name=?";
        return update(sql,password,username);
    }

    @Override
    public int updateTokenUsername(int id ,String username) {
        String sql = "update token set user_name=? where user_id=?";
        return update(sql,username,id);
    }
}
