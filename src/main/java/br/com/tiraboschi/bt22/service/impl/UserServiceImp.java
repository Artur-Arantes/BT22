package br.com.tiraboschi.bt22.service.impl;

import br.com.tiraboschi.bt22.model.User;
import br.com.tiraboschi.bt22.repository.UserRepository;
import br.com.tiraboschi.bt22.service.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImp implements UserService {

  @Autowired
  private final UserRepository userRepository;


  @Override
  public User findByUsername(@NonNull final String login) {
    final var user = userRepository.findByUsername(login);
    return user.filter(User::isEnabled).orElseThrow();
  }

}
