package com.eda.service;



public interface TableService {

     Integer insertGmsq(String name, String workUnit, String idCard, String postalCode, String address, String telephone, String phone, String mail, String fileName, Integer fileNumber, String description, String postWay, String getWay, String status,Integer number);
     Integer insertOtherTable(String name, String address, String code, String businessLicens, String legalPerson, String personCard, String contacts, String contactsTelephone, String contactsPhone, String contactsMail, String fileName, String fileNumber, String description, String postWay, String getWay, String type, String status, Integer number);
}
