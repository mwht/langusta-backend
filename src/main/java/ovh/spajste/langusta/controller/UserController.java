package ovh.spajste.langusta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;
import ovh.spajste.langusta.GenericStatus;
import ovh.spajste.langusta.SessionBuilder;
import ovh.spajste.langusta.UpdateUserParams;
import ovh.spajste.langusta.entity.Session;
import ovh.spajste.langusta.entity.User;
import ovh.spajste.langusta.repository.UserRepository;
import ovh.spajste.langusta.service.MailService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SessionBuilder sessionBuilder;

    @Autowired
    private MailService mailService;

    @GetMapping("/user/me")
    public GenericStatus getLoggedInUser(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        try {
            Session session = sessionBuilder.getCurrentSession(httpServletRequest);
            if (session != null) {
                try {
                    return GenericStatus.createSuccessfulStatus(session.getUser());
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
        } catch (Exception e) {
            httpServletResponse.setStatus(500);
            return new GenericStatus(GenericStatus.GenericState.STATUS_ERROR, e.getMessage(), e);
        }
    }

    @GetMapping("/activate/{actcode}")
    public void activateUser(@PathVariable("actcode") String activationCode, HttpServletResponse httpServletResponse) {
        Optional<User> userToActivate = userRepository.findByActivationCode(activationCode);
        httpServletResponse.setStatus(301);
        if(userToActivate.isPresent()) {
            userToActivate.get().setActivationCode("");
            userToActivate.get().setActive(true);
            userRepository.save(userToActivate.get());
            httpServletResponse.addHeader("Location", "/login");
        } else {
            httpServletResponse.addHeader("Location", "/error");
        }
    }

    @PostMapping(path = "/register", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public GenericStatus addUser(@RequestParam String email, @RequestParam String pass, @RequestParam String firstName, @RequestParam String lastName, HttpServletResponse httpServletResponse) {
        return addUserJson(new User(null, firstName, lastName, email, pass, false, null), httpServletResponse);
    }

    @PostMapping(value = "/register", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public GenericStatus addUserJson(@RequestBody User user, HttpServletResponse httpServletResponse) {
        try {
            List<User> users = userRepository.findByEmail(user.getEmail());
            if(users.size() > 0) {
                httpServletResponse.setStatus(406);
                return new GenericStatus(GenericStatus.GenericState.STATUS_ERROR, "User already exists.", null);
            } else {
                user.setId(null);
                user.setPass(BCrypt.hashpw(user.getPass(), BCrypt.gensalt()));
                user.setActivationCode(UUID.randomUUID().toString());
                userRepository.save(user);
                mailService.sendMail(user.getEmail(), "Langusta registration notice", "Hello,\n\nYour mail has been given in registration at Langusta app.\nActivate your account at https://langusta.zapto.org/api/activate/"+user.getActivationCode()+"\n\nLangusta mail system");
                httpServletResponse.setStatus(201);
                return GenericStatus.createSuccessfulStatus(null);
            }
        } catch (Exception e) {
            httpServletResponse.setStatus(500);
            return new GenericStatus(GenericStatus.GenericState.STATUS_ERROR, e.getMessage(), e);
        }
    }

    @GetMapping("/user/all")
    public GenericStatus getAllUsers(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        Session session = sessionBuilder.getCurrentSession(httpServletRequest);
        if(session != null) {
            Iterable<User> users = userRepository.findAll();
            return GenericStatus.createSuccessfulStatus(users);
        } else {
            httpServletResponse.setStatus(401);
            return GenericStatus.createFailedStatusWithAdditionalInfo("Not logged in.", null);
        }
    }

    /*
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
    */

    @PutMapping(path = "/user", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public GenericStatus updateUser(@RequestBody String currentPassword, @RequestBody String newPassword, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        return updateUserJson(new UpdateUserParams(currentPassword, newPassword), httpServletRequest, httpServletResponse);
    }

    @PutMapping(path = "/user", consumes = MediaType.APPLICATION_JSON_VALUE)
    public GenericStatus updateUserJson(@RequestBody UpdateUserParams updateUserParams, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String currentPassword = updateUserParams.getCurrentPassword();
        String newPassword = updateUserParams.getNewPassword();
        try {
            Session session = sessionBuilder.getCurrentSession(httpServletRequest);
            if(session != null) {
                User loggedInUser = session.getUser();
                if(BCrypt.checkpw(currentPassword, loggedInUser.getPass())) {
                    if(!currentPassword.equals(newPassword)) {
                        loggedInUser.setPass(BCrypt.hashpw(newPassword, BCrypt.gensalt()));
                        userRepository.save(loggedInUser);
                        return GenericStatus.createSuccessfulStatus(null);
                    } else {
                        httpServletResponse.setStatus(406);
                        return GenericStatus.createFailedStatusWithAdditionalInfo("Provided passwords are the same.", null);
                    }
                } else {
                    httpServletResponse.setStatus(406);
                    return GenericStatus.createFailedStatusWithAdditionalInfo("Invalid password.", null);
                }
            } else {
                httpServletResponse.setStatus(401);
                return GenericStatus.createFailedStatusWithAdditionalInfo("Not logged in.", null);
            }
        } catch (Exception e) {
            httpServletResponse.setStatus(500);
            return GenericStatus.createFailedStatusWithAdditionalInfo(e.getMessage(), e);
        }
    }

    @GetMapping("/user/{id}")
    public GenericStatus getUserById(@PathVariable("id") Integer id, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        Session session = sessionBuilder.getCurrentSession(httpServletRequest);
        if(session != null) {
            Optional<User> requestedUser = userRepository.findById(id);
            try {
                return GenericStatus.createSuccessfulStatus(requestedUser.get());
            } catch (NoSuchElementException nsee) {
                httpServletResponse.setStatus(404);
                return new GenericStatus(GenericStatus.GenericState.STATUS_ERROR, "User not found.", nsee);
            }
        } else {
            httpServletResponse.setStatus(401);
            return GenericStatus.createFailedStatusWithAdditionalInfo("Not logged in.", null);
        }
    }
}
