package uz.fargona.repository;

import org.springframework.data.repository.CrudRepository;
import uz.fargona.model.Speciality;
import uz.fargona.service.CrudService;

public interface SpecialityRepository extends CrudRepository<Speciality,Long> {
}
