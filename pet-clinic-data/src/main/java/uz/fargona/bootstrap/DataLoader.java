package uz.fargona.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import uz.fargona.model.Owner;
import uz.fargona.model.Vet;
import uz.fargona.service.OwnerService;
import uz.fargona.service.VetService;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }


    @Override
    public void run(String... args) throws Exception {
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
