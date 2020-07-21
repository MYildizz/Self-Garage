package com.yildizmurat.service.implementation;

import com.yildizmurat.dto.ParkingSpacesUsagesDto;
import com.yildizmurat.entity.DriverInformation;

import com.yildizmurat.entity.ParkingSpacesUsages;
import com.yildizmurat.repository.DriverInformationRepository;
import com.yildizmurat.service.DriverInformationService;
import com.yildizmurat.dto.DriverInformationDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service

public class DriverInformationImpl implements DriverInformationService {


    private final DriverInformationRepository driverInformationRepository;
    private final ModelMapper modelMapper;


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
    public DriverInformationDto update(Long id, DriverInformationDto driverInformationDto) {

        DriverInformation checkDriver = driverInformationRepository.getOne(id);

        if (checkDriver == null)
            throw new IllegalArgumentException("Project Code not Exit " + id);
        DriverInformation driverInformation = modelMapper.map(driverInformationDto,DriverInformation.class);
        driverInformation= driverInformationRepository.save(driverInformation);

        return modelMapper.map(driverInformation,DriverInformationDto.class);

    }



    @Override
    public Boolean delete(Long id) {
             driverInformationRepository.deleteById(id);
        return Boolean.TRUE;
    }

    @Override
    public Boolean userExist(String userId) {

        return driverInformationRepository.existsDriverInformationByIdName(userId);
    }

    @Override
    public Boolean mailExist(String e_mail) {
        return driverInformationRepository.existsDriverInformationByMail(e_mail);
    }

    @Override
    public Boolean checkPassword(String password) {
        return driverInformationRepository.existsDriverInformationByPassword(password);
    }

    @Override
    public DriverInformationDto getByIdName(String IdName) {

        DriverInformation driverInformation=driverInformationRepository.getByIdName(IdName);

        if(driverInformation==null)
            return null;
        else
            return modelMapper.map(driverInformation, DriverInformationDto.class);

    }
}
