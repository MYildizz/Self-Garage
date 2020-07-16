package com.yildizmurat.repository;

import com.yildizmurat.dto.DriverCreditCardInformationDto;
import com.yildizmurat.entity.DriverCreditCardInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverCreditCardInformationRepository extends JpaRepository<DriverCreditCardInformation,Long> {

    List<DriverCreditCardInformation> getAllByIdName(String IdName);

}
