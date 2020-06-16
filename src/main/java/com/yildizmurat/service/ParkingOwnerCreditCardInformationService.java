package com.yildizmurat.service;

import com.yildizmurat.entity.ParkingOwnerCreditCardInformation;

public interface ParkingOwnerCreditCardInformationService {

    ParkingOwnerCreditCardInformation save(ParkingOwnerCreditCardInformation parkingOwnerCreditCardInformation);
    ParkingOwnerCreditCardInformation getById(Long id);
    Boolean delete(ParkingOwnerCreditCardInformation parkingOwnerCreditCardInformation);
}
