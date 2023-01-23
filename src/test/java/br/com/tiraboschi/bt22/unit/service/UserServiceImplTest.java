package br.com.tiraboschi.bt22.unit.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import br.com.tiraboschi.bt22.model.Permission;
import br.com.tiraboschi.bt22.model.Person;
import br.com.tiraboschi.bt22.model.User;
import br.com.tiraboschi.bt22.repository.UserRepository;
import java.util.Optional;

import br.com.tiraboschi.bt22.service.impl.UserServiceImp;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {
  @Mock
  UserRepository userRepository;

  @InjectMocks
  UserServiceImp userServiceImp;

  @Nested
  @DisplayName("testing method findByUsername from UserServiceImpl class")
  class FindByUsername {

    @Test
    @DisplayName("testing success of method findByUsername")
    void findByUsername_success() {
      final var user = mock(User.class);
      when(user.isEnabled()).thenReturn(true);
      final var login = "anyone";
      when(userRepository.findByUsername(login)).thenReturn(Optional.of(user));
      assertThat(userServiceImp.findByUsername(login)).isNotNull().isEqualTo(user);
    }

    @DisplayName("null entry")
    @Test
    void null_entry() {
      assertThatExceptionOfType(NullPointerException.class).isThrownBy(
          () -> userServiceImp.findByUsername(null));
    }

    @DisplayName("user not enable")
    @Test
    void user_not_enable() {
      final var user = mock(User.class);
      final var login = "anyone";
      when(userRepository.findByUsername(login)).thenReturn(Optional.of(user));
      when(user.isEnabled()).thenReturn(false);
      assertThatExceptionOfType(RuntimeException.class).isThrownBy(
          () -> userServiceImp.findByUsername(login));
    }
  }
  @DisplayName("Testing method create from UserServiceImpl class")
  @Nested
  class Create{

    @Test
    void create_user_success(){
      final var user= mock(User.class);
      final var person= mock(Person.class);
      final var permission=mock(Permission.class);
      when(userServiceImp.create(UserDto)).thenReturn()

    }
  }

}