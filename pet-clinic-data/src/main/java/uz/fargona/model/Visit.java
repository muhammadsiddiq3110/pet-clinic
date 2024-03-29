package uz.fargona.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "visit")
public class Visit extends BaseEntity {

    @Column(name = "local_date")
    private LocalDate localDate;

    @Column(name = "description")
    private String description;
    @ManyToOne
    @JoinColumn(name ="pet_id")
    private Pet pet;



    public LocalDate getLocalDate() {
        return localDate;
    }

//    public void setLocalDate(LocalDate localDate) {
//        this.localDate = localDate;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public Pet getPet() {
//        return pet;
//    }
//
//    public void setPet(Pet pet) {
//        this.pet = pet;
//    }
}
