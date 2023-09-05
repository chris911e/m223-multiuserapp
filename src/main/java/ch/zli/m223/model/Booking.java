package ch.zli.m223.model;

import javax.persistence.*;
import org.eclipse.microprofile.openapi.annotations.media.Schema;


import java.time.LocalDateTime;

@Entity
@NamedQueries({
        @NamedQuery(name = "Booking.findById", query = "SELECT u FROM Booking u WHERE u.user = :id")
})
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema (readOnly = true)
    private Long id;

    @ManyToOne
    private Desk desk;

    @Column(nullable = false)
    private LocalDateTime startedAt;

    @Column(nullable = false)
    private LocalDateTime endedAt;

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(LocalDateTime startedAt) {
        this.startedAt = startedAt;
    }

    public LocalDateTime getEndedAt() {
        return endedAt;
    }

    public void setEndedAt(LocalDateTime endedAt) {
        this.endedAt = endedAt;
    }

    public Desk getDesk() {
        return desk;
    }

    public void setDesk(Desk desk) {
        this.desk = desk;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
