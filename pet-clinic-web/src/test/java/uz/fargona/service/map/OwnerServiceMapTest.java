package uz.fargona.service.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uz.fargona.model.Owner;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {

    final String LAST_NAME = "Smith";
    final Long ID = 1L;

    private OwnerServiceMap ownerServiceMap;

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());
        ownerServiceMap.save(Owner.builder().id(1L).lastName(LAST_NAME).build());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerServiceMap.findAll();
        assertEquals(1, ownerSet.size());
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(ID);
        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void delete() {
        var objectToDelete = ownerServiceMap.findById(ID);
        ownerServiceMap.delete(objectToDelete);
        assertNull(ownerServiceMap.findById(ID));
    }

    @Test
    void findByLastNameNotFound() {
        Owner owner = ownerServiceMap.findByLastName("mith");
        assertNull(owner);
    }
    @Test
    void saveExistingId(){
        Long id=2L;
        Owner savedOwner=ownerServiceMap.save(Owner.builder().id(id).build());
        assertEquals(id,savedOwner.getId());
        assertNull(savedOwner.getLastName());
        assertEquals(2,ownerServiceMap.findAll().size());
    }
    @Test
    void saveNoId(){
        Owner owner=ownerServiceMap.save(Owner.builder().build());
        assertNotNull(owner);
        assertNotNull(owner.getId());
    }
    @Test
    void findById(){
        Owner owner=ownerServiceMap.findById(ID);
        assertEquals(ID,owner.getId());
    }
    @Test
    void findByLastName(){
        Owner owner=ownerServiceMap.findByLastName(LAST_NAME);
        assertNotNull(owner);
    }

}