package com.eda.service.Impl;

import com.eda.dao.TableMapper;
import com.eda.pojo.Table;
import com.eda.pojo.Table1;
import com.eda.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public  class TableServiceImpl implements TableService {
    @Autowired
    private TableMapper tableMapper;
    @Override
    public Integer insertGmsq(String name, String workUnit, String idCard, String postalCode, String address, String telephone, String phone, String mail, String fileName, Integer fileNumber, String description, String postWay, String getWay, String status,Integer number) {
        int num = (int) ((Math.random()*9+1)*100000);
        Table table = new Table();
        table.setName(name);
        table.setWorkUnit(workUnit);
        table.setIdCard(idCard);
        table.setPostalCode(postalCode);
        table.setAddress(address);
        table.setTelephone(telephone);
        table.setPhone(phone);
        table.setMail(mail);
        table.setFileName(fileName);
        table.setFileNumber(fileNumber);
        table.setDescription(description);
        table.setPostWay(postWay);
        table.setGetWay(getWay);
        table.setStatus(status);
        table.setNumber(num);
        tableMapper.insertGmsq(table.getName(), table.getWorkUnit(), table.getIdCard(), table.getPostalCode(), table.getAddress(), table.getTelephone(), table.getPhone(), table.getMail(), table.getFileName(), table.getFileNumber(), table.getDescription(), table.getPostWay(),table.getGetWay(),table.getStatus(),table.getNumber());
        return table.getNumber();
    }

    @Override
    public Integer insertOtherTable(String name, String address, String code, String businessLicens, String legalPerson, String personCard, String contacts, String contactsTelephone, String contactsPhone, String contactsMail, String fileName, String fileNumber, String description, String postWay, String getWay, String type, String status, Integer number) {
        int num = (int) ((Math.random()*9+1)*100000);
        Table1 table1 = new Table1();
        table1.setName(name);
        table1.setAddress(address);
        table1.setCode(code);
        table1.setBusinessLicens(businessLicens);
        table1.setLegalPerson(legalPerson);
        table1.setPersonCard(personCard);
        table1.setContacts(contacts);
        table1.setContactsTelephone(contactsTelephone);
        table1.setContactsPhone(contactsPhone);
        table1.setContactsMail(contactsMail);
        table1.setFileName(fileName);
        table1.setFileNumber(fileNumber);
        table1.setDescription(description);
        table1.setPostWay(postWay);
        table1.setGetWay(getWay);
        table1.setType(type);
        table1.setStatus(status);
        table1.setNumber(num);
        tableMapper.insertOtherTable(table1.getName(), table1.getAddress(), table1.getCode(), table1.getBusinessLicens(), table1.getLegalPerson(), table1.getPersonCard(), table1.getContacts(), table1.getContactsTelephone(), table1.getContactsPhone(), table1.getContactsMail(), table1.getFileName(), table1.getFileNumber(), table1.getDescription(), table1.getPostWay(), table1.getGetWay(), table1.getType(),table1.getStatus(),table1.getNumber());
        return table1.getNumber();
    }

}
