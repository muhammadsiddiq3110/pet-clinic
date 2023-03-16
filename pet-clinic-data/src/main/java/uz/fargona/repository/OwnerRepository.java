package uz.fargona.repository;

import org.springframework.data.repository.CrudRepository;
import uz.fargona.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
    Owner findByLastName(String lastName);
}
