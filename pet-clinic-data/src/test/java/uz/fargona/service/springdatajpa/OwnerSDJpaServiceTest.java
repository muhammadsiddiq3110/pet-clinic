package uz.fargona.service.springdatajpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import uz.fargona.model.Owner;
import uz.fargona.repository.OwnerRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    final String LAST_NAME = "Smith";
    private final Long ID=1L;
    private Owner owner;
    @Mock
    private OwnerRepository ownerRepository;

    @InjectMocks
    OwnerSDJpaService ownerSDJpaService;

    @BeforeEach
    void setUp() {

        owner=Owner.builder().id(ID).lastName(LAST_NAME).build();

    }

    @Test
    void findAll() {

        Set<Owner> ownerSet=new HashSet<>();
        ownerSet.add(Owner.builder().id(ID).build());
        ownerSet.add(Owner.builder().id(2L).build());

        when(ownerRepository.findAll()).thenReturn(ownerSet);
        var owners=ownerSDJpaService.findAll();

        assertNotNull(owners);
        assertEquals(2,owners.size());

    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(owner));
        Owner owner1=ownerSDJpaService.findById(1L);
        assertNotNull(owner1);
    }

    @Test
    void save(Owner owner) {
        Owner owner1= Owner.builder().build();
        ownerSDJpaService.save(owner1);
        assertNotNull(owner1);

    }

    @Test
    void delete() {
        Owner owner2=Owner.builder().build();
        save(owner2);
        ownerRepository.delete(owner2);
        assertNull(owner2);
    }

    @Test
    void deleteById() {
    }

    @Test
    void findByLastName() {
    }
}