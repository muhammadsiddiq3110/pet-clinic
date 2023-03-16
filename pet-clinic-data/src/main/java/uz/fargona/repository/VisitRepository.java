package uz.fargona.repository;

import org.springframework.data.repository.CrudRepository;
import uz.fargona.model.Visit;

public interface VisitRepository extends CrudRepository<Visit,Long> {
}
