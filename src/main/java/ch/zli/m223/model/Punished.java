package ch.zli.m223.model;

import javax.persistence.*;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import java.time.LocalDateTime;


@Entity
public class Punished {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema (readOnly = true)
    private Long id;

    @ManyToOne
    private User user;

    @Column(nullable = false)
    private LocalDateTime startedAt;

    @Column(nullable = false)
    private LocalDateTime endedAt;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}