package uz.fargona.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.fargona.model.Vet;

@Repository
public interface VetRepository extends CrudRepository<Vet,Long> {
}
