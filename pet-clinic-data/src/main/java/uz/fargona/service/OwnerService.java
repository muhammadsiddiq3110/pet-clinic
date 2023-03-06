package uz.fargona.service;

import uz.fargona.model.Owner;

public interface OwnerService extends CrudService<Owner,Long> {
    Owner findByLastName(String lastName);
}
