package uz.fargona.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.fargona.model.PetType;
import uz.fargona.service.CrudService;

@Repository
public interface PetTypeRepository extends CrudRepository<PetType,Long>
{
}
