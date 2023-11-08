package br.com.luislabs.personRegister.repositories;

import br.com.luislabs.personRegister.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> { }
