package com.yildizmurat.api;


import com.yildizmurat.dto.RentalRequestsDto;
import com.yildizmurat.service.implementation.RentalRequestsImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/information/rentalRequestsApi")
public class RentalRequestsApi {

    private final RentalRequestsImpl rentalRequestsImpl;

    public RentalRequestsApi(RentalRequestsImpl rentalRequestsImpl) {
        this.rentalRequestsImpl = rentalRequestsImpl;
    }
    // GET
    @GetMapping("/{id}")
    public ResponseEntity<RentalRequestsDto> getById(@PathVariable("id") Long id){
        RentalRequestsDto rentalRequestsDto = rentalRequestsImpl.getById(1L);
        return ResponseEntity.ok(rentalRequestsDto);
    }
    // POST
    @PostMapping
    public ResponseEntity<RentalRequestsDto> createRentalRequests(@Valid @RequestBody RentalRequestsDto rentalRequestsDto){

        return ResponseEntity.ok(rentalRequestsImpl.save(rentalRequestsDto));
    }

    // GET
    @PutMapping("/{id}")
    public ResponseEntity<RentalRequestsDto> updateRentalRequests(@PathVariable("id") Long id, @Valid @RequestBody RentalRequestsDto rentalRequestsDto){
        return ResponseEntity.ok(rentalRequestsImpl.update(id,rentalRequestsDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value ="id",required = true) Long id ){
        Boolean isSuccesful =  rentalRequestsImpl.delete(id);
        return ResponseEntity.ok(isSuccesful);
    }


}
