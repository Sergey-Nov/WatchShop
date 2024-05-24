package org.example.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.entity.enums.Type;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Watches {
    @ManyToOne
    @JoinColumn(name = "manufacturerId")
    private Manufacturer manufacturer;

    private String brand;
    private int price;
    private int amount;
    private String manufacturerProps;
    private Type type;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int watchesId;


}
