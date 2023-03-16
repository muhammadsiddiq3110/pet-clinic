package uz.fargona.repository;

import org.springframework.data.repository.CrudRepository;
import uz.fargona.model.Pet;
import uz.fargona.service.CrudService;

public interface PetRepository extends CrudRepository<Pet,Long> {

}
