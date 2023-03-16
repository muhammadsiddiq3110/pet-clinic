package uz.fargona.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.fargona.model.Visit;
@Repository
public interface VisitRepository extends CrudRepository<Visit,Long> {
}
