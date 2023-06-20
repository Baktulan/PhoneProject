package service.impl;

import db.DataBase;
import exception.MyException;
import model.Contact;
import model.Phone;
import service.ContactService;

import java.util.*;
import java.util.stream.Collectors;

public class ContactServiceIMPL implements ContactService {
    private DataBase dataBase;


    public ContactServiceIMPL(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public String addContactToPhone(Long idPhone, Contact contactName) {
        for (Phone a : dataBase.getPhones()) {
            boolean isFound = false;
            if (a.getId().equals(idPhone)) {
                if (a.getContacts() == null) {
                    a.setContacts(new ArrayList<>());
                }
                isFound = true;
                a.getContacts().add(contactName);
            }
            if (!isFound) {
                System.out.println("Not found Id");
            }
        }
        return "Successfully added!";
    }

    @Override
    public Contact findContactByName(Long phoneId, String contactName) {
        List<Phone> phones = new ArrayList<>(dataBase.getPhones());
        return phones.stream()
                .filter(phone -> phone.getId().equals(phoneId))
                .findFirst()
                .flatMap(phone -> phone.getContacts().stream()
                        .filter(contact -> contact.getName().equalsIgnoreCase(contactName)).findFirst())
                .orElse(null);

    }

    @Override
    public Contact findContactByPhoneNumber(Long phoneId, Long phoneNumber) {
        List<Phone> phones = new ArrayList<>(dataBase.getPhones());
        return phones.stream()
                .filter(phone -> phone.getId().equals(phoneId))
                .findFirst()
                .flatMap(phone -> phone.getContacts().stream()
                        .filter(contact -> contact.getPhoneNumber().equals(phoneNumber))
                        .findFirst())
                .orElse(null);

    }

    @Override
    public List<Contact> sortContactByName(Long phoneId) {
        List<Phone> phones = new ArrayList<>(dataBase.getPhones());
        return phones.stream()
                .filter(phone -> phone.getId().equals(phoneId))
                .findFirst()
                .map(phone -> phone.getContacts().stream()
                        .sorted(Comparator.comparing(Contact::getName))
                        .collect(Collectors.toList()))
                .orElse(null);
    }

    @Override
    public void deleteContactByNamefromPhone(Long phoneId, String contactName) {
        for (int i = 0; i < dataBase.getPhones().size(); i++) {
            if(phoneId==dataBase.getPhones().get(i).getId()){
                List<Contact>contacts= dataBase.getPhones().get(i).getContacts();
                for (int j = 0; j < contacts.size(); j++) {
                    if (contacts.get(j).getName().equalsIgnoreCase(contactName)){
                        contacts.remove(j);
                    }
                }
            }
        }
        System.out.println("Successfully deleted :"+ dataBase.getContacts());
    }

}
