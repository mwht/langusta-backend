package ovh.spajste.langusta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import ovh.spajste.langusta.GenericStatus;
import ovh.spajste.langusta.SessionBuilder;
import ovh.spajste.langusta.dataview.BasicUserDataView;
import ovh.spajste.langusta.entity.Session;
import ovh.spajste.langusta.entity.User;
import ovh.spajste.langusta.repository.SessionRepository;
import ovh.spajste.langusta.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SessionRepository sessionRepository;

    @Value("${langusta.hmac-secret")
    private String langustaHmacSecret;

    @GetMapping("/user/me")
    public GenericStatus getLoggedInUser(HttpServletRequest httpServletRequest) {
        String authToken = httpServletRequest.getHeader("X-Auth-Token");
        //Optional<Session> sessionHandle;
        if(authToken != null) {
            //sessionHandle = sessionRepository.findByTrackingId(authToken);
            try {
                //Session session = sessionHandle.get();
                Session session = SessionBuilder.buildFromJWT(authToken, langustaHmacSecret);
                return GenericStatus.createSuccessfulStatus(BasicUserDataView.getDataViewFor(session.getUser()));
            } catch (NoSuchElementException nsee) {
                return new GenericStatus(GenericStatus.GenericState.STATUS_ERROR, "Not logged in.", nsee);
            }
        } else {
            return new GenericStatus(GenericStatus.GenericState.STATUS_ERROR, "Not logged in.", null);
        }
    }

    @PostMapping("/user")
    public GenericStatus addUser(@RequestParam String email, @RequestParam String pass, @RequestParam String firstName, @RequestParam String lastName) {
        userRepository.save(new User(null, firstName, lastName, email, pass));
        return GenericStatus.createSuccessfulStatus(null);
    }

    @GetMapping("/user/all")
    public GenericStatus getAllUsers() {
        List<BasicUserDataView> userDataViewList = new ArrayList<BasicUserDataView>();
        Iterable<User> users = userRepository.findAll();
        for(User user: users) {
            userDataViewList.add(BasicUserDataView.getDataViewFor(user));
        }
        return GenericStatus.createSuccessfulStatus(userDataViewList);
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
            return GenericStatus.createSuccessfulStatus(BasicUserDataView.getDataViewFor(requestedUser.get()));
        } catch (NoSuchElementException nsee){
            return new GenericStatus(GenericStatus.GenericState.STATUS_ERROR, "User not found.", nsee);
        }
    }
}
