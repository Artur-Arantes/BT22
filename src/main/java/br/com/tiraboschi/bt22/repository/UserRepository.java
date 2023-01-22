package br.com.tiraboschi.bt22.repository;

import br.com.tiraboschi.bt22.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findByUsername(String username);
}
