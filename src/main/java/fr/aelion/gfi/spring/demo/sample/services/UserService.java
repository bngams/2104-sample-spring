package fr.aelion.gfi.spring.demo.sample.services;

import fr.aelion.gfi.spring.demo.sample.models.entities.User;
import fr.aelion.gfi.spring.demo.sample.repositories.UserRepository;
import lombok.Getter;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Service
@Log
public class UserService {

    private final UserRepository uRepo;

    @Autowired
    public UserService(UserRepository uRepo) {
        this.uRepo = uRepo;
    }

    @PostConstruct
    private void log() {
        log.info("User Service initialized");
    }

    public User createUser(User u) {
        return this.uRepo.save(u);
    }

    public Optional<User> findUserById(Long id) {
        return this.uRepo.findById(id);
    }
}
