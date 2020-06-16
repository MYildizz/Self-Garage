package com.yildizmurat.entity;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getAa_yy() {
        return aa_yy;
    }

    public void setAa_yy(String aa_yy) {
        this.aa_yy = aa_yy;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }
}
