package uz.fargona.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.fargona.model.Speciality;
import uz.fargona.service.CrudService;

@Repository
public interface SpecialityRepository extends CrudRepository<Speciality,Long> {
}
