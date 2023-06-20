import db.DataBase;
import model.Contact;
import model.Phone;
import service.impl.ContactServiceIMPL;
import service.impl.PhoneServiceIMPL;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DataBase dataBase = new DataBase();
        PhoneServiceIMPL phoneServiceIMPL = new PhoneServiceIMPL(dataBase);
        ContactServiceIMPL contactServiceIMPL = new ContactServiceIMPL(dataBase);

        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        int num;
        while (true) {
            System.out.println("""
                    1.Add new Phone
                    2.Get phone by ID
                    3.Update phone by ID
                    4.Get all phones
                    5.Get all phone by brand
                    6.Delete phone by ID
                    7.Add contact to phone
                    8.Find contact by name
                    9.Find contact by phone number
                    10.Sort contact by name
                    11.Delete contact by name from phone""");
            num = scanner.nextInt();
            switch (num) {
                case 1 -> {
                    System.out.print("Write name of Phone: ");
                    String nameOfPhone = scanner1.nextLine();
                    System.out.print("Write brand: ");
                    String nameOfBrand = scanner1.nextLine();
                    phoneServiceIMPL.addPhone(new Phone(null, nameOfPhone, nameOfBrand));
                }
                case 2 -> {
                    System.out.print("Write Phone ID: ");
                    Long Id = scanner1.nextLong();
                    System.out.println(phoneServiceIMPL.getPhoneById(Id));
                }
                case 3 -> {
                    System.out.print("Write phone's Id to update:");
                    Long id = scanner1.nextLong();
                    System.out.print("Write new Name: ");
                    String newName = scanner1.nextLine();
                    System.out.print("Write new Brand: ");
                    String newBrand = scanner1.nextLine();
                    System.out.println(phoneServiceIMPL.updatePhoneById(id, newName, newBrand));
                }
                case 4 -> {
                    System.out.println(phoneServiceIMPL.getAllPhones());
                }
                case 5 -> {
                    System.out.print("Write phone brand: ");
                    String brandName = scanner1.nextLine();
                    System.out.println(phoneServiceIMPL.getAllPhonesByBrand(brandName));
                }
                case 6 -> {
                    System.out.print("Write phone ID for delete: ");
                    Long id = scanner1.nextLong();
                    phoneServiceIMPL.deletePhoneById(id);
                }
                case 7 -> {
                    System.out.print("Write Phone ID: ");
                    Long id = scanner1.nextLong();
                    scanner1.nextLine();
                    System.out.print("Write name of contact: ");
                    String nameOfcontact = scanner1.nextLine();
                    System.out.print("Write contact's phone number: ");
                    Long phoneNumber = scanner.nextLong();
                    System.out.println(contactServiceIMPL.addContactToPhone(id, new Contact(nameOfcontact, phoneNumber)));

                }
                case 8 -> {
                    System.out.print("Write phone id: ");
                    Long id = scanner1.nextLong();
                    scanner1.nextLine();
                    System.out.print("Write name of contact: ");
                    String nameOfContact = scanner1.nextLine();
                    System.out.println(contactServiceIMPL.findContactByName(id, nameOfContact));
                }
                case 9 -> {
                    System.out.print("Write phone id: ");
                    Long id = scanner1.nextLong();
                    scanner1.nextLine();
                    System.out.print("Write phone number: ");
                    Long phoneNumber = scanner1.nextLong();
                    System.out.println(contactServiceIMPL.findContactByPhoneNumber(id, phoneNumber));
                }
                case 10 -> {
                    System.out.print("Write phone id");
                    Long id = scanner1.nextLong();
                    System.out.println(contactServiceIMPL.sortContactByName(id));
                }
                case 11 -> {
                    System.out.print("Write phone id");
                    Long id = scanner1.nextLong();
                    scanner1.nextLine();
                    System.out.print("Write contact name:");
                    String contactName = scanner1.nextLine();
                    contactServiceIMPL.deleteContactByNamefromPhone(id, contactName);
                }
            }
        }
    }
}