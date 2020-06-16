package com.yildizmurat.api;


import com.yildizmurat.dto.DriverInformationDto;
import com.yildizmurat.service.implementation.DriverInformationImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    @PostMapping
    public ResponseEntity<DriverInformationDto> createDriverInformation(@Valid @RequestBody DriverInformationDto driverInformationDto){

        return ResponseEntity.ok(driverInformationImpl.save(driverInformationDto));
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


}
