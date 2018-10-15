package ovh.spajste.langusta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ovh.spajste.langusta.GenericStatus;
import ovh.spajste.langusta.entity.User;
import ovh.spajste.langusta.repository.UserRepository;

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

    @GetMapping("/user/{id}")
    public GenericStatus getUserById(@PathVariable("id") long id) {
        if(id == 1) {
            return GenericStatus.createSuccessfulStatus(new User(1,"Tom", "Terca", "falcon1986@o2.pl", "some_sha512_or_bcrypt_hash"));
        } else {
            return GenericStatus.createSuccessfulStatus(User.getNullUser());
        }
    }
}
