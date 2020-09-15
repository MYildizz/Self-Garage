package com.yildizmurat.service.implementation;

import com.yildizmurat.entity.ParkingOwnerCreditCardInformation;
import com.yildizmurat.repository.ParkingOwnerCreditCardInformationRepository;
import com.yildizmurat.service.ParkingOwnerCreditCardInformationService;
import org.springframework.stereotype.Service;

@Service
public class ParkingOwnerCreditCardInformationImpl implements ParkingOwnerCreditCardInformationService {

    private final ParkingOwnerCreditCardInformationRepository parkingOwnerCreditCardInformationRepository;


    public ParkingOwnerCreditCardInformationImpl(ParkingOwnerCreditCardInformationRepository parkingOwnerCreditCardInformationRepository) {
        this.parkingOwnerCreditCardInformationRepository = parkingOwnerCreditCardInformationRepository;
    }

    @Override
    public ParkingOwnerCreditCardInformation save(ParkingOwnerCreditCardInformation parkingOwnerCreditCardInformation) {
        try{
            return parkingOwnerCreditCardInformationRepository.save(parkingOwnerCreditCardInformation);
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    @Override
    public ParkingOwnerCreditCardInformation getById(Long id) {
        try{
            return parkingOwnerCreditCardInformationRepository.getOne(id);
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    @Override
    public Boolean delete(ParkingOwnerCreditCardInformation parkingOwnerCreditCardInformation) {
        try{
            parkingOwnerCreditCardInformationRepository.delete(parkingOwnerCreditCardInformation);
            return Boolean.TRUE;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
}
