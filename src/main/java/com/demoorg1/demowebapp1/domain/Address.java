package com.demoorg1.demowebapp1.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="Address")
@Getter
@Setter

public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="add_id")
    private Long addressId;
    private String city;
    private String addressType;
}
