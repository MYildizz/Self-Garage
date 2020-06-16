package com.yildizmurat.service.implementation;

import com.yildizmurat.entity.DriverCreditCardInformation;
import com.yildizmurat.repository.DriverCreditCardInformationRepository;
import com.yildizmurat.service.DriverCreditCardInformationService;

public class DriverCreditCardInformationImpl implements DriverCreditCardInformationService {

    private final DriverCreditCardInformationRepository driverCreditCardInformationRepository;


    public DriverCreditCardInformationImpl(DriverCreditCardInformationRepository driverCreditCardInformationRepository) {
        this.driverCreditCardInformationRepository = driverCreditCardInformationRepository;
    }

    @Override
    public DriverCreditCardInformation save(DriverCreditCardInformation driverCreditCardInformation) {
        return driverCreditCardInformationRepository.save(driverCreditCardInformation);
    }

    @Override
    public DriverCreditCardInformation getById(Long id) {
        return driverCreditCardInformationRepository.getOne(id);
    }

    @Override
    public Boolean delete(DriverCreditCardInformation driverCreditCardInformation) {
        driverCreditCardInformationRepository.delete(driverCreditCardInformation);
        return Boolean.TRUE;
    }
}
