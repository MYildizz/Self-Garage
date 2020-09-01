package com.yildizmurat.service.implementation;

import com.yildizmurat.dto.DriverCreditCardInformationDto;
import com.yildizmurat.dto.ParkingSpacesUsagesDto;
import com.yildizmurat.entity.DriverCreditCardInformation;
import com.yildizmurat.entity.ParkingSpacesUsages;
import com.yildizmurat.entity.ParkingSpacesUsages;
import com.yildizmurat.entity.UsageStatus;
import com.yildizmurat.repository.ParkingSpacesRepository;
import com.yildizmurat.repository.ParkingSpacesUsagesRepository;
import com.yildizmurat.service.ParkingSpacesUsagesService;
import com.yildizmurat.dto.ParkingSpacesUsagesDto;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Service
public class ParkingSpacesUsagesImpl implements ParkingSpacesUsagesService {

    private final ParkingSpacesUsagesRepository parkingSpacesUsagesRepository;
    private final ModelMapper modelMapper;
    public ScheduledTasks scheduledTasks= new ScheduledTasks();

    public ParkingSpacesUsagesImpl(ParkingSpacesUsagesRepository parkingSpacesUsagesRepository, ModelMapper modelMapper) {
        this.parkingSpacesUsagesRepository = parkingSpacesUsagesRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ParkingSpacesUsagesDto save(ParkingSpacesUsagesDto parkingSpacesUsagesDto) throws ParseException {
        ParkingSpacesUsages parkingSpacesUsages=  modelMapper.map(parkingSpacesUsagesDto,ParkingSpacesUsages.class);


        DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        parkingSpacesUsages.setEntry(dateTime.format(now));

        parkingSpacesUsages= parkingSpacesUsagesRepository.save(parkingSpacesUsages);

        return modelMapper.map(parkingSpacesUsages,ParkingSpacesUsagesDto.class);
    }

    @Override
    public ParkingSpacesUsagesDto getById(Long id) {
        ParkingSpacesUsages parkingSpacesUsages = parkingSpacesUsagesRepository.getOne(id);
        return modelMapper.map(parkingSpacesUsages,ParkingSpacesUsagesDto.class);
    }

    @Override
    public ParkingSpacesUsagesDto update(Long id, ParkingSpacesUsagesDto parkingSpacesUsagesDto) {

        ParkingSpacesUsages checkDriver = parkingSpacesUsagesRepository.getOne(id);

        if (checkDriver == null)
            throw new IllegalArgumentException("Project Code not Exist " + id);
        ParkingSpacesUsages parkingSpacesUsages = modelMapper.map(parkingSpacesUsagesDto,ParkingSpacesUsages.class);
        parkingSpacesUsages= parkingSpacesUsagesRepository.save(parkingSpacesUsages);

        return modelMapper.map(parkingSpacesUsages,ParkingSpacesUsagesDto.class);

    }

    @Override
    public List<ParkingSpacesUsagesDto> getByDriver(String driverId) {

        List<ParkingSpacesUsages> parkingSpacesUsages=parkingSpacesUsagesRepository.getAllByDriver(driverId);

        if(parkingSpacesUsages.isEmpty())
            return null;
        else
            return Arrays.asList(modelMapper.map(parkingSpacesUsages,ParkingSpacesUsagesDto[].class));
        }

    @Override
    public List<ParkingSpacesUsagesDto> getByOwner(String ownerId) {
        List<ParkingSpacesUsages> parkingSpacesUsages=parkingSpacesUsagesRepository.getAllByOwner(ownerId);

        if(parkingSpacesUsages.isEmpty())
            return null;
        else
            return Arrays.asList(modelMapper.map(parkingSpacesUsages,ParkingSpacesUsagesDto[].class));
    }

    @Override
    public ParkingSpacesUsagesDto getByDriverAndUsageStatus(String Driver) {

        ParkingSpacesUsages parkingSpacesUsages = parkingSpacesUsagesRepository.getByDriverAndDeparture(Driver,null);




        if(parkingSpacesUsages==null)
            return null;

        return modelMapper.map(parkingSpacesUsages,ParkingSpacesUsagesDto.class);
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
                beginStringTime=parkingSpacesUsages.getEntry();
                currentStringTime=scheduledTasks.getTime();
                LocalDateTime beginTime=scheduledTasks.convertStringToLocalDateTime(beginStringTime);
                LocalDateTime currentTime=scheduledTasks.convertStringToLocalDateTime(currentStringTime);
                timeDifference=scheduledTasks.calculateTimeDifference(beginTime,currentTime);


                parkingSpacesUsages.setUsageStatus(usageStatus);
                parkingSpacesUsages.setDeparture(currentStringTime);
                parkingSpacesUsages.setTotalTime(timeDifference);
                parkingSpacesUsages.setPrice(scheduledTasks.calculatePrice(timeDifference));

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
        parkingSpacesUsagesRepository.deleteById(id);
        return Boolean.TRUE;
    }
}
