package uz.fargona.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.fargona.model.Pet;
import uz.fargona.service.CrudService;

@Repository
public interface PetRepository extends CrudRepository<Pet,Long> {

}
