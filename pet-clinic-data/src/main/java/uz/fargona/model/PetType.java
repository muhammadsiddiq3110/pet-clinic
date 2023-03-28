package uz.fargona.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class PetType extends BaseEntity {

    @Column(name = "name")
    private String name;
    @Override
    public String toString() {
        return name;
    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
}
