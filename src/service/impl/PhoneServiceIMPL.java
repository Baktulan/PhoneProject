package service.impl;

import db.DataBase;
import model.Phone;
import service.PhoneService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PhoneServiceIMPL implements PhoneService {
    private DataBase dataBase;
    public static Long phoneId = 1L;

    public PhoneServiceIMPL(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public String addPhone(Phone phone) {
        phone.setId(phoneId++);
        dataBase.getPhones().add(phone);
        System.out.println(dataBase.getPhones());
        return "New phone successfully added!";
    }

    @Override
    public List<Phone> getPhoneById(Long id) {
        List<Phone> phones = new ArrayList<>();
        phones.addAll(dataBase.getPhones());
        List<Phone> phon1 = phones.stream()
                .filter(phone -> phone.getId().equals(id))
                .collect(Collectors.toList());
        return phon1;
    }


    @Override
    public List<Phone> updatePhoneById(Long id, String newName, String newBrand) {
        List<Phone>phones= new ArrayList<>();
        phones.addAll(dataBase.getPhones());
        phones.stream()
                .filter(phone -> phone.getId().equals(id))
                .findFirst()
                .ifPresent(phone -> {phone.setName(newName);phone.setBrand(newBrand);});

        return phones;
    }


    @Override
    public List<Phone> getAllPhones() {
        List<Phone>phones= new ArrayList<>(dataBase.getPhones());
        phones.stream().peek(System.out::println);
        return phones;
    }

    @Override
    public List<Phone> getAllPhonesByBrand(String brand) {
        List<Phone>phones= new ArrayList<>(dataBase.getPhones());
       List<Phone>phoneBrand=phones.stream()
                .filter(phone -> phone.getBrand().equals(brand))
                .collect(Collectors.toList());
        return phoneBrand;
    }

    @Override
    public void deletePhoneById(Long id) {
        for (int i = 0; i < dataBase.getPhones().size(); i++) {
            if (id==dataBase.getPhones().get(i).getId()){
                dataBase.getPhones().remove(i);
            }
        }
        System.out.println("Phone successfully deleted!");
    }
}
