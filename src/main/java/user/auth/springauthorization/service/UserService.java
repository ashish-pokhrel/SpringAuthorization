package user.auth.springauthorization.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import user.auth.springauthorization.repository.IUserRepo;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private IUserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //logic to get the User From the Database
        user.auth.springauthorization.model.User getByEmail = getByEmail(username);
        User user = new User(getByEmail.getEmail(), getByEmail.getPassword(), new ArrayList<>());
        return user;
    }

    public user.auth.springauthorization.model.User getByEmail(String email) {
        var user=  userRepo.findByUserName(email);
        return  user;
    }

    public void saveUser(user.auth.springauthorization.model.User user) {
        userRepo.save(user);
    }

    public user.auth.springauthorization.model.User getById(int id) {
        return userRepo.getById(id);
    }

    public Optional<user.auth.springauthorization.model.User> findById(int id) {
        return userRepo.findById(id);
    }
}
