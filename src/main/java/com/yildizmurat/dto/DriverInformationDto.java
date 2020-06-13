package com.yildizmurat.dto;


import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DriverInformationDto {

    private Long id;
    private String name;
    private String surname;
    private String idName;
    private String e_mail;
    private String phoneNumber;
    private String carPlate;
}
