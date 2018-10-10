package ovh.spajste.langusta.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ovh.spajste.langusta.model.User;

@RestController
public class UserController {

    @GetMapping("/user/me")
    public User getLoggedInUser() {
        return new User(1,"Tom", "Terca", "falcon1986@o2.pl", "some_sha512_or_bcrypt_hash");
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") long id) {
        if(id == 1) {
            return new User(1,"Tom", "Terca", "falcon1986@o2.pl", "some_sha512_or_bcrypt_hash");
        } else {
            return User.getNullUser();
        }
    }
}
