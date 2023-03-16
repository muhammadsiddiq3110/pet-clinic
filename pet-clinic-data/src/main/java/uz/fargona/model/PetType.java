package uz.fargona.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity

@Data
public class PetType extends BaseEntity {

    @Column(name = "name")
    private String name;

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
}
