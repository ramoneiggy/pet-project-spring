package com.isolaja.petproject.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.isolaja.petproject.model.enums.Animal;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Data
@Entity(name = "pets")
@EqualsAndHashCode(callSuper = true)
public class Pet extends BaseEntity {

    private String name;

    @Enumerated(EnumType.STRING)
    private Animal animal;

    private String breed;

    private String description;

    private int addedByUser;

    // image handling
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id")
    private List<PetImage> petImages = new ArrayList<>();

    // database mapping
    @JsonIgnoreProperties("pets")
    @ManyToMany(mappedBy = "pets")
    private Set<User> owners = new HashSet<>();

}