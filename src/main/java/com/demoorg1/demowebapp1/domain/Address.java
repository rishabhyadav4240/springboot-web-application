package com.demoorg1.demowebapp1.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="Address")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="add_id")
    private Long addressId;
    private String city;
    private String addressType;


}
