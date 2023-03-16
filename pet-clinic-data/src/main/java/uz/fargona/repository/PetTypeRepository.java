package uz.fargona.repository;

import org.springframework.data.repository.CrudRepository;
import uz.fargona.model.PetType;
import uz.fargona.service.CrudService;

public interface PetTypeRepository extends CrudRepository<PetType,Long>
{
}
