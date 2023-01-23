package br.com.tiraboschi.bt22.service;

import br.com.tiraboschi.bt22.model.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService {

  User findByUsername(String user) throws UsernameNotFoundException;

}
