package com.yildizmurat.service.implementation;

import com.yildizmurat.dto.ParkingOwnerInformationDto;
import com.yildizmurat.dto.ParkingSpacesUsagesDto;
import com.yildizmurat.entity.*;
import com.yildizmurat.repository.ParkingSpacesRepository;
import com.yildizmurat.repository.ParkingSpacesUsagesRepository;
import com.yildizmurat.service.ParkingSpacesUsagesService;
import com.yildizmurat.service.firebase.FirebaseInitialize;
import org.modelmapper.ModelMapper;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

@EnableScheduling
@Service
public class ParkingSpacesUsagesImpl implements ParkingSpacesUsagesService {


    private final ParkingSpacesUsagesRepository parkingSpacesUsagesRepository;
    private final ParkingSpacesRepository parkingSpacesRepository;
    private final ModelMapper modelMapper;
    public ScheduledTasks scheduledTasks= new ScheduledTasks();
    FirebaseInitialize firebase=new FirebaseInitialize();
    private int flag=0;
    private int flag2=0;
    private String Driver;

    public ParkingSpacesUsagesImpl(ParkingSpacesUsagesRepository parkingSpacesUsagesRepository, ParkingSpacesRepository parkingSpacesRepository, ModelMapper modelMapper) {
        this.parkingSpacesUsagesRepository = parkingSpacesUsagesRepository;
        this.parkingSpacesRepository = parkingSpacesRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ParkingSpacesUsagesDto save(ParkingSpacesUsagesDto parkingSpacesUsagesDto) throws ParseException {

        try{
            ParkingSpacesUsages parkingSpacesUsages=  modelMapper.map(parkingSpacesUsagesDto,ParkingSpacesUsages.class);
            DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            parkingSpacesUsages.setEntry(dateTime.format(now));
            parkingSpacesUsages= parkingSpacesUsagesRepository.save(parkingSpacesUsages);
            check10minute(parkingSpacesUsages.getDriver(),parkingSpacesUsages.getName());
            return modelMapper.map(parkingSpacesUsages,ParkingSpacesUsagesDto.class);
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    @Override
    public void check10minute(String driverId,String parkId) {


        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(driverId!=null && parkId!=null){

                    ParkingSpacesUsagesDto parkingSpacesUsagesDto;
                    parkingSpacesUsagesDto= getByDriverAndUsageStatus(driverId);

                    if(parkingSpacesUsagesDto.getUsageStatus()==UsageStatus.REZERVE){
                        updateByDriverAndUsageStatus(driverId,UsageStatus.FINISH);

                        ParkingSpaces parkingSpaces = parkingSpacesRepository.getByIdName(parkId);

                        if (parkingSpaces == null)
                            throw new IllegalArgumentException("Park area not exists " + parkId);

                        parkingSpaces.setParkStatus(ParkStatus.OPEN);
                        parkingSpaces= parkingSpacesRepository.save(parkingSpaces);

                    }
                }
                else{
                    System.out.println("driver Id empty");
                }
            }
        }, 600000);


    }

    @Override
    public ParkingSpacesUsagesDto getById(Long id) {

        try{
            ParkingSpacesUsages parkingSpacesUsages = parkingSpacesUsagesRepository.getOne(id);
            return modelMapper.map(parkingSpacesUsages,ParkingSpacesUsagesDto.class);
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    @Override
    public ParkingSpacesUsagesDto update(Long id, ParkingSpacesUsagesDto parkingSpacesUsagesDto) {

        try{
            ParkingSpacesUsages checkDriver = parkingSpacesUsagesRepository.getOne(id);
            if (checkDriver == null)
                throw new IllegalArgumentException("Project Code not Exist " + id);
            ParkingSpacesUsages parkingSpacesUsages = modelMapper.map(parkingSpacesUsagesDto,ParkingSpacesUsages.class);
            parkingSpacesUsages= parkingSpacesUsagesRepository.save(parkingSpacesUsages);
            return modelMapper.map(parkingSpacesUsages,ParkingSpacesUsagesDto.class);
        }catch (Exception e){
            System.out.println(e);
            return null;
        }

    }

    @Override
    public List<ParkingSpacesUsagesDto> getByDriver(String driverId) {

        try{
            List<ParkingSpacesUsages> parkingSpacesUsages=parkingSpacesUsagesRepository.getAllByDriver(driverId);
            if(parkingSpacesUsages.isEmpty())
                return null;
            else
                return Arrays.asList(modelMapper.map(parkingSpacesUsages,ParkingSpacesUsagesDto[].class));
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    @Override
    public List<ParkingSpacesUsagesDto> getByOwner(String ownerId) {

        try{
            List<ParkingSpacesUsages> parkingSpacesUsages=parkingSpacesUsagesRepository.getAllByOwner(ownerId);
            if(parkingSpacesUsages.isEmpty())
                return null;
            else
                return Arrays.asList(modelMapper.map(parkingSpacesUsages,ParkingSpacesUsagesDto[].class));
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    @Override
    public ParkingSpacesUsagesDto getByDriverAndUsageStatus(String Driver) {

        try{
            ParkingSpacesUsages parkingSpacesUsages = parkingSpacesUsagesRepository.getByDriverAndDeparture(Driver,null);
            if(parkingSpacesUsages==null)
                return null;
            return modelMapper.map(parkingSpacesUsages,ParkingSpacesUsagesDto.class);
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    @Override
    public Boolean updateByDriverAndUsageStatus(String Driver, UsageStatus usageStatus) {

        String currentStringTime;
        String beginStringTime;
        String timeDifference;

        if(Driver==null || usageStatus==null){
            throw new IllegalArgumentException("Empty information ");
        }
        else{

            try{
                ParkingSpacesUsages parkingSpacesUsages = parkingSpacesUsagesRepository.getByDriverAndDeparture(Driver,null);

                if(usageStatus==UsageStatus.USAGE){
                    parkingSpacesUsages.setUsageStatus(usageStatus);

                    flag=1;
                    this.Driver=Driver;
                    checkSignal();

                }
                else{
                    beginStringTime=parkingSpacesUsages.getEntry();
                    currentStringTime=scheduledTasks.getTime();
                    LocalDateTime beginTime=scheduledTasks.convertStringToLocalDateTime(beginStringTime);
                    LocalDateTime currentTime=scheduledTasks.convertStringToLocalDateTime(currentStringTime);
                    timeDifference=scheduledTasks.calculateTimeDifference(beginTime,currentTime);


                    parkingSpacesUsages.setUsageStatus(usageStatus);
                    parkingSpacesUsages.setDeparture(currentStringTime);
                    parkingSpacesUsages.setTotalTime(timeDifference);
                    parkingSpacesUsages.setPrice(scheduledTasks.calculatePrice(timeDifference));
                }

                parkingSpacesUsagesRepository.save(parkingSpacesUsages);


            }catch (Exception e){
                System.out.println("Error from update : "+e);
                return false;
            }

        }

        return true;
    }


    @Override
    public Boolean delete(Long id) {
        try{
            parkingSpacesUsagesRepository.deleteById(id);
            return Boolean.TRUE;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    @Scheduled(cron="*/5 * * * * *", zone="Europe/Istanbul")
    private void checkSignal(){
        if(flag==1){
            firebase.setFlag(1);
            firebase.getSignal();
            if(firebase.isCheckSignal()==true) {
                System.out.println("aaaaa");
                updateByDriverAndUsageStatus(Driver,UsageStatus.FINISH);
                flag=0;
            }
        }
    }
}


