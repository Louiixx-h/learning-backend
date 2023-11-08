package br.com.luislabs.personRegister.mapper;

import br.com.luislabs.personRegister.data.vo.v1.PersonVO;
import br.com.luislabs.personRegister.data.vo.v2.PersonVOV2;
import br.com.luislabs.personRegister.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    PersonVO personToPersonVO(Person person);
    PersonVOV2 personToPersonVOV2(Person person);
    List<PersonVO> personToPersonVO(List<Person> person);
    List<PersonVOV2> personToPersonVOV2(List<Person> person);
    Person personVOToPerson(PersonVO person);
    Person personVOV2ToPerson(PersonVOV2 person);
}
