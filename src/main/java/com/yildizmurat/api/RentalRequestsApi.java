package com.yildizmurat.api;


import com.yildizmurat.dto.RentalRequestsDto;
import com.yildizmurat.service.email.EmailService;
import com.yildizmurat.service.implementation.RentalRequestsImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping("/information/rentalRequestsApi")
public class RentalRequestsApi {

    private final RentalRequestsImpl rentalRequestsImpl;
    EmailService emailService=new EmailService();
    public RentalRequestsApi(RentalRequestsImpl rentalRequestsImpl) {
        this.rentalRequestsImpl = rentalRequestsImpl;
    }
    // GET
    @GetMapping("/{id}")
    public ResponseEntity<RentalRequestsDto> getById(@PathVariable("id") Long id){
        if(id==null){
            return null;
        }
        RentalRequestsDto rentalRequestsDto = rentalRequestsImpl.getById(1L);
        return ResponseEntity.ok(rentalRequestsDto);
    }

    // POST
    @RequestMapping(value="/saveRegister",method = RequestMethod.POST)
    public ResponseEntity<String> createRentalRequests(@Valid @RequestBody RentalRequestsDto rentalRequestsDto){
        if(rentalRequestsDto==null){
            return null;
        }
        if(rentalRequestsImpl.userExist(rentalRequestsDto.getIdName()))
            return ResponseEntity.ok("Bu adiName kullanımdadır");
        if(rentalRequestsImpl.mailExist(rentalRequestsDto.getMail()))
            return ResponseEntity.ok("Bu Mail adresi kullanımdadır");
        rentalRequestsImpl.save(rentalRequestsDto);


        try {
            String content=rentalRequestsDto.getIdName()+
                    rentalRequestsDto.getId()+" - "+
                    rentalRequestsDto.getMail()+" - "+
                    rentalRequestsDto.getAddress()+" - "+
                    rentalRequestsDto.getDistrict()+" - "+
                    rentalRequestsDto.getPassword()+" - "+
                    rentalRequestsDto.getSurname()+" - "+
                    rentalRequestsDto.getName()+" - "+
                    rentalRequestsDto.getProvince();


            emailService.parkRequests(content);
        } catch (MessagingException e) {
            System.out.println("hata 1"+e);
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("hata 2"+e);
        }


        return ResponseEntity.ok("Kaydınız Alınmıştır");
    }

    // GET
    @PutMapping("/{id}")
    public ResponseEntity<RentalRequestsDto> updateRentalRequests(@PathVariable("id") Long id, @Valid @RequestBody RentalRequestsDto rentalRequestsDto){
        if(rentalRequestsDto==null || id==null){
            return null;
        }
        return ResponseEntity.ok(rentalRequestsImpl.update(id,rentalRequestsDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value ="id",required = true) Long id ){
        if(id==null){
            return null;
        }
        Boolean isSuccesful =  rentalRequestsImpl.delete(id);
        return ResponseEntity.ok(isSuccesful);
    }


}
