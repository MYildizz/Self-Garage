package com.yildizmurat.service.implementation;

import com.yildizmurat.dto.DriverInformationDto;
import com.yildizmurat.dto.ParkingOwnerInformationDto;
import com.yildizmurat.entity.DriverInformation;
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
        try{
            ParkingOwnerInformation parkingOwnerInformation=  modelMapper.map(parkingOwnerInformationDto,ParkingOwnerInformation.class);
            parkingOwnerInformation= parkingOwnerInformationRepository.save(parkingOwnerInformation);

            return modelMapper.map(parkingOwnerInformation,ParkingOwnerInformationDto.class);
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    @Override
    public ParkingOwnerInformationDto getById(Long id) {

        try{
            ParkingOwnerInformation parkingOwnerInformation = parkingOwnerInformationRepository.getOne(id);
            return modelMapper.map(parkingOwnerInformation,ParkingOwnerInformationDto.class);
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    @Override
    public ParkingOwnerInformationDto update(Long id, ParkingOwnerInformationDto parkingOwnerInformationDto) {

        try{
            ParkingOwnerInformation checkDriver = parkingOwnerInformationRepository.getOne(id);

            if (checkDriver == null)
                throw new IllegalArgumentException("Project Code not Exit " + id);
            ParkingOwnerInformation parkingOwnerInformation = modelMapper.map(parkingOwnerInformationDto,ParkingOwnerInformation.class);
            parkingOwnerInformation= parkingOwnerInformationRepository.save(parkingOwnerInformation);

            return modelMapper.map(parkingOwnerInformation,ParkingOwnerInformationDto.class);
        }catch (Exception e){
            System.out.println(e);
            return null;
        }

    }


    @Override
    public Boolean delete(Long id) {
        try{
            parkingOwnerInformationRepository.deleteById(id);
            return Boolean.TRUE;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    @Override
    public Boolean userExist(String userId) {
        try{
            return parkingOwnerInformationRepository.existsParkingOwnerInformationByIdName(userId);
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    @Override
    public Boolean mailExist(String e_mail) {
        try{
            return parkingOwnerInformationRepository.existsParkingOwnerInformationByMail(e_mail);
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    @Override
    public Boolean checkPassword(String password) {
        try{
            return parkingOwnerInformationRepository.existsParkingOwnerInformationByPassword(password);
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    @Override
    public ParkingOwnerInformationDto getByIdName(String IdName) {

        try{
            ParkingOwnerInformation parkingOwnerInformation=parkingOwnerInformationRepository.getByIdName(IdName);
            if(parkingOwnerInformation==null)
                return null;
            else
                return modelMapper.map(parkingOwnerInformation, ParkingOwnerInformationDto.class);
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
}
