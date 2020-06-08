package com.yildizmurat.Service.implementation;

import com.yildizmurat.Entity.ParkingOwnerCreditCardInformation;
import com.yildizmurat.Repository.ParkingOwnerCreditCardInformationRepository;
import com.yildizmurat.Service.ParkingOwnerCreditCardInformationService;
import org.springframework.stereotype.Service;

@Service
public class ParkingOwnerCreditCardInformationImpl implements ParkingOwnerCreditCardInformationService {

    private final ParkingOwnerCreditCardInformationRepository parkingOwnerCreditCardInformationRepository;

    public ParkingOwnerCreditCardInformationImpl(ParkingOwnerCreditCardInformationRepository parkingOwnerCreditCardInformationRepository) {
        this.parkingOwnerCreditCardInformationRepository = parkingOwnerCreditCardInformationRepository;
    }

    @Override
    public ParkingOwnerCreditCardInformation save(ParkingOwnerCreditCardInformation parkingOwnerCreditCardInformation) {
        return parkingOwnerCreditCardInformationRepository.save(parkingOwnerCreditCardInformation);
    }

    @Override
    public ParkingOwnerCreditCardInformation getById(Long id) {
        return parkingOwnerCreditCardInformationRepository.getOne(id);
    }

    @Override
    public Boolean delete(ParkingOwnerCreditCardInformation parkingOwnerCreditCardInformation) {
        parkingOwnerCreditCardInformationRepository.delete(parkingOwnerCreditCardInformation);
        return Boolean.TRUE;
    }
}
