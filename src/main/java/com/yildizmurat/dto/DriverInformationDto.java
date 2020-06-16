package com.yildizmurat.dto;


import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DriverInformationDto {

    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String surname;
    @NotNull
    private String idName;
    @NotNull
    private String e_mail;
    @NotNull
    private String phoneNumber;
    @NotNull
    private String carPlate;
}
