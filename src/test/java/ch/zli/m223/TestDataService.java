package ch.zli.m223;

import java.time.LocalDateTime;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.Booking;
import ch.zli.m223.model.Desk;
import ch.zli.m223.model.Role;
import ch.zli.m223.model.Punished;
import ch.zli.m223.model.User;
import io.quarkus.arc.profile.IfBuildProfile;
// import io.quarkus.runtime.Startup;
import io.quarkus.runtime.StartupEvent;

@IfBuildProfile("test")
@ApplicationScoped
public class TestDataService {

    @Inject
    EntityManager entityManager;

    @Transactional
    void generateTestData(@Observes StartupEvent event) {

        // Desk 1
        var desk1 = new Desk();
        desk1.setBooked(true);
        entityManager.persist(desk1);

        // Desk 2
        var desk2 = new Desk();
        desk1.setBooked(false);
        entityManager.persist(desk2);

        // Desk 3
        var desk3 = new Desk();
        desk1.setBooked(true);
        entityManager.persist(desk3);

        // Role 1
        var role1 = new Role();
        role1.setRole("User");
        entityManager.persist(role1);

        // Role 2
        var role2 = new Role();
        role2.setRole("Admin");
        entityManager.persist(role2);

        // Role 3
        var role3 = new Role();
        role3.setRole("Banned");
        entityManager.persist(role3);

        // User 1
        var user1 = new User();
        user1.setF_name("Markus");
        user1.setL_name("Miller");
        user1.setE_Mail("markus_miller@exmaple.ch");
        user1.setPassword("password");
        user1.setRole(role1);
        user1.setCreatedAt(LocalDateTime.now().minusHours(1));
        entityManager.persist(user1);

        // User 2
        var user2 = new User();
        user2.setF_name("Emily");
        user2.setL_name("Kol");
        user2.setE_Mail("emily9898@exmaple.ch");
        user2.setPassword("password");
        user2.setRole(role2);
        user2.setCreatedAt(LocalDateTime.now().minusHours(2));
        entityManager.persist(user2);

        // User 3
        var user3 = new User();
        user3.setF_name("Bishu");
        user3.setL_name("Bala");
        user3.setE_Mail("what@what.what");
        user3.setPassword("what");
        user3.setRole(role3);
        user3.setCreatedAt(LocalDateTime.now().minusHours(3));
        entityManager.persist(user3);

        // Punished 1
        var punished1 = new Punished();
        punished1.setUser(user1);
        punished1.setStartedAt(LocalDateTime.now().minusDays(20));
        punished1.setEndedAt(LocalDateTime.now().minusHours(1));
        entityManager.persist(punished1);

        // Punished 2
        var punished2 = new Punished();
        punished2.setUser(user2);
        punished2.setStartedAt(LocalDateTime.now().minusDays(21));
        punished2.setEndedAt(LocalDateTime.now().minusHours(2));
        entityManager.persist(punished2);

        // Punished 3
        var punished3 = new Punished();
        punished3.setUser(user3);
        punished3.setStartedAt(LocalDateTime.now().minusDays(22));
        punished3.setEndedAt(LocalDateTime.now().minusHours(3));
        entityManager.persist(punished3);

        // Booking 1
        var booking1 = new Booking();
        booking1.setDesk(desk1);
        booking1.setStartedAt(LocalDateTime.now().minusHours(6));
        booking1.setEndedAt(LocalDateTime.now());
        booking1.setUser(user1);
        entityManager.persist(booking1);

        // Booking 2
        var booking2 = new Booking();
        booking2.setDesk(desk2);
        booking2.setStartedAt(LocalDateTime.now().minusHours(12));
        booking2.setEndedAt(LocalDateTime.now().minusHours(6));
        booking2.setUser(user2);
        entityManager.persist(booking2);

        // Booking 3
        var booking3 = new Booking();
        booking3.setDesk(desk3);
        booking3.setStartedAt(LocalDateTime.now().minusHours(18));
        booking3.setEndedAt(LocalDateTime.now().minusHours(12));
        booking3.setUser(user3);
        entityManager.persist(booking3);
    }
}
