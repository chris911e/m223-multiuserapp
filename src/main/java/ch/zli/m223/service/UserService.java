package ch.zli.m223.service;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.Booking;
import ch.zli.m223.model.User;

@ApplicationScoped
public class UserService {
    @Inject
    EntityManager entityManager;

    @Transactional
    public User createUser(User user) {
        return entityManager.merge(user);
    }

    @Transactional
    public void deleteUser(Long id) {
        var entity = entityManager.find(User.class, id);
        var constraints = entityManager.createNamedQuery("Booking.findById", Booking.class).setParameter("user", id).getResultStream().findFirst();
        entityManager.remove(entity);
        entityManager.remove(constraints);
    }

    @Transactional
    public User updateUser(Long id, User user) {
        user.setId(id);
        return entityManager.merge(user);
    }

    public List<User> findAll() {
        var query = entityManager.createQuery("FROM User", User.class);
        return query.getResultList();
    }

    public User getUser(Long id) {
        String statement = String.format("FROM User WHERE id = %s", id);
        var query = entityManager.createQuery(statement, User.class);
        return query.getSingleResult();
    }

    public Optional<User> findByEmail(String email) {
        return entityManager
                .createNamedQuery("User.findByEmail", User.class)
                .setParameter("e_mail", email)
                .getResultStream()
                .findFirst();
    }
}
