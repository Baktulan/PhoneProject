package service;

import model.Contact;

import java.util.List;

public interface ContactService {

    String addContactToPhone(Long idPhone, Contact contactName);

    Contact findContactByName(Long phoneId, String contactName);
    Contact findContactByPhoneNumber(Long phoneId, Long phoneNumber);
    List<Contact>sortContactByName(Long phoneId);
    void deleteContactByNamefromPhone(Long phoneId, String contactName);
}
