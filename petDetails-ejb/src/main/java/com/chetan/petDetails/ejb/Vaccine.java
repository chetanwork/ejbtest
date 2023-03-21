package com.chetan.petDetails.ejb;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "vaccine")
public class Vaccine implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "vaccineName")
    private String vaccineName;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public Pet getPet() { return pet; }

    public void setPet(Pet pet) { this.pet = pet; }

    @Override
    public String toString() {
        return "Vaccine{" +
                "id=" + id +
                ", vaccineName='" + vaccineName + '\'' +
                ", pet=" + pet +
                '}';
    }

}
