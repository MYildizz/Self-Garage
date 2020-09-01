package com.yildizmurat.service.implementation;

import com.yildizmurat.dto.ParkingSpacesDto;
import com.yildizmurat.dto.ParkingSpacesDto;
import com.yildizmurat.entity.ParkStatus;
import com.yildizmurat.entity.ParkingSpaces;
import com.yildizmurat.entity.ParkingSpaces;
import com.yildizmurat.entity.ParkingSpaces;
import com.yildizmurat.repository.ParkingSpacesRepository;
import com.yildizmurat.service.ParkingSpacesService;
import com.yildizmurat.dto.ParkingSpacesDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

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

    @Override
    public Boolean updateByParkId(String parkId, ParkStatus parkStatus) {

        ParkingSpaces parkingSpaces = parkingSpacesRepository.getByIdName(parkId);

        if (parkingSpaces == null)
            throw new IllegalArgumentException("Park area not exists " + parkId);

        parkingSpaces.setParkStatus(parkStatus);
        parkingSpaces= parkingSpacesRepository.save(parkingSpaces);

        ParkingSpaces checkState= parkingSpacesRepository.getByIdName(parkId);
        System.out.println(checkState.getParkStatus());


        if(checkState.getParkStatus()==parkStatus)
            return true;
        return false;

    }

    @Override
    public List<ParkingSpacesDto> getAllByIdOwner(String IdOwner) {

        List<ParkingSpaces> parkingSpaces=parkingSpacesRepository.getAllByIdOwner(IdOwner);
        System.out.println("service : "+IdOwner);
        System.out.println("service : "+parkingSpaces.get(0).getLatitude());
        if(parkingSpaces.isEmpty())
            return null;
        else
            return Arrays.asList(modelMapper.map(parkingSpaces, ParkingSpacesDto[].class));
    }

    @Override
    public List<ParkingSpacesDto> getAllByParkStatusOpen() {

        List<ParkingSpaces> parkingSpacesOpen=parkingSpacesRepository.getAllByParkStatus(ParkStatus.OPEN);

        if(parkingSpacesOpen.isEmpty())
            return null;
        else
            return Arrays.asList(modelMapper.map(parkingSpacesOpen, ParkingSpacesDto[].class));
    }

    @Override
    public List<ParkingSpacesDto> getAllByParkStatusBusy() {

        List<ParkingSpaces> parkingSpacesOpen=parkingSpacesRepository.getAllByParkStatus(ParkStatus.BUSY);

        if(parkingSpacesOpen.isEmpty())
            return null;
        else
            return Arrays.asList(modelMapper.map(parkingSpacesOpen, ParkingSpacesDto[].class));
    }

    @Override
    public Boolean updateParkStatus(String nameId,String ownerId,ParkStatus parkStatus) {
        ParkingSpaces parkingSpaces = parkingSpacesRepository.getByIdNameAndIdOwner(nameId,ownerId);

        if (parkingSpaces == null)
            throw new IllegalArgumentException("Park area not exists " + nameId);

        parkingSpaces.setParkStatus(parkStatus);
        parkingSpaces= parkingSpacesRepository.save(parkingSpaces);

        ParkingSpaces checkState= parkingSpacesRepository.getByIdName(nameId);
        System.out.println("aaa" +checkState.getParkStatus()+ " "+checkState.getIdName());


        if(checkState.getParkStatus()==parkStatus)
            return true;
        return false;
    }
}
