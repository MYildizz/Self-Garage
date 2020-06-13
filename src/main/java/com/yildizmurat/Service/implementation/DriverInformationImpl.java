package com.yildizmurat.Service.implementation;

import com.yildizmurat.Entity.DriverInformation;

import com.yildizmurat.Repository.DriverInformationRepository;
import com.yildizmurat.Service.DriverInformationService;
import com.yildizmurat.dto.DriverInformationDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class DriverInformationImpl implements DriverInformationService {

    private final DriverInformationRepository driverInformationRepository;
    private final ModelMapper modelMapper;

    public DriverInformationImpl() {
        this.driverInformationRepository=null;
        this.modelMapper=null;
    }

    public DriverInformationImpl(DriverInformationRepository driverInformationRepository, ModelMapper modelMapper) {
        this.driverInformationRepository = driverInformationRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public DriverInformationDto save(DriverInformationDto driverInformationDto) {



        DriverInformation driverInformation=  modelMapper.map(driverInformationDto,DriverInformation.class);
        driverInformation= driverInformationRepository.save(driverInformation);

        return modelMapper.map(driverInformation,DriverInformationDto.class);
    }

    @Override
    public DriverInformationDto getById(Long id) {
        DriverInformation driverInformation = driverInformationRepository.getOne(id);
        return modelMapper.map(driverInformation,DriverInformationDto.class);
    }

    @Override
    public Boolean delete(DriverInformationDto driverInformationDto) {
        DriverInformation driverInformation=  modelMapper.map(driverInformationDto,DriverInformation.class);
        driverInformationRepository.delete(driverInformation);
        return Boolean.TRUE;
    }
}
