package test;

import dao.impl.UserDaoImpl;


public class queryUserIdByUsernameTest {
    public static void main(String[] args) {
        UserDaoImpl userDao = new UserDaoImpl();
        int admin = userDao.queryUserIdByUsername("admin");
        System.out.println(admin);
    }
}
