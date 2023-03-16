package uz.fargona.repository;

import org.springframework.data.repository.CrudRepository;
import uz.fargona.model.Vet;

public interface VetRepository extends CrudRepository<Vet,Long> {
}
