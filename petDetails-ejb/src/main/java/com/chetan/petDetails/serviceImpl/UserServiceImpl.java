package com.chetan.petDetails.serviceImpl;

import com.chetan.petDetails.ejb.User;
import com.chetan.petDetails.service.UserService;
import org.springframework.stereotype.Service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
@Stateless
public class UserServiceImpl implements UserService {

    @EJB
    @PersistenceContext(unitName = "petDetailsPU")
    private EntityManager entityManager;

    @Override
    public User login(String userName, String password) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root).where(criteriaBuilder.and(
                criteriaBuilder.equal(root.get("username"), userName),
                criteriaBuilder.equal(root.get("password"), password)));

        List<User> results = entityManager.createQuery(criteriaQuery).getResultList();
        if (results.isEmpty()) {
            return null;
        } else {
            return results.get(0);
        }
    }
}
