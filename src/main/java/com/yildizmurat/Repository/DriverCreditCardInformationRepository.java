package com.yildizmurat.Repository;

import com.yildizmurat.Entity.DriverCreditCardInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverCreditCardInformationRepository extends JpaRepository<DriverCreditCardInformation,Long> {
}
