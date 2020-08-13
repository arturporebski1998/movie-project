package practices.registration.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import practices.registration.Model.User;
import practices.registration.Repository.UserRepository;

import java.util.LinkedList;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    //get users
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<LinkedList<User>> getAllUsers() {
        return new ResponseEntity(this.userRepository.findAll(), HttpStatus.OK);
    }

    //get user by id
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getOneUser(@PathVariable(value = "id") Long userId) {
        return new ResponseEntity(this.userRepository.findById(userId), HttpStatus.OK);
    }


    //post users
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        userRepository.save(user);
        return new ResponseEntity(this.userRepository.save(user), HttpStatus.OK);
    }

}
