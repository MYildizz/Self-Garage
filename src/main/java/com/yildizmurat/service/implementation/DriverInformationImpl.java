package com.yildizmurat.service.implementation;

import com.yildizmurat.dto.ParkingSpacesUsagesDto;
import com.yildizmurat.entity.DriverInformation;

import com.yildizmurat.entity.ParkingSpacesUsages;
import com.yildizmurat.repository.DriverInformationRepository;
import com.yildizmurat.service.DriverInformationService;
import com.yildizmurat.dto.DriverInformationDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
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

        try{
            DriverInformation driverInformation=  modelMapper.map(driverInformationDto,DriverInformation.class);
            driverInformation= driverInformationRepository.save(driverInformation);
            return modelMapper.map(driverInformation,DriverInformationDto.class);
        }catch (Exception e){
            System.out.println(e);
            return null;
        }

    }

    @Override
    public DriverInformationDto getById(Long id) {

        try{
            DriverInformation driverInformation = driverInformationRepository.getOne(id);
            return modelMapper.map(driverInformation,DriverInformationDto.class);
        }catch (Exception e){
            System.out.println(e);
            return null;
        }

    }

    @Override
    public DriverInformationDto update(Long id, DriverInformationDto driverInformationDto) {

        try{
            DriverInformation checkDriver = driverInformationRepository.getOne(id);

            if (checkDriver == null)
                throw new IllegalArgumentException("Project Code not Exit " + id);
            DriverInformation driverInformation = modelMapper.map(driverInformationDto,DriverInformation.class);
            driverInformation= driverInformationRepository.save(driverInformation);

            return modelMapper.map(driverInformation,DriverInformationDto.class);
        }catch (Exception e){
            System.out.println(e);
            return null;
        }

    }

    @Override
    public Boolean delete(Long id) {

        try{
            driverInformationRepository.deleteById(id);
            return Boolean.TRUE;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }

    }

    @Override
    public Boolean userExist(String userId) {

        try{
            return driverInformationRepository.existsDriverInformationByIdName(userId);
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    @Override
    public Boolean mailExist(String e_mail) {
        try{
            return driverInformationRepository.existsDriverInformationByMail(e_mail);
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    @Override
    public Boolean checkPassword(String password) {
        try{
            return driverInformationRepository.existsDriverInformationByPassword(password);
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    @Override
    public DriverInformationDto getByIdName(String IdName) {

        try{
            DriverInformation driverInformation=driverInformationRepository.getByIdName(IdName);

            if(driverInformation==null)
                return null;
            else
                return modelMapper.map(driverInformation, DriverInformationDto.class);
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
}
