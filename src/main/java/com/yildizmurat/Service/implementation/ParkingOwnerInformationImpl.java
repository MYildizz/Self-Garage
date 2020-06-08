package com.yildizmurat.Service.implementation;

import com.yildizmurat.Entity.ParkingOwnerInformation;
import com.yildizmurat.Repository.ParkingOwnerInformationRepository;
import com.yildizmurat.Service.ParkingOwnerInformationService;
import org.springframework.stereotype.Service;

@Service
public class ParkingOwnerInformationImpl implements ParkingOwnerInformationService {

    private final ParkingOwnerInformationRepository parkingOwnerInformationRepository;

    public ParkingOwnerInformationImpl(ParkingOwnerInformationRepository parkingOwnerInformationRepository) {
        this.parkingOwnerInformationRepository = parkingOwnerInformationRepository;
    }

    @Override
    public ParkingOwnerInformation save(ParkingOwnerInformation parkingOwnerInformation) {
        return parkingOwnerInformationRepository.save(parkingOwnerInformation);
    }

    @Override
    public ParkingOwnerInformation getById(Long id) {
        return parkingOwnerInformationRepository.getOne(id);
    }

    @Override
    public Boolean delete(ParkingOwnerInformation parkingOwnerInformation) {
        parkingOwnerInformationRepository.delete(parkingOwnerInformation);
        return Boolean.TRUE;
    }
}
