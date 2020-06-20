package com.yildizmurat.api;


import com.yildizmurat.dto.ManagerInformationDto;
import com.yildizmurat.service.implementation.ManagerInformationImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/information/managerInformationApi")
public class ManagerInformationApi {

    private final ManagerInformationImpl managerInformationImpl;

    public ManagerInformationApi(ManagerInformationImpl managerInformationImpl) {
        this.managerInformationImpl = managerInformationImpl;
    }
    // GET
    @GetMapping("/{id}")
    public ResponseEntity<ManagerInformationDto> getById(@PathVariable("id") Long id){
        ManagerInformationDto managerInformationDto = managerInformationImpl.getById(1L);
        return ResponseEntity.ok(managerInformationDto);
    }
    // POST
    @PostMapping
    public ResponseEntity<ManagerInformationDto> createManagerInformation(@Valid @RequestBody ManagerInformationDto managerInformationDto){

        return ResponseEntity.ok(managerInformationImpl.save(managerInformationDto));
    }

    @RequestMapping(value="/checkManager",method = RequestMethod.POST)
    public Boolean checkManagerInformation(@Valid @RequestBody ManagerInformationDto managerInformationDto){
        String name= managerInformationDto.getIdName();
        String password=managerInformationDto.getPassword();

        if(( managerInformationImpl.userExist(name)|| managerInformationImpl.mailExist(name)) && managerInformationImpl.checkPassword(password) )
            return true;
        return false;
    }

    // GET
    @PutMapping("/{id}")
    public ResponseEntity<ManagerInformationDto> updateManagerInformation(@PathVariable("id") Long id, @Valid @RequestBody ManagerInformationDto managerInformationDto){
        return ResponseEntity.ok(managerInformationImpl.update(id,managerInformationDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value ="id",required = true) Long id ){
        Boolean isSuccesful =  managerInformationImpl.delete(id);
        return ResponseEntity.ok(isSuccesful);
    }


}