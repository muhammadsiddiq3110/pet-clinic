package uz.fargona.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "vets")
public class Vet extends Person{

    @ManyToMany
    @JoinColumn(name = "vet_speciality")


    private Set<Speciality> specialities=new HashSet<>();

//    public Set<Speciality> getSpecialities() {
//        return specialities;
//    }
//
//    public void setSpecialities(Set<Speciality> specialities) {
//        this.specialities = specialities;
//    }
}
