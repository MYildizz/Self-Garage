package com.yildizmurat.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RentalRequestsDto {

    private Long id;
    private String name;
    private String surname;
    private String idName;
    private String e_mail;
    private String phoneNumber;
    private String district;
    private String province;
    private String address;
}
