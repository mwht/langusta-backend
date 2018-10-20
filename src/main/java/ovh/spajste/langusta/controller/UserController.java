package ovh.spajste.langusta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ovh.spajste.langusta.GenericStatus;
import ovh.spajste.langusta.entity.User;
import ovh.spajste.langusta.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/me")
    public Optional<User> getLoggedInUser() {
        return userRepository.findById(1);
        //return GenericStatus.createSuccessfulStatus(new User(1,"Tom", "Terca", "falcon1986@o2.pl", "some_sha512_or_bcrypt_hash"));
    }

    @PostMapping("/user/add")
    public GenericStatus addUser(@RequestParam String email, @RequestParam String pass, @RequestParam String firstName, @RequestParam String lastName) {
        userRepository.save(new User(null, firstName, lastName, email, pass));
        return GenericStatus.createSuccessfulStatus(null);
    }

    @GetMapping("/user/all")
    public GenericStatus getAllUsers() {
        return GenericStatus.createSuccessfulStatus(userRepository.findAll());
    }

    @DeleteMapping("/user/{id}")
    public GenericStatus deleteUser(@PathVariable("id") Integer id) {
        if(userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return GenericStatus.createSuccessfulStatus(null);
        } else {
            return new GenericStatus(GenericStatus.GenericState.STATUS_ERROR, "User doesn't exist.", null);
        }
    }

    @GetMapping("/user/{id}")
    public GenericStatus getUserById(@PathVariable("id") Integer id) {
        Optional<User> requestedUser = userRepository.findById(id);
        try {
            return GenericStatus.createSuccessfulStatus(requestedUser.get());
        } catch (NoSuchElementException nsee){
            return new GenericStatus(GenericStatus.GenericState.STATUS_ERROR, "User not found.", nsee);
        }
    }
}
