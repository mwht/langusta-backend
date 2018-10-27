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
import javax.servlet.http.HttpServletResponse;
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

    @Value("${langusta.hmac-secret}")
    private String langustaHmacSecret;

    @GetMapping("/user/me")
    public GenericStatus getLoggedInUser(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String authToken = httpServletRequest.getHeader("X-Auth-Token");
        if(authToken != null) {
            try {
                Session session = SessionBuilder.buildFromJWT(authToken, langustaHmacSecret, userRepository);
                return GenericStatus.createSuccessfulStatus(BasicUserDataView.getDataViewFor(session.getUser()));
            } catch (NoSuchElementException nsee) {
                httpServletResponse.setStatus(401);
                return new GenericStatus(GenericStatus.GenericState.STATUS_ERROR, "Not logged in.", nsee);
            } catch (Exception e) {
                httpServletResponse.setStatus(500);
                return new GenericStatus(GenericStatus.GenericState.STATUS_ERROR, "Unknown error occured.", e);
            }
        } else {
            httpServletResponse.setStatus(401);
            return new GenericStatus(GenericStatus.GenericState.STATUS_ERROR, "Not logged in.", null);
        }
    }

    @PostMapping("/user")
    public GenericStatus addUser(@RequestParam String email, @RequestParam String pass, @RequestParam String firstName, @RequestParam String lastName, HttpServletResponse httpServletResponse) {
        userRepository.save(new User(null, firstName, lastName, email, pass));
        httpServletResponse.setStatus(201);
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
    public GenericStatus deleteUser(@PathVariable("id") Integer id, HttpServletResponse httpServletResponse) {
        if(userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return GenericStatus.createSuccessfulStatus(null);
        } else {
            httpServletResponse.setStatus(404);
            return new GenericStatus(GenericStatus.GenericState.STATUS_ERROR, "User doesn't exist.", null);
        }
    }

    @GetMapping("/user/{id}")
    public GenericStatus getUserById(@PathVariable("id") Integer id, HttpServletResponse httpServletResponse) {
        Optional<User> requestedUser = userRepository.findById(id);
        try {
            return GenericStatus.createSuccessfulStatus(BasicUserDataView.getDataViewFor(requestedUser.get()));
        } catch (NoSuchElementException nsee){
            httpServletResponse.setStatus(404);
            return new GenericStatus(GenericStatus.GenericState.STATUS_ERROR, "User not found.", nsee);
        }
    }
}
