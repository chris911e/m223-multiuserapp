package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.Booking;

@ApplicationScoped
public class BookingService {
    @Inject
    EntityManager entityManager;

    @Transactional
    public Booking createBooking(Booking entry) {
        return entityManager.merge(entry);
    }

    @Transactional
    public void deleteBooking(Long id) {
        var entity = entityManager.find(Booking.class, id);
        entityManager.remove(entity);
    }

    @Transactional
    public Booking updateBooking(Long id, Booking entry) {
        entry.setId(id);
        return entityManager.merge(entry);
    }

    public List<Booking> findAll() {
        var query = entityManager.createQuery("FROM Booking", Booking.class);
        return query.getResultList();
    }

    public Booking getBooking(Long id) {
        String statement = String.format("FROM Booking WHERE id = %s", id);
        var query = entityManager.createQuery(statement, Booking.class);
        return query.getSingleResult();
    }
}
