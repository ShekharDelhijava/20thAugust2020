package com.iiht.ecoronakit.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;


@Embeddable
@Getter
@Setter
public class Address {

    private String postboxNo;

    private String landmark;

    private String zipcode;

    private String phoneNumber;

    private String city;
}
