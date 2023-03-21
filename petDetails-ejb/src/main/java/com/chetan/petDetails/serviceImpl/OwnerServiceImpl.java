package com.chetan.petDetails.serviceImpl;

import com.chetan.petDetails.ejb.Owner;
import com.chetan.petDetails.service.OwnerService;
import org.springframework.stereotype.Service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
@Stateless
public class OwnerServiceImpl implements OwnerService {

    @EJB
    @PersistenceContext(unitName = "petDetailsPU")
    private EntityManager entityManager;

    @Override
    public List<Owner> getAllOwners() {
        TypedQuery<Owner> query = entityManager.createQuery("SELECT o FROM Owner o", Owner.class);
        return query.getResultList();
    }

}
