package fr.aelion.gfi.spring.demo.sample.models.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Log
public class User {
    // @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // @Column(name="name")
    @NotNull
    @Size(min=3, max=250)
    @JsonProperty("username")
    private String name;

    @PostConstruct
    private void log() {
        log.info("User entity initialized");
    }
}
