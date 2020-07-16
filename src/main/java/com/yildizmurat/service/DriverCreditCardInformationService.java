package com.yildizmurat.service;

import com.yildizmurat.dto.DriverCreditCardInformationDto;
import com.yildizmurat.entity.DriverCreditCardInformation;

import java.util.List;

public interface DriverCreditCardInformationService {

    DriverCreditCardInformation save(DriverCreditCardInformation driverCreditCardInformation);
    DriverCreditCardInformation getById(Long id);
    Boolean delete(DriverCreditCardInformation driverCreditCardInformation);
    List<DriverCreditCardInformationDto> getDriverCreditCardInformation(String id_name);
}
