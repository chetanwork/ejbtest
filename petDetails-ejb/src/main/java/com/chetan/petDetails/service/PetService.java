package com.chetan.petDetails.service;

import com.chetan.petDetails.ejb.Owner;
import com.chetan.petDetails.ejb.Pet;
import com.chetan.petDetails.ejb.Vaccine;

import java.util.Date;
import java.util.List;

public interface PetService {

    List<Pet> getAllPets();

    Pet editPetDetails(int petId, String petName, int petAge,
                       Date lastVaccineDate, Owner owner, List<Vaccine> vaccines);
}
