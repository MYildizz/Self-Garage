package com.yildizmurat.Service.implementation;

import com.yildizmurat.Entity.ParkingOwnerInformation;
import com.yildizmurat.Entity.ParkingOwnerInformation;
import com.yildizmurat.Repository.ParkingOwnerInformationRepository;
import com.yildizmurat.Repository.ParkingOwnerInformationRepository;
import com.yildizmurat.Service.ParkingOwnerInformationService;
import com.yildizmurat.dto.ParkingOwnerInformationDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ParkingOwnerInformationImpl implements ParkingOwnerInformationService {

    private final ParkingOwnerInformationRepository parkingOwnerInformationRepository;
    private final ModelMapper modelMapper;

    public ParkingOwnerInformationImpl() {
        this.parkingOwnerInformationRepository=null;
        this.modelMapper=null;
    }

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
    public Boolean delete(ParkingOwnerInformationDto parkingOwnerInformationDto) {
        ParkingOwnerInformation parkingOwnerInformation=  modelMapper.map(parkingOwnerInformationDto,ParkingOwnerInformation.class);
        parkingOwnerInformationRepository.delete(parkingOwnerInformation);
        return Boolean.TRUE;
    }
}
