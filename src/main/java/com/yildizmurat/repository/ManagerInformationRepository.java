package com.yildizmurat.repository;

import com.yildizmurat.entity.ManagerInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerInformationRepository extends JpaRepository<ManagerInformation,Long> {

    Boolean  existsManagerInformationByIdName(String idName);
    Boolean existsManagerInformationByMail(String email);
    Boolean existsManagerInformationByPassword(String password);

}
