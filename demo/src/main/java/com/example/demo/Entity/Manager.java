package com.example.demo.Entity;

import javax.persistence.*;
import lombok.*;


@Entity
@Setter @Getter
@ToString

@EqualsAndHashCode
@Table (name="Manager")

public class Manager {
    @Id // Annotations @Id บอกว่าเป็น Primary key
    @SequenceGenerator(name = "Manager_seq", sequenceName = "Manager_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Manager_seq")
    @Column(name = "Manager_ID")

    private @NonNull Long id;
    private @NonNull String name;
    private @NonNull String username;


    public Manager() {
    }

    public Manager(Long ManagerID,String name,String username) { //constructor

        this.id = ManagerID;
        this.name = name;
        this.username = username;
    }
}