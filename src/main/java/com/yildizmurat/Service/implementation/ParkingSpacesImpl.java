package com.yildizmurat.Service.implementation;

import com.yildizmurat.Entity.ParkingSpaces;
import com.yildizmurat.Entity.ParkingSpaces;
import com.yildizmurat.Repository.ParkingSpacesRepository;
import com.yildizmurat.Repository.ParkingSpacesRepository;
import com.yildizmurat.Service.ParkingSpacesService;
import com.yildizmurat.dto.ParkingSpacesDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ParkingSpacesImpl implements ParkingSpacesService {

    private final ParkingSpacesRepository parkingSpacesRepository;
    private final ModelMapper modelMapper;

    public ParkingSpacesImpl() {
        this.parkingSpacesRepository=null;
        this.modelMapper=null;
    }

    public ParkingSpacesImpl(ParkingSpacesRepository parkingSpacesRepository, ModelMapper modelMapper) {
        this.parkingSpacesRepository = parkingSpacesRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ParkingSpacesDto save(ParkingSpacesDto parkingSpacesDto) {
        ParkingSpaces parkingSpaces=  modelMapper.map(parkingSpacesDto,ParkingSpaces.class);
        parkingSpaces= parkingSpacesRepository.save(parkingSpaces);

        return modelMapper.map(parkingSpaces,ParkingSpacesDto.class);
    }

    @Override
    public ParkingSpacesDto getById(Long id) {
        ParkingSpaces parkingSpaces = parkingSpacesRepository.getOne(id);
        return modelMapper.map(parkingSpaces,ParkingSpacesDto.class);
    }

    @Override
    public Boolean delete(ParkingSpacesDto parkingSpacesDto) {
        ParkingSpaces parkingSpaces=  modelMapper.map(parkingSpacesDto,ParkingSpaces.class);
        parkingSpacesRepository.delete(parkingSpaces);
        return Boolean.TRUE;
    }
}
