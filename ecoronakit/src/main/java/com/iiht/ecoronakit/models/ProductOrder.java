package com.iiht.ecoronakit.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;

import com.iiht.ecoronakit.enums.Status;

import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@Entity
public class ProductOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long orderId;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Product> pproducts;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="userId")
    private User user;

//    private long userId;

    private LocalDate oorderDate;

    @Enumerated(EnumType.STRING)
    private Status sstatus;


}
