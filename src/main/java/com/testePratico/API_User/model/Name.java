package com.testePratico.API_User.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@EqualsAndHashCode
@Table(name = "namesUsers")
public class Name implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idName;
    private String title;
    private String first;
    private String last;
}
