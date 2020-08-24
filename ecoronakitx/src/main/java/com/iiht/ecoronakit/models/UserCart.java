package com.iiht.ecoronakit.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@Entity
public class UserCart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long cartId;

    @ElementCollection
    private List<String> productId;

    private String userId;


}
