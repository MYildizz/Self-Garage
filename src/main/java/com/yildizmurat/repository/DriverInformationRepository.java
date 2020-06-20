package com.yildizmurat.repository;

import com.yildizmurat.entity.DriverInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverInformationRepository extends JpaRepository<DriverInformation,Long>{

  Boolean  existsDriverInformationByIdName(String idName);
  Boolean existsDriverInformationByMail(String email);
  Boolean existsDriverInformationByCarPlate(String carPlate);
  Boolean existsDriverInformationByPassword(String password);
}
