package br.com.tiraboschi.bt22.unit.service;

import br.com.tiraboschi.bt22.repository.UserRepository;
import br.com.tiraboschi.bt22.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PessoaServiceTest {
  @Mock
  private UserRepository repository;

  @InjectMocks
  private UserService service;

  @Nested
  @DisplayName("Criando Pessoa")
  private class Create {
    @Test
    public void sucess(){

    }
  }
}
