package com.eda.dao;

import com.eda.pojo.Table;
import com.eda.pojo.Table1;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TableMapper {
    void insertGmsq(@Param("name") String name, @Param("workUnit") String workUnit, @Param("idCard") String idCard, @Param("postalCode") String postalCode, @Param("address") String address, @Param("telephone") String telephone, @Param("phone") String phone, @Param("mail") String mail, @Param("fileName") String fileName, @Param("fileNumber") Integer fileNumber, @Param("description") String description, @Param("postWay") String postWay, @Param("getWay") String getWay, @Param("status")String status,@Param("number")Integer number);

    void insertOtherTable(@Param("name") String name, @Param("address") String address, @Param("code") String code, @Param("businessLicens") String businessLicens, @Param("legalPerson") String legalPerson, @Param("personCard") String personCard, @Param("contacts") String contacts, @Param("contactsTelephone") String contactsTelephone, @Param("contactsPhone") String contactsPhone, @Param("contactsMail") String contactsMail, @Param("fileName") String fileName, @Param("fileNumber")String fileNumber, @Param("description")String description, @Param("postWay") String postWay, @Param("getWay") String getWay, @Param("type")String type, @Param("status")String status, @Param("number")Integer number);

}
