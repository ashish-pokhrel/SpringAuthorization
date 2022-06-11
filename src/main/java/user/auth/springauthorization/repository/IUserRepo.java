package user.auth.springauthorization.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import user.auth.springauthorization.model.User;

@Repository
public interface IUserRepo extends JpaRepository<User,Integer> {

    @Query("SELECT s FROM User s WHERE s.email =:email")
    public User getByEmail(String email);
}
