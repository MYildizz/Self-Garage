package com.yildizmurat.api;


import com.yildizmurat.dto.DriverInformationDto;
import com.yildizmurat.dto.ParkingOwnerInformationDto;
import com.yildizmurat.dto.ParkingOwnerInformationDto;
import com.yildizmurat.service.implementation.ParkingOwnerInformationImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
        if(id==null ){
            return null;
        }
        ParkingOwnerInformationDto parkingOwnerInformationDto = parkingOwnerInformationImpl.getById(1L);
        return ResponseEntity.ok(parkingOwnerInformationDto);
    }
    // POST
    @PostMapping
    public ResponseEntity<ParkingOwnerInformationDto> createParkingOwnerInformation(@Valid @RequestBody ParkingOwnerInformationDto parkingOwnerInformationDto){
        if(parkingOwnerInformationDto==null ){
            return null;
        }
        return ResponseEntity.ok(parkingOwnerInformationImpl.save(parkingOwnerInformationDto));
    }

    @RequestMapping(value="/checkParkingOwner",method = RequestMethod.POST)
    public Boolean checkParkingOwnerInformation(@Valid @RequestBody ParkingOwnerInformationDto parkingOwnerInformationDto, HttpServletRequest request){
        if(parkingOwnerInformationDto==null ){
            return null;
        }
        String name= parkingOwnerInformationDto.getIdName();
        String password=parkingOwnerInformationDto.getPassword();

        if(( parkingOwnerInformationImpl.userExist(name)|| parkingOwnerInformationImpl.mailExist(name)) && parkingOwnerInformationImpl.checkPassword(password) )
        {
            request.getSession().setAttribute("ownerId",name);
            return true;

        }
        return false;
    }

    // GET
    @PutMapping("/{id}")
    public ResponseEntity<ParkingOwnerInformationDto> updateParkingOwnerInformation(@PathVariable("id") Long id, @Valid @RequestBody ParkingOwnerInformationDto parkingOwnerInformationDto){
        if(id==null ){
            return null;
        }
        return ResponseEntity.ok(parkingOwnerInformationImpl.update(id,parkingOwnerInformationDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value ="id",required = true) Long id ){
        if(id==null ){
            return null;
        }
        Boolean isSuccesful =  parkingOwnerInformationImpl.delete(id);
        return ResponseEntity.ok(isSuccesful);
    }

    @GetMapping("/getOwnerInfo/{id}")
    public ParkingOwnerInformationDto getOwnerInfo(@PathVariable("id") String id){
        if(id==null ){
            return null;
        }
        ParkingOwnerInformationDto info =parkingOwnerInformationImpl.getByIdName(id);
        System.out.println("api katmanı :" +info.getIdName());
        return info;
    }


}
