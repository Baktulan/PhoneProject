package model;

import java.util.List;
import java.util.function.Consumer;

public class Phone {
    private Long id;
    private String name;
    private String brand;
    private List<Contact>contacts;

    public Phone(Long id, String name, String brand, List<Contact> contacts) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.contacts = contacts;
    }

    public Phone(Long id, String name, String brand) {
        this.id = id;
        this.name = name;
        this.brand = brand;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Consumer<? super Boolean> setName(String name) {
        this.name = name;
        return null;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return "\nPhone: " +
                "\nid=" + id +
                "\nname: '" + name +
                "\nbrand: " + brand +
                "\ncontacts: " + contacts+
                "\n~~~~~~~~~~~~~~~~~~~~~";
    }
}
