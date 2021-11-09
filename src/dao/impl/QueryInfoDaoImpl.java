package dao.impl;

import bean.User;
import dao.QueryInfoDao;


public class QueryInfoDaoImpl extends BaseDao implements QueryInfoDao {
    @Override
    public User queryInfo(String username) {
        String sql = "select * from c_user where user_name=?";
        return queryForOne(User.class,sql,username);
    }
}
