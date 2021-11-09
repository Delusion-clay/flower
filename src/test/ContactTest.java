package test;

import bean.Contact_us;
import dao.impl.ContactDaoImpl;

public class ContactTest {
    public static void main(String[] args) {
        ContactDaoImpl contactDao = new ContactDaoImpl();
        Contact_us contact_us = new Contact_us( "qwq", "wqwq", "12121", "wqwqwqw");
        contactDao.save(contact_us);
    }
}
