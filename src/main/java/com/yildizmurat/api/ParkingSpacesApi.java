package com.yildizmurat.api;


import com.yildizmurat.dto.ParkingSpacesDto;
import com.yildizmurat.service.implementation.ParkingSpacesImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value ="id",required = true) Long id ){
        Boolean isSuccesful =  parkingSpacesImpl.delete(id);
        return ResponseEntity.ok(isSuccesful);
    }


}