package com.yildizmurat.Repository;

import com.yildizmurat.Entity.ParkingOwnerCreditCardInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingOwnerCreditCardInformationRepository extends JpaRepository<ParkingOwnerCreditCardInformation,Long> {
}
