package uz.fargona.service.springdatajpa;

import uz.fargona.model.Vet;
import uz.fargona.repository.VetRepository;
import uz.fargona.service.VetService;

import java.util.HashSet;
import java.util.Set;

public class VetSDJpaService implements VetService {

    private final VetRepository vetRepository;

    public VetSDJpaService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public void delete(Vet object) {
        vetRepository.delete(object);

    }

    @Override
    public void deleteById(Long aLong) {
        vetRepository.deleteById(aLong);

    }

    @Override
    public Vet findById(Long id) {
       return vetRepository.findById(id).orElse(null);

    }

    @Override
    public Vet save(Vet vet) {
        var vet1 =vetRepository.save(vet);

        return vet1;

    }

    @Override
    public Set<Vet> findAll() {
       Set<Vet> vets=new HashSet<>();
       vetRepository.findAll().forEach(vets::add);
       return vets;
    }
}
