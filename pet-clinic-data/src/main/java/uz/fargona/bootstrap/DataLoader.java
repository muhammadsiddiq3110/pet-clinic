package uz.fargona.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import uz.fargona.model.*;
import uz.fargona.service.*;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final PetService petService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, PetService petService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.petService = petService;
        this.specialityService = specialityService;
    }


    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType dogSaved = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType catSaved = petTypeService.save(cat);

        Owner owner = new Owner();
        owner.setId(1L);
        owner.setFirstName("Yuriy");
        owner.setLastName("Gagarin");
        owner.setAddress("Leningrad");
        owner.setCity("Moskva");
        owner.setTelephone("987654321");
        ownerService.save(owner);

        Pet mikesPet=new Pet();
        mikesPet.setPetType(dogSaved);
        mikesPet.setOwner(owner);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");

        owner.getPets().add(mikesPet);
        ownerService.save(owner);
        petService.save(mikesPet);

        Owner owner1 = new Owner();
        owner1.setId(2L);
        owner1.setFirstName("Aleksandr");
        owner1.setLastName("Pushkin");
        owner1.setAddress("Sentralniy Barnaul");
        owner1.setCity("Barnaul");
        owner1.setTelephone("45698745690");
        ownerService.save(owner1);

        Pet felixPet=new Pet();
        mikesPet.setPetType(dogSaved);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Oscar");

        owner.getPets().add(felixPet);
        ownerService.save(owner1);
        petService.save(felixPet);

        System.out.println("Loaded Owners .....");


        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        Vet vet = new Vet();
        vet.setId(1L);
        vet.setFirstName("Sasha");
        vet.setLastName("Pasha");
        vet.getSpecialities().add(savedSurgery);
        vetService.save(vet);

        Vet vet1 = new Vet();
        vet1.setId(2L);
        vet1.setFirstName("Ivan");
        vet1.setLastName("Grozniy");
        vet1.getSpecialities().add(savedRadiology);
        vetService.save(vet1);
        System.out.println("Loaded Vets ..... ");

}}
