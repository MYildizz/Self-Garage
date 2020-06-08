package com.yildizmurat.Service.implementation;

import com.yildizmurat.Entity.ParkingSpaces;
import com.yildizmurat.Repository.ParkingSpacesRepository;
import com.yildizmurat.Service.ParkingSpacesService;
import org.springframework.stereotype.Service;

@Service
public class ParkingSpacesImpl implements ParkingSpacesService {

    private final ParkingSpacesRepository parkingSpacesRepository;

    public ParkingSpacesImpl(ParkingSpacesRepository parkingSpacesRepository) {
        this.parkingSpacesRepository = parkingSpacesRepository;
    }

    @Override
    public ParkingSpaces save(ParkingSpaces parkingSpaces) {
        return parkingSpacesRepository.save(parkingSpaces);
    }

    @Override
    public ParkingSpaces getById(Long id) {
        return parkingSpacesRepository.getOne(id);
    }

    @Override
    public Boolean delete(ParkingSpaces parkingSpaces) {
        parkingSpacesRepository.delete(parkingSpaces);
        return Boolean.TRUE;
    }
}
