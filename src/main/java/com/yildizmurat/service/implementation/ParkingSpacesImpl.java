package com.yildizmurat.service.implementation;

import com.yildizmurat.dto.ParkingSpacesDto;
import com.yildizmurat.entity.ParkingSpaces;
import com.yildizmurat.entity.ParkingSpaces;
import com.yildizmurat.repository.ParkingSpacesRepository;
import com.yildizmurat.service.ParkingSpacesService;
import com.yildizmurat.dto.ParkingSpacesDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ParkingSpacesImpl implements ParkingSpacesService {

    private final ParkingSpacesRepository parkingSpacesRepository;
    private final ModelMapper modelMapper;


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
    public ParkingSpacesDto update(Long id, ParkingSpacesDto parkingSpacesDto) {

        ParkingSpaces checkDriver = parkingSpacesRepository.getOne(id);

        if (checkDriver == null)
            throw new IllegalArgumentException("Project Code not Exit " + id);
        ParkingSpaces parkingSpaces = modelMapper.map(parkingSpacesDto,ParkingSpaces.class);
        parkingSpaces= parkingSpacesRepository.save(parkingSpaces);

        return modelMapper.map(parkingSpaces,ParkingSpacesDto.class);

    }


    @Override
    public Boolean delete(Long id) {
        parkingSpacesRepository.deleteById(id);
        return Boolean.TRUE;
    }
}
