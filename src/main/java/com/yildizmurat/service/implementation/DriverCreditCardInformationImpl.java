package com.yildizmurat.service.implementation;

import com.yildizmurat.dto.DriverCreditCardInformationDto;
import com.yildizmurat.entity.DriverCreditCardInformation;
import com.yildizmurat.repository.DriverCreditCardInformationRepository;
import com.yildizmurat.service.DriverCreditCardInformationService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DriverCreditCardInformationImpl implements DriverCreditCardInformationService {

    private final DriverCreditCardInformationRepository driverCreditCardInformationRepository;
    private final ModelMapper modelMapper;

    public DriverCreditCardInformationImpl(DriverCreditCardInformationRepository driverCreditCardInformationRepository, ModelMapper modelMapper) {
        this.driverCreditCardInformationRepository = driverCreditCardInformationRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public DriverCreditCardInformation save(DriverCreditCardInformation driverCreditCardInformation) {
        return driverCreditCardInformationRepository.save(driverCreditCardInformation);
    }

    @Override
    public DriverCreditCardInformation getById(Long id) {
        return driverCreditCardInformationRepository.getOne(id);
    }

    @Override
    public Boolean delete(DriverCreditCardInformation driverCreditCardInformation) {
        driverCreditCardInformationRepository.delete(driverCreditCardInformation);
        return Boolean.TRUE;
    }

    @Override
    public List<DriverCreditCardInformationDto> getDriverCreditCardInformation(String idName) {
        long id =0;
        List<DriverCreditCardInformation> driverCreditCardInformation=driverCreditCardInformationRepository.getAllByIdName(idName);
        if(driverCreditCardInformation.isEmpty())
        return null;
        else{
            return Arrays.asList(modelMapper.map(driverCreditCardInformation,DriverCreditCardInformationDto[].class));
        }
     //   List<User> data = userRepository.findAll();
     //   return Arrays.asList(modelMapper.map(data, UserDto[].class));
    }
}
