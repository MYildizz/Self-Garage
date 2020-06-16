package com.yildizmurat.repository;

import com.yildizmurat.entity.DriverCreditCardInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverCreditCardInformationRepository extends JpaRepository<DriverCreditCardInformation,Long> {
}
