package uz.fargona.service.map;

import org.springframework.stereotype.Service;
import uz.fargona.model.Speciality;
import uz.fargona.service.SpecialityService;

import java.util.Set;

    @Service
public class SpeacialityServiceMap extends AbstractMapService<Speciality, Long> implements SpecialityService {
    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
    super.deleteById(id);
    }

    @Override
    public void delete(Speciality object) {
    super.delete(object);
    }

    @Override
    public Speciality save(Speciality object) {
        return super.save(object);
    }

    @Override
    public Speciality findById(Long id) {
        return super.findById(id);
    }
}
