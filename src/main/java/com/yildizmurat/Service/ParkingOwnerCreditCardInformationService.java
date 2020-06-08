package com.yildizmurat.Service;

import com.yildizmurat.Entity.ParkingOwnerCreditCardInformation;

public interface ParkingOwnerCreditCardInformationService {

    ParkingOwnerCreditCardInformation save(ParkingOwnerCreditCardInformation parkingOwnerCreditCardInformation);
    ParkingOwnerCreditCardInformation getById(Long id);
    Boolean delete(ParkingOwnerCreditCardInformation parkingOwnerCreditCardInformation);
}
