package com.chetan.petDetails.serviceImpl;

import com.chetan.petDetails.ejb.Vaccine;
import com.chetan.petDetails.service.VaccineService;
import org.springframework.stereotype.Service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
@Stateless
public class VaccineServiceImpl implements VaccineService {

    @EJB
    @PersistenceContext(unitName = "petDetailsPU")
    private EntityManager entityManager;

    @Override
    public List<Vaccine> getAllVaccine() {
        TypedQuery<Vaccine> query = entityManager.createQuery("SELECT v FROM Vaccine v", Vaccine.class);
        return query.getResultList();
    }

}
