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
public abstract class BaseCreditCardInformation implements Serializable {

    @Column(name="name",length =30)
    private String name;
    @Column(name="surname",length =20)
    private String surname;
    @Column(name="cardNo",length =16)
    private String cardNo;
    @Column(name="aa_yy",length =5)
    private String aa_yy;
    @Column(name="cvc",length =3)
    private String cvc;

}
