package com.yildizmurat.service.implementation;

import com.yildizmurat.dto.ParkingSpacesDto;
import com.yildizmurat.dto.ParkingSpacesUsagesDto;
import com.yildizmurat.entity.ParkStatus;
import com.yildizmurat.entity.ParkingSpaces;
import com.yildizmurat.entity.UsageStatus;
import com.yildizmurat.repository.ParkingSpacesRepository;
import com.yildizmurat.service.ParkingSpacesService;
import com.yildizmurat.service.firebase.FirebaseInitialize;
import org.modelmapper.ModelMapper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

@Service
public class ParkingSpacesImpl implements ParkingSpacesService {

    private final ParkingSpacesRepository parkingSpacesRepository;
    private final ModelMapper modelMapper;
    FirebaseInitialize firebase=new FirebaseInitialize();
    private int flag=0;

    String nameId,ownerId;

    public ParkingSpacesImpl(ParkingSpacesRepository parkingSpacesRepository, ModelMapper modelMapper) {
        this.parkingSpacesRepository = parkingSpacesRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ParkingSpacesDto save(ParkingSpacesDto parkingSpacesDto) {

        try{
            ParkingSpaces parkingSpaces=  modelMapper.map(parkingSpacesDto,ParkingSpaces.class);
            parkingSpaces= parkingSpacesRepository.save(parkingSpaces);

            return modelMapper.map(parkingSpaces,ParkingSpacesDto.class);

        }
        catch (Exception e){
            System.out.println(e);
            return null;
        }

    }

    @Override
    public ParkingSpacesDto getById(Long id) {

        try{
            ParkingSpaces parkingSpaces = parkingSpacesRepository.getOne(id);
            return modelMapper.map(parkingSpaces,ParkingSpacesDto.class);
        }
        catch (Exception e){
            System.out.println(e);
            return null;
        }

    }

    @Override
    public ParkingSpacesDto update(Long id, ParkingSpacesDto parkingSpacesDto) {


        try{
            ParkingSpaces checkDriver = parkingSpacesRepository.getOne(id);

            if (checkDriver == null)
                throw new IllegalArgumentException("Project Code not Exit " + id);
            ParkingSpaces parkingSpaces = modelMapper.map(parkingSpacesDto,ParkingSpaces.class);
            parkingSpaces= parkingSpacesRepository.save(parkingSpaces);

            return modelMapper.map(parkingSpaces,ParkingSpacesDto.class);
        }
        catch (Exception e){
            System.out.println(e);
            return null;
        }

    }

    @Override
    public Boolean delete(Long id) {
        try{
            parkingSpacesRepository.deleteById(id);
            return Boolean.TRUE;
        }
        catch (Exception e){
            return Boolean.FALSE;
        }
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

        try {
            ParkingSpaces parkingSpaces = parkingSpacesRepository.getByIdNameAndIdOwner(nameId,ownerId);

            if (parkingSpaces == null)
                throw new IllegalArgumentException("Park area not exists " + nameId);

            parkingSpaces.setParkStatus(parkStatus);
            parkingSpaces= parkingSpacesRepository.save(parkingSpaces);

            if(parkStatus==ParkStatus.BUSY){
                this.nameId=nameId;
                this.ownerId=ownerId;
                flag=1;
                checkSignal();
            }
            ParkingSpaces checkState= parkingSpacesRepository.getByIdName(nameId);
            if(checkState.getParkStatus()==parkStatus)
                return true;
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }


    @Override
    public Boolean updateParkStatusWithTimer(String firstDate, String secondDate, String currentPark) {

        try {
            parkingSpacesRepository.createEventOpen(firstDate,currentPark);
            parkingSpacesRepository.createEventClose(secondDate,currentPark);
            return true;
        }catch (Exception e){
            System.out.println(e);
        }

        return false;
    }

    @Scheduled(cron="*/5 * * * * *", zone="Europe/Istanbul")
    private void checkSignal(){
        if(flag==1){
            firebase.getSignal();
            if(firebase.isCheckSignal()==true) {

                try {
                    updateParkStatus(nameId,ownerId,ParkStatus.OPEN);
                }catch (Exception e){
                    System.out.println(e);
                }

                flag=0;
            }
        }
    }

}


