package service;

import model.Phone;

import java.util.List;

public interface PhoneService {
  String addPhone(Phone phone);

 List<Phone>  getPhoneById(Long id);
  List<Phone> updatePhoneById(Long id,String newName,String newBrand);
  List<Phone> getAllPhones();
  List<Phone> getAllPhonesByBrand(String brand);
  void deletePhoneById (Long id);
}
