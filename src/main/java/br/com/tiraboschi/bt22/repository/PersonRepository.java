package br.com.tiraboschi.bt22.repository;

import br.com.tiraboschi.bt22.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {
}
