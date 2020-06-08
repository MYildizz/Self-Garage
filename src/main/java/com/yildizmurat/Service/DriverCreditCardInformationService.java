package com.yildizmurat.Service;

import com.yildizmurat.Entity.DriverCreditCardInformation;

public interface DriverCreditCardInformationService {

    DriverCreditCardInformation save(DriverCreditCardInformation driverCreditCardInformation);
    DriverCreditCardInformation getById(Long id);
    Boolean delete(DriverCreditCardInformation driverCreditCardInformation);
}
