package com.yildizmurat.Service.implementation;

import com.yildizmurat.Entity.DriverCreditCardInformation;
import com.yildizmurat.Repository.DriverCreditCardInformationRepository;
import com.yildizmurat.Service.DriverCreditCardInformationService;

public class DriverCreditCardInformationImpl implements DriverCreditCardInformationService {

    private final DriverCreditCardInformationRepository driverCreditCardInformationRepository;

    public DriverCreditCardInformationImpl() {
        this.driverCreditCardInformationRepository=null;
    }

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
