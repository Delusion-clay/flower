package service.impl;

import bean.StateCode;
import bean.Token;
import bean.User;

import dao.impl.UserDaoImpl;
import service.UserService;
import util.JSONUtiles;


import java.util.UUID;

public class UserServiceImpl extends UserDaoImpl implements UserService {

    @Override
    public int registUser(User user) {
        if (existsUsername(user.getUser_name()) == null) {
            return saveUser(user);
        }
        return -1;
    }

    @Override
    public String login(String username, String password) {
        if (existsUsername(username) == null) {
            StateCode failure = new StateCode(103, "登入失败", new Token(null, null, -1));
            return JSONUtiles.toJson(failure);
        }

        User user = queryUserByUsernameAndPassword(username, password);
        if (user != null) {
            String uuid = UUID.randomUUID().toString();
            int i = saveToken(user.getId(), username, uuid);
            StateCode success = new StateCode(100, "登入成功", new Token(username, uuid, user.getId()));
            return JSONUtiles.toJson(success);
        }

        return JSONUtiles.toJson(new StateCode(102, "登入失败", new Token(null, null, -1)));
    }

    @Override
    public User existsUsername(String username) {
        User user = queryUserByUsername(username);
        if (user != null) {
            return user;
        }
        return null;
    }

    @Override
    public int delete(String token) {
        return deleteToken(token);
    }

    @Override
    public String isLogin(String token) {
        Token token1 = queryToken(token);
        if (token1 != null) {
            return JSONUtiles.toJson(new StateCode(100, "用户已登入", token1));
        }
        return JSONUtiles.toJson(new StateCode(102, "用户未登入", token1));
    }

    @Override
    public String getUser(String username) {
        User user = queryUserByUsername(username);
        return JSONUtiles.toJson(user);
    }

    @Override
    public int updateUserInfo(User user) {
        User user1 = existsUsername(user.getUser_name());
        if (user1 == null || (user1.getId() == user.getId())) {
            updateTokenUsername(user.getId(), user.getUser_name());
            return updateUser(user);
        }
        return -1;
    }

    @Override
    public int updatePassword(String username, String password) {
        return updateUserPassword(username, password);
    }

    @Override
    public int getIdByUsername(String username) {
        return queryUserIdByUsername(username);
    }
}
