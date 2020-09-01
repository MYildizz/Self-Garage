package com.yildizmurat.api;


import com.yildizmurat.dto.ParkingSpacesDto;
import com.yildizmurat.dto.ParkingSpacesUsagesDto;
import com.yildizmurat.entity.ParkStatus;
import com.yildizmurat.entity.UsageStatus;
import com.yildizmurat.service.implementation.ParkingSpacesUsagesImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/information/parkingSpacesUsagesApi")
public class ParkingSpacesUsagesApi {

    private final ParkingSpacesUsagesImpl parkingSpacesUsagesImpl;
    DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public ParkingSpacesUsagesApi(ParkingSpacesUsagesImpl parkingSpacesUsagesImpl) {
        this.parkingSpacesUsagesImpl = parkingSpacesUsagesImpl;
    }
    // GET
    @GetMapping("/{id}")
    public ResponseEntity<ParkingSpacesUsagesDto> getById(@PathVariable("id") Long id){
        ParkingSpacesUsagesDto parkingSpacesUsagesDto = parkingSpacesUsagesImpl.getById(1L);
        return ResponseEntity.ok(parkingSpacesUsagesDto);
    }
    // POST
    @PostMapping
    public ResponseEntity<ParkingSpacesUsagesDto> createParkingSpacesUsages(@Valid @RequestBody ParkingSpacesUsagesDto parkingSpacesUsagesDto){

        try {
            return ResponseEntity.ok(parkingSpacesUsagesImpl.save(parkingSpacesUsagesDto));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    // GET
    @PutMapping("/{id}")
    public ResponseEntity<ParkingSpacesUsagesDto> updateParkingSpacesUsages(@PathVariable("id") Long id, @Valid @RequestBody ParkingSpacesUsagesDto parkingSpacesUsagesDto){
        return ResponseEntity.ok(parkingSpacesUsagesImpl.update(id,parkingSpacesUsagesDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value ="id",required = true) Long id ){
        Boolean isSuccesful =  parkingSpacesUsagesImpl.delete(id);
        return ResponseEntity.ok(isSuccesful);
    }
    @GetMapping("/getParkingSpacesUsagesDriver/{id}")
    public List<ParkingSpacesUsagesDto> getParkingSpacesUsagesDriver(@PathVariable("id") String id){
        List<ParkingSpacesUsagesDto> info =parkingSpacesUsagesImpl.getByDriver(id);

        return info;
    }

    @GetMapping("/getParkingSpacesUsagesOwner/{ownerId}")
    public List<ParkingSpacesUsagesDto> getParkingSpacesUsagesOwner(@PathVariable("ownerId") String ownerId){

        return parkingSpacesUsagesImpl.getByOwner(ownerId);
    }

    @RequestMapping(value="/addUsages",method = RequestMethod.POST)
    public ParkingSpacesUsagesDto addParkingUsages(@Valid @RequestBody ParkingSpacesUsagesDto parkingSpacesUsagesDto){


        try {
            return parkingSpacesUsagesImpl.save(parkingSpacesUsagesDto);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/getActiveParking/{id}")
    public ParkingSpacesUsagesDto getActiveParking(@PathVariable("id") String id){

        ParkingSpacesUsagesDto info =parkingSpacesUsagesImpl.getByDriverAndUsageStatus(id);

        return info;
    }

    @RequestMapping(value="/finishParking",method = RequestMethod.POST)
    public Boolean finishParking(@Valid @RequestBody ParkingSpacesUsagesDto parkingSpacesUsagesDto){

        String driver= parkingSpacesUsagesDto.getDriver();
        UsageStatus status=parkingSpacesUsagesDto.getUsageStatus();

        try {
            return parkingSpacesUsagesImpl.updateByDriverAndUsageStatus(driver,status);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
