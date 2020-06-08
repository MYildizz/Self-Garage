package com.yildizmurat.Service.implementation;

import com.yildizmurat.Entity.ParkingSpacesUsages;
import com.yildizmurat.Repository.ParkingSpacesRepository;
import com.yildizmurat.Repository.ParkingSpacesUsagesRepository;
import com.yildizmurat.Service.ParkingSpacesUsagesService;
import org.springframework.stereotype.Service;

@Service
public class ParkingSpacesUsagesImpl implements ParkingSpacesUsagesService {

    private final ParkingSpacesUsagesRepository parkingSpacesUsagesRepository;

    public ParkingSpacesUsagesImpl(ParkingSpacesUsagesRepository parkingSpacesUsagesRepository) {
        this.parkingSpacesUsagesRepository = parkingSpacesUsagesRepository;
    }

    @Override
    public ParkingSpacesUsages save(ParkingSpacesUsages parkingSpacesUsages) {
        return parkingSpacesUsagesRepository.save(parkingSpacesUsages);
    }

    @Override
    public ParkingSpacesUsages getById(Long id) {
        return parkingSpacesUsagesRepository.getOne(id);
    }

    @Override
    public Boolean delete(ParkingSpacesUsages parkingSpacesUsages) {
        parkingSpacesUsagesRepository.delete(parkingSpacesUsages);
        return Boolean.TRUE;
    }
}
