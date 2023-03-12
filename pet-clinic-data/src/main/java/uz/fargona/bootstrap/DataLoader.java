package uz.fargona.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import uz.fargona.model.Owner;
import uz.fargona.model.PetType;
import uz.fargona.model.Vet;
import uz.fargona.service.OwnerService;
import uz.fargona.service.PetTypeService;
import uz.fargona.service.VetService;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }


    @Override
    public void run(String... args) throws Exception {

        PetType dog=new PetType();
        dog.setName("Dog");
        PetType dogSaved=petTypeService.save(dog);

        PetType cat=new PetType();
        cat.setName("Cat");
        PetType catSaved=petTypeService.save(cat);

        Owner owner =new Owner();
        owner.setId(1L);
        owner.setFirstName("Yuriy");
        owner.setLastName("Gagarin");
        ownerService.save(owner);
        Owner owner1=new Owner();
        owner1.setId(2L);
        owner1.setFirstName("Aleksandr");
        owner1.setLastName("Pushkin");

        ownerService.save(owner1);
        System.out.println("Loaded Owners .....");

        Vet vet=new Vet();
        vet.setId(1L);
        vet.setFirstName("Sasha");
        vet.setLastName("Pasha");
        vetService.save(vet);

        Vet vet1=new Vet();
        vet1.setId(2L);
        vet1.setFirstName("Ivan");
        vet1.setLastName("Grozniy");
        vetService.save(vet1);
        System.out.println("Loaded Vets ..... ");
    }
}
