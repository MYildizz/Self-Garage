package com.yildizmurat.api;


import com.yildizmurat.dto.DriverInformationDto;
import com.yildizmurat.dto.ParkingSpacesUsagesDto;
import com.yildizmurat.service.implementation.DriverInformationImpl;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/information/driverInformationApi")
public class DriverInformationApi {

    private final DriverInformationImpl driverInformationImpl;



    public DriverInformationApi(DriverInformationImpl driverInformationImpl) {
        this.driverInformationImpl = driverInformationImpl;
    }
    // GET
    @GetMapping("/{id}")
    public ResponseEntity<DriverInformationDto> getById(@PathVariable("id") Long id){
        DriverInformationDto driverInformationDto = driverInformationImpl.getById(1L);
        return ResponseEntity.ok(driverInformationDto);
    }


    // POST
    @RequestMapping(value="/saveDriver",method = RequestMethod.POST)
    public ResponseEntity<String> createDriverInformation(@Valid @RequestBody DriverInformationDto driverInformationDto){

        if(driverInformationImpl.userExist(driverInformationDto.getIdName()))
            return ResponseEntity.ok("UserId zaten kullanımdadır");
        if(driverInformationImpl.mailExist(driverInformationDto.getE_mail()))
            return ResponseEntity.ok("Mail adresi zaten kullanımdadır");
        driverInformationImpl.save(driverInformationDto);
        return ResponseEntity.ok("Kayıt Başarılı");
    }

    @RequestMapping(value="/checkDriver",method = RequestMethod.POST)
    public Boolean checkDriverInformation(@Valid @RequestBody DriverInformationDto driverInformationDto, HttpServletRequest request){
        String name= driverInformationDto.getIdName();
        String password=driverInformationDto.getPassword();


        if(( driverInformationImpl.userExist(name)|| driverInformationImpl.mailExist(name)) && driverInformationImpl.checkPassword(password) )
        {
            request.getSession().setAttribute("driverId",name);
            return true;
        }
        return false;
    }



    // GET
    @PutMapping("/{id}")
    public ResponseEntity<DriverInformationDto> updateDriverInformation(@PathVariable("id") Long id, @Valid @RequestBody DriverInformationDto driverInformationDto){
        return ResponseEntity.ok(driverInformationImpl.update(id,driverInformationDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value ="id",required = true) Long id ){
        Boolean isSuccesful =  driverInformationImpl.delete(id);
        return ResponseEntity.ok(isSuccesful);
    }

    @GetMapping("/getDriverInfo/{id}")
    public DriverInformationDto getDriverInfo(@PathVariable("id") String id){
        DriverInformationDto info =driverInformationImpl.getByIdName(id);
        return info;
    }



}