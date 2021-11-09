package dao.impl;

import bean.Contact_us;
import dao.ContactDao;


public class ContactDaoImpl extends BaseDao implements ContactDao {
    @Override
    public int save(Contact_us user) {
        String sql = "insert into flower.contact_us(`username`,`email`,`phone`,`proposal`) values(?,?,?,?)";
        System.out.println(user);
        return update(sql,user.getUsername(),user.getEmail(),user.getPhone(),user.getProposal());
    }
}
