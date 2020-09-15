package com.yildizmurat.api;


import com.yildizmurat.dto.DriverInformationDto;
import com.yildizmurat.dto.ParkingSpacesDto;
import com.yildizmurat.entity.ParkStatus;
import com.yildizmurat.service.implementation.ParkingSpacesImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/information/parkingSpacesApi")
public class ParkingSpacesApi {

    private final ParkingSpacesImpl parkingSpacesImpl;

    public ParkingSpacesApi(ParkingSpacesImpl parkingSpacesImpl) {
        this.parkingSpacesImpl = parkingSpacesImpl;
    }
    // GET
    @GetMapping("/{id}")
    public ResponseEntity<ParkingSpacesDto> getById(@PathVariable("id") Long id){
        if(id==null ){
            return null;
        }
        ParkingSpacesDto parkingSpacesDto = parkingSpacesImpl.getById(1L);
        return ResponseEntity.ok(parkingSpacesDto);
    }
    // POST
    @PostMapping
    public ResponseEntity<ParkingSpacesDto> createParkingSpaces(@Valid @RequestBody ParkingSpacesDto parkingSpacesDto){
        if(parkingSpacesDto==null ){
            return null;
        }
        return ResponseEntity.ok(parkingSpacesImpl.save(parkingSpacesDto));
    }

    // GET
    @PutMapping("/{id}")
    public ResponseEntity<ParkingSpacesDto> updateParkingSpaces(@PathVariable("id") Long id, @Valid @RequestBody ParkingSpacesDto parkingSpacesDto){
        if(id==null || parkingSpacesDto==null){
            return null;
        }
        return ResponseEntity.ok(parkingSpacesImpl.update(id,parkingSpacesDto));
    }

    @RequestMapping(value="/updateByParkId/{parkId}",method = RequestMethod.PUT)
    public Boolean updateByParkId(@PathVariable("parkId") String parkId, @Valid @RequestBody ParkStatus parkStatus){

        if (parkId==null || parkStatus==null)
        {
            System.out.println("Değerler boş");
            return false;
        }
        Boolean isTrue= parkingSpacesImpl.updateByParkId(parkId,parkStatus);
        return isTrue;
    }

    @GetMapping("getAllByOwnerId/{id}")
    public List<ParkingSpacesDto> getAllByOwnerId(@PathVariable("id") String id){

        if(id==null){
            return null;
        }
        List<ParkingSpacesDto> parkingSpacesDto = parkingSpacesImpl.getAllByIdOwner(id);
        System.out.println("api "+ id);
        if(parkingSpacesDto==null)
            return null;

        return parkingSpacesDto;
    }

    @GetMapping("getAllByParkStatusOpen")
    public List<ParkingSpacesDto> getAllByParkStatusOpen(){
        List<ParkingSpacesDto> parkingSpacesDto = parkingSpacesImpl.getAllByParkStatusOpen();
        System.out.println(parkingSpacesDto);
        if(parkingSpacesDto==null)
            return null;

        return parkingSpacesDto;
    }

    @GetMapping("getAllByParkStatusBusy")
    public List<ParkingSpacesDto> getAllByParkStatusBusy(){
        List<ParkingSpacesDto> parkingSpacesDto = parkingSpacesImpl.getAllByParkStatusBusy();
        System.out.println(parkingSpacesDto);
        if(parkingSpacesDto==null)
            return null;

        return parkingSpacesDto;
    }

    @RequestMapping(value="/changeParkStatus",method = RequestMethod.POST)
    public Boolean checkDriverInformation(@Valid @RequestBody ParkingSpacesDto parkingSpacesDto){
        if(parkingSpacesDto==null){
            return null;
        }
        String nameId= parkingSpacesDto.getNameId();
        String ownerId=parkingSpacesDto.getOwnerId();
        ParkStatus parkStatus=parkingSpacesDto.getParkStatus();
        if(nameId==null && ownerId==null )
            return false;

        return parkingSpacesImpl.updateParkStatus(nameId,ownerId,parkStatus);
    }

    @RequestMapping(value="/changeParkStatusWithTimer",method = RequestMethod.POST)
    public Boolean changeParkStatusWithTimer(String firstDate,String secondDate, String currentPark){

        if(firstDate==null || secondDate==null || currentPark==null){
            return false;
        }
        parkingSpacesImpl.updateParkStatusWithTimer(firstDate,secondDate,currentPark);
        System.out.println(firstDate+secondDate+currentPark);
        return true;
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value ="id",required = true) Long id ){
        if(id==null){
            return null;
        }
        Boolean isSuccesful =  parkingSpacesImpl.delete(id);
        return ResponseEntity.ok(isSuccesful);
    }


}