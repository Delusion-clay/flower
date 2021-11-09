package service.impl;

import bean.Contact_us;
import dao.ContactDao;
import dao.impl.ContactDaoImpl;
import service.Contact_usService;


public class Contact_usServiceImpl implements Contact_usService {
    ContactDao contactDao = new ContactDaoImpl();
    @Override
    public void save(Contact_us contact_us) {
        System.out.println(contact_us);
        contactDao.save(contact_us);
    }
}
