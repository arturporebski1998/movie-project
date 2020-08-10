package practices.registration.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import practices.registration.Model.User;
import practices.registration.Repository.UserRepository;


import java.util.List;

@SpringBootApplication
@RestController
public class RegistrationServiceApplication {

    @Autowired
    private UserRepository repository;

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public String register(@RequestBody User user) {
        repository.save(user);
        return "Hi " + user.getName() + " your Registration process successfully completed";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> findAllUsers() {
        return repository.findAll();
    }


    @RequestMapping(value = "/users/{email}", method = RequestMethod.GET)
    public List<User> findUser(@PathVariable String email) {
        return repository.findByEmail(email);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public List<User> cancelRegistration(@PathVariable int id) {
        repository.deleteById(id);
        return repository.findAll();
    }

    public static void main(String[] args) {
        SpringApplication.run(RegistrationServiceApplication.class, args);
    }

}
