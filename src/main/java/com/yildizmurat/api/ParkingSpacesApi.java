package com.yildizmurat.api;


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
        ParkingSpacesDto parkingSpacesDto = parkingSpacesImpl.getById(1L);
        return ResponseEntity.ok(parkingSpacesDto);
    }
    // POST
    @PostMapping
    public ResponseEntity<ParkingSpacesDto> createParkingSpaces(@Valid @RequestBody ParkingSpacesDto parkingSpacesDto){

        return ResponseEntity.ok(parkingSpacesImpl.save(parkingSpacesDto));
    }

    // GET
    @PutMapping("/{id}")
    public ResponseEntity<ParkingSpacesDto> updateParkingSpaces(@PathVariable("id") Long id, @Valid @RequestBody ParkingSpacesDto parkingSpacesDto){
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



    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value ="id",required = true) Long id ){
        Boolean isSuccesful =  parkingSpacesImpl.delete(id);
        return ResponseEntity.ok(isSuccesful);
    }


}