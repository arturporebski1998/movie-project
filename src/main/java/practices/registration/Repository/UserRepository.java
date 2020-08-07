package practices.registration.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import practices.registration.Model.User;


import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {
    List<User> findByEmail(String email);
}