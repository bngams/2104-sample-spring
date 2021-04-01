package fr.aelion.gfi.spring.demo.sample.controllers.api;

import fr.aelion.gfi.spring.demo.sample.annotations.GlobalAdvice;
import fr.aelion.gfi.spring.demo.sample.exceptions.ApiError;
import fr.aelion.gfi.spring.demo.sample.exceptions.UserNotFoundException;
import fr.aelion.gfi.spring.demo.sample.models.entities.User;
import fr.aelion.gfi.spring.demo.sample.services.UserService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
@RequestMapping("/api/user") // global prefix for all routes
@Log
@GlobalAdvice
public class UserResourceController {

    private final UserService uServ;

    @Autowired
    public UserResourceController(UserService uServ) {
        this.uServ = uServ;
    }

    @GetMapping("/{id}") // /api/user/id
    public ResponseEntity<User> getUserById(@PathVariable(required = true) Long id)
            throws UserNotFoundException {
        log.info("call GET /api/user/"+ id);
        User u = this.uServ.findUserById(id).orElse(null);
        if(u == null) {
            throw new UserNotFoundException();
        };
        return new ResponseEntity<>(u, HttpStatus.OK);
    }

    @GetMapping("") // /api/user/id
    public ResponseEntity<List<User>> getAllUsers() {
        log.info("call GET /api/user");
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "Boris"));
        users.add(new User(2L, "Guillaume"));
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/external") // /api/user/id
    public ResponseEntity<User[]> getAllExternalUsers() {
        log.info("call GET /api/user");
        this.sampleVoidAsyncMethod();
        RestTemplate rest = new RestTemplate();
        return rest.getForEntity("https://jsonplaceholder.typicode.com/users", User[].class);
    }

    @Async()
    private void sampleVoidAsyncMethod() {
        log.info("Execute method asynchronously. "
                + Thread.currentThread().getName());
        try{
            Thread.sleep(5000);
            log.info("running async task done");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Async("threadPoolTaskExecutor")
    private Future<String> sampleFutureAsyncMethod() {
        log.info("Execute method asynchronously. "
                + Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
            log.info("running async task with future done");
            return new AsyncResult<>("Thread done");
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("")
    public ResponseEntity<User> createUser(@RequestBody User u) {
        log.info("call POST /api/user");
        u = this.uServ.createUser(u);
        return new ResponseEntity<>(u, HttpStatus.CREATED);
    }

    // replace the update (not conventional)
    // @PostMapping("/{id}")
    // public ResponseEntity<User> createUser(@PathVariable(required = true) Long id, @RequestBody User u) {
    //     // ...
    // }

    @PutMapping("")
    public User updateUser(@RequestBody User u) {
        // check if user exists with u.id
        log.info("call PUT /api/user");
        return u;
    }

//    @PutMapping("/{id}")
//    public User updateUser(@PathVariable(required = true) Long id, @RequestBody User u) {
//        log.info("call PUT /api/user");
//        return u;
//    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(required = true) Long id) {
        log.info("call DELETE /api/user/"+ id);
    }
}
