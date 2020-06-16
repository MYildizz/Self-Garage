package com.yildizmurat.service.implementation;

import com.yildizmurat.dto.ParkingOwnerInformationDto;
import com.yildizmurat.entity.ParkingOwnerInformation;
import com.yildizmurat.entity.ParkingOwnerInformation;
import com.yildizmurat.repository.ParkingOwnerInformationRepository;
import com.yildizmurat.service.ParkingOwnerInformationService;
import com.yildizmurat.dto.ParkingOwnerInformationDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ParkingOwnerInformationImpl implements ParkingOwnerInformationService {

    private final ParkingOwnerInformationRepository parkingOwnerInformationRepository;
    private final ModelMapper modelMapper;


    public ParkingOwnerInformationImpl(ParkingOwnerInformationRepository parkingOwnerInformationRepository, ModelMapper modelMapper) {
        this.parkingOwnerInformationRepository = parkingOwnerInformationRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ParkingOwnerInformationDto save(ParkingOwnerInformationDto parkingOwnerInformationDto) {
        ParkingOwnerInformation parkingOwnerInformation=  modelMapper.map(parkingOwnerInformationDto,ParkingOwnerInformation.class);
        parkingOwnerInformation= parkingOwnerInformationRepository.save(parkingOwnerInformation);

        return modelMapper.map(parkingOwnerInformation,ParkingOwnerInformationDto.class);
    }

    @Override
    public ParkingOwnerInformationDto getById(Long id) {
        ParkingOwnerInformation parkingOwnerInformation = parkingOwnerInformationRepository.getOne(id);
        return modelMapper.map(parkingOwnerInformation,ParkingOwnerInformationDto.class);
    }

    @Override
    public ParkingOwnerInformationDto update(Long id, ParkingOwnerInformationDto parkingOwnerInformationDto) {

        ParkingOwnerInformation checkDriver = parkingOwnerInformationRepository.getOne(id);

        if (checkDriver == null)
            throw new IllegalArgumentException("Project Code not Exit " + id);
        ParkingOwnerInformation parkingOwnerInformation = modelMapper.map(parkingOwnerInformationDto,ParkingOwnerInformation.class);
        parkingOwnerInformation= parkingOwnerInformationRepository.save(parkingOwnerInformation);

        return modelMapper.map(parkingOwnerInformation,ParkingOwnerInformationDto.class);

    }


    @Override
    public Boolean delete(Long id) {
        parkingOwnerInformationRepository.deleteById(id);
        return Boolean.TRUE;
    }
}
