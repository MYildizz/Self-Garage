package com.yildizmurat.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseUserInformation implements Serializable {

    @Column(name="name",length =30)
    private String name;
    @Column(name="surname",length =20)
    private String surname;
    @Column(name="idName",length = 10,unique = true)
    private String idName;
    @Column(name="password",length = 20)
    private String password;
    @Column(name="e_mail",length = 20)
    private String e_mail;
    @Column(name="phoneNumber",length = 15)
    private String phoneNumber;

}
