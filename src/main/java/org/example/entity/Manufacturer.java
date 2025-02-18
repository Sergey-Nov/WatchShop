package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Manufacturer {
    @OneToMany(mappedBy = "manufacturer")
    private List<Watches> watches;
    @Id
    private int manufacturerId;
    private String name;
    private String country;
}
