package com.yildizmurat.service.implementation;

import com.yildizmurat.dto.ParkingSpacesUsagesDto;
import com.yildizmurat.entity.ParkingSpacesUsages;
import com.yildizmurat.entity.ParkingSpacesUsages;
import com.yildizmurat.repository.ParkingSpacesUsagesRepository;
import com.yildizmurat.service.ParkingSpacesUsagesService;
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
    public ParkingSpacesUsagesDto update(Long id, ParkingSpacesUsagesDto parkingSpacesUsagesDto) {

        ParkingSpacesUsages checkDriver = parkingSpacesUsagesRepository.getOne(id);

        if (checkDriver == null)
            throw new IllegalArgumentException("Project Code not Exit " + id);
        ParkingSpacesUsages parkingSpacesUsages = modelMapper.map(parkingSpacesUsagesDto,ParkingSpacesUsages.class);
        parkingSpacesUsages= parkingSpacesUsagesRepository.save(parkingSpacesUsages);

        return modelMapper.map(parkingSpacesUsages,ParkingSpacesUsagesDto.class);

    }


    @Override
    public Boolean delete(Long id) {
        parkingSpacesUsagesRepository.deleteById(id);
        return Boolean.TRUE;
    }
}
