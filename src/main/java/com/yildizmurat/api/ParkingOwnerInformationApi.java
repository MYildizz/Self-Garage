package com.yildizmurat.api;


import com.yildizmurat.dto.DriverInformationDto;
import com.yildizmurat.dto.ParkingOwnerInformationDto;
import com.yildizmurat.dto.ParkingOwnerInformationDto;
import com.yildizmurat.service.implementation.ParkingOwnerInformationImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/information/parkingOwnerInformationApi")
public class ParkingOwnerInformationApi {

    private final ParkingOwnerInformationImpl parkingOwnerInformationImpl;

    public ParkingOwnerInformationApi(ParkingOwnerInformationImpl parkingOwnerInformationImpl) {
        this.parkingOwnerInformationImpl = parkingOwnerInformationImpl;
    }
    // GET
    @GetMapping("/{id}")
    public ResponseEntity<ParkingOwnerInformationDto> getById(@PathVariable("id") Long id){
        ParkingOwnerInformationDto parkingOwnerInformationDto = parkingOwnerInformationImpl.getById(1L);
        return ResponseEntity.ok(parkingOwnerInformationDto);
    }
    // POST
    @PostMapping
    public ResponseEntity<ParkingOwnerInformationDto> createParkingOwnerInformation(@Valid @RequestBody ParkingOwnerInformationDto parkingOwnerInformationDto){

        return ResponseEntity.ok(parkingOwnerInformationImpl.save(parkingOwnerInformationDto));
    }

    @RequestMapping(value="/checkParkingOwner",method = RequestMethod.POST)
    public Boolean checkParkingOwnerInformation(@Valid @RequestBody ParkingOwnerInformationDto parkingOwnerInformationDto){
        String name= parkingOwnerInformationDto.getIdName();
        String password=parkingOwnerInformationDto.getPassword();

        if(( parkingOwnerInformationImpl.userExist(name)|| parkingOwnerInformationImpl.mailExist(name)) && parkingOwnerInformationImpl.checkPassword(password) )
            return true;
        return false;
    }

    // GET
    @PutMapping("/{id}")
    public ResponseEntity<ParkingOwnerInformationDto> updateParkingOwnerInformation(@PathVariable("id") Long id, @Valid @RequestBody ParkingOwnerInformationDto parkingOwnerInformationDto){
        return ResponseEntity.ok(parkingOwnerInformationImpl.update(id,parkingOwnerInformationDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value ="id",required = true) Long id ){
        Boolean isSuccesful =  parkingOwnerInformationImpl.delete(id);
        return ResponseEntity.ok(isSuccesful);
    }

    @GetMapping("/getOwnerInfo/{id}")
    public ParkingOwnerInformationDto getOwnerInfo(@PathVariable("id") String id){
        ParkingOwnerInformationDto info =parkingOwnerInformationImpl.getByIdName(id);
        System.out.println("api katmanı :" +info.getIdName());
        return info;
    }


}
