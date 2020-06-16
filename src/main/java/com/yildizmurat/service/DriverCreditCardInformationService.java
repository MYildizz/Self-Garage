package com.yildizmurat.service;

import com.yildizmurat.entity.DriverCreditCardInformation;

public interface DriverCreditCardInformationService {

    DriverCreditCardInformation save(DriverCreditCardInformation driverCreditCardInformation);
    DriverCreditCardInformation getById(Long id);
    Boolean delete(DriverCreditCardInformation driverCreditCardInformation);
}
