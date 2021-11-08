package com.testePratico.API_User.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

import java.io.Serializable;

@Entity
@Data
@EqualsAndHashCode
public class Location implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLocation;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Street street;
    private String city;
    private String state;
    private String country;
    private String postcode;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Coordinates coordinates;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Timezone timezone;
}
