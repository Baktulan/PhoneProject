package db;

import model.Contact;
import model.Phone;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private List<Phone>phones= new ArrayList<>();
    private List<Contact>contacts= new ArrayList<>();

    public DataBase(List<Phone> phones, List<Contact> contacts) {
        this.phones = phones;
        this.contacts = contacts;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public DataBase(List<Phone> phones) {
        this.phones = phones;
    }

    public DataBase() {
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }
}
