package service.impl;

import bean.User;
import dao.QueryInfoDao;
import dao.impl.QueryInfoDaoImpl;
import service.QueryInfoService;


public class QueryInfoServiceImpl implements QueryInfoService {
    QueryInfoDao queryInfoDao = new QueryInfoDaoImpl();
    @Override
    public User queryInfo(String username) {
        return queryInfoDao.queryInfo(username);
    }
}
