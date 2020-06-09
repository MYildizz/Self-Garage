package com.yildizmurat.Service.implementation;

import com.yildizmurat.Entity.ParkingSpacesUsages;
import com.yildizmurat.Entity.ParkingSpacesUsages;
import com.yildizmurat.Repository.ParkingSpacesUsagesRepository;
import com.yildizmurat.Repository.ParkingSpacesRepository;
import com.yildizmurat.Repository.ParkingSpacesUsagesRepository;
import com.yildizmurat.Service.ParkingSpacesUsagesService;
import com.yildizmurat.dto.ParkingSpacesUsagesDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ParkingSpacesUsagesImpl implements ParkingSpacesUsagesService {

    private final ParkingSpacesUsagesRepository parkingSpacesUsagesRepository;
    private final ModelMapper modelMapper;

    public ParkingSpacesUsagesImpl(ParkingSpacesUsagesRepository parkingSpacesUsagesRepository, ModelMapper modelMapper) {
        this.parkingSpacesUsagesRepository = parkingSpacesUsagesRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ParkingSpacesUsagesDto save(ParkingSpacesUsagesDto parkingSpacesUsagesDto) {
        ParkingSpacesUsages parkingSpacesUsages=  modelMapper.map(parkingSpacesUsagesDto,ParkingSpacesUsages.class);
        parkingSpacesUsages= parkingSpacesUsagesRepository.save(parkingSpacesUsages);

        return modelMapper.map(parkingSpacesUsages,ParkingSpacesUsagesDto.class);
    }

    @Override
    public ParkingSpacesUsagesDto getById(Long id) {
        ParkingSpacesUsages parkingSpacesUsages = parkingSpacesUsagesRepository.getOne(id);
        return modelMapper.map(parkingSpacesUsages,ParkingSpacesUsagesDto.class);
    }

    @Override
    public Boolean delete(ParkingSpacesUsagesDto parkingSpacesUsagesDto) {
        ParkingSpacesUsages parkingSpacesUsages=  modelMapper.map(parkingSpacesUsagesDto,ParkingSpacesUsages.class);
        parkingSpacesUsagesRepository.delete(parkingSpacesUsages);
        return Boolean.TRUE;
    }
}
