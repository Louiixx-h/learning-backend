package br.com.luislabs.personRegister.mapper;

import br.com.luislabs.personRegister.data.vo.v1.PersonVO;
import br.com.luislabs.personRegister.model.Person;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
class PersonMapperTest {

    private Person person;

    private final String FIST_NAME = "fistNameXPTO";
    private final String LAST_NAME = "lastNameXPTO";
    private final String ADDRESS = "addressXPTO";
    private final String GENDER = "genderXPTO";

    @BeforeEach
    public void before() {
        person = new Person();
        person.setFirstName(FIST_NAME);
        person.setLastName(LAST_NAME);
        person.setAddress(ADDRESS);
        person.setGender(GENDER);
    }

    @AfterEach
    public void after() {
        person = null;
    }

    @Test
    public void givenAPersonEntityWhenParseToVOThenFieldsShouldBeIdentical() {
        var result = PersonMapper.INSTANCE.personToPersonVO(person);
        assertEquals(FIST_NAME, result.getFirstName());
        assertEquals(LAST_NAME, result.getLastName());
        assertEquals(ADDRESS, result.getAddress());
        assertEquals(GENDER, result.getGender());
    }

    @Test
    public void givenAPersonEntityListWhenParseToVOThenFieldsShouldBeIdentical() {
        List<Person> persons = new ArrayList<>();
        persons.add(person);
        persons.add(person);
        persons.add(person);

        var result = PersonMapper.INSTANCE.personToPersonVO(persons);

        for (PersonVO p : result) {
            assertEquals(FIST_NAME, p.getFirstName());
            assertEquals(LAST_NAME, p.getLastName());
            assertEquals(ADDRESS, p.getAddress());
            assertEquals(GENDER, p.getGender());
        }
    }

    @Test
    public void givenAPersonEntityListWhenParseToVOThenCheckListSize() {
        List<Person> persons = new ArrayList<>();
        persons.add(person);
        persons.add(person);
        persons.add(person);

        var result = PersonMapper.INSTANCE.personToPersonVO(persons);

        assertEquals(persons.size(), result.size());
    }
}