package uz.fargona.service.map;

import org.springframework.stereotype.Service;

import uz.fargona.model.Owner;
import uz.fargona.model.Pet;
import uz.fargona.service.OwnerService;
import uz.fargona.service.PetService;
import uz.fargona.service.PetTypeService;

import java.util.List;
import java.util.Set;
@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner save(Owner object) {

        if (object!=null){
            if (object.getPets()!=null){
                object.getPets().forEach(pet->{
                    if (pet.getPetType()!=null){
                        if(pet.getPetType().getId()==0){
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    }else {
                        throw new RuntimeException("Pet type is required");
                    } if (pet.getId()==null){
                        Pet savedPet=petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }
        }

        return super.save(object);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return map.entrySet().stream()
                .filter(a -> a.getValue().getLastName().equals(lastName))
                .findFirst()
                .map(a -> a.getValue())
                .orElse(null);
    }

    @Override
    public List<Owner> findAllByLastNameLike(String lastName) {
   return      map.entrySet().stream()
                .filter(a->a.getValue().getLastName().toLowerCase().contains(lastName.replaceAll("%","").toLowerCase()))
                .map(a->a.getValue())
                .toList();
    }
}
