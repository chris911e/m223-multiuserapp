package ch.zli.m223.model;

import javax.persistence.*;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.aayushatharva.brotli4j.common.annotations.Local;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;
import java.util.Set;


@Entity
public class Desk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema (readOnly = true)
    private Long id;

    @Column(nullable = false)
    private boolean booked;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean getBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

}