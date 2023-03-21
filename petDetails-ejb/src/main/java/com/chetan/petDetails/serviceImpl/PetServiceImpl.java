package com.chetan.petDetails.serviceImpl;

import com.chetan.petDetails.ejb.Pet;
import com.chetan.petDetails.ejb.Vaccine;
import com.chetan.petDetails.service.PetService;
import org.springframework.stereotype.Service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import com.chetan.petDetails.ejb.Owner;
import java.util.Date;
import java.util.List;

@Service
@Stateless
public class PetServiceImpl implements PetService {

    @EJB
    @PersistenceContext(unitName = "petDetailsPU")
    private EntityManager entityManager;

    @Override
    public List<Pet> getAllPets() {
        String queryString = "SELECT p FROM Pet p LEFT JOIN FETCH p.owner LEFT JOIN FETCH p.vaccines";
        TypedQuery<Pet> query = entityManager.createQuery(queryString, Pet.class);
        return query.getResultList();
    }

    @Override
    public Pet editPetDetails(int petId, String petName, int petAge, Date lastVaccineDate,
                              Owner owner, List<Vaccine> vaccines) {
        Pet pet = entityManager.find(Pet.class, petId);
        pet.setPetName(petName);
        pet.setPetAge(petAge);
        pet.setLastVaccineDate(lastVaccineDate);
        pet.setOwner(owner);
        pet.setVaccines(vaccines);
        entityManager.merge(pet);
        entityManager.flush();
        return entityManager.find(Pet.class, petId);
    }

}
