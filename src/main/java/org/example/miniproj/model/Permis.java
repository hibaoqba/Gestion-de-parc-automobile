package org.example.miniproj.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table
@Data
public class Permis {
    @Id
    @GeneratedValue
    private  Integer numeroPermis;

    @OneToMany
    private List<PermisType> permisTypes;

    @OneToOne
    private Driver driver;
}
