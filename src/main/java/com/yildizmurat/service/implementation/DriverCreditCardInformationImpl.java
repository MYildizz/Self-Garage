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

        try{
            return driverCreditCardInformationRepository.save(driverCreditCardInformation);
        }catch (Exception e){
            System.out.println(e);
            return null;
        }

    }

    @Override
    public DriverCreditCardInformation getById(Long id) {
        try{
            return driverCreditCardInformationRepository.getOne(id);
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    @Override
    public Boolean delete(DriverCreditCardInformation driverCreditCardInformation) {

        try{
            driverCreditCardInformationRepository.delete(driverCreditCardInformation);
            return Boolean.TRUE;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }

    }

    @Override
    public List<DriverCreditCardInformationDto> getDriverCreditCardInformation(String idName) {

        try{
            long id =0;
            List<DriverCreditCardInformation> driverCreditCardInformation=driverCreditCardInformationRepository.getAllByIdName(idName);
            if(driverCreditCardInformation.isEmpty())
                return null;
            else{
                return Arrays.asList(modelMapper.map(driverCreditCardInformation,DriverCreditCardInformationDto[].class));
            }
        }catch (Exception e){
            System.out.println(e);
            return null;
        }

    }
}
