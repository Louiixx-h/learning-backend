package br.com.luislabs.personRegister.services;

import br.com.luislabs.personRegister.data.vo.v1.PersonVO;
import br.com.luislabs.personRegister.data.vo.v2.PersonVOV2;

import java.util.List;

public interface PersonService {
    List<PersonVO> findAll();
    List<PersonVOV2> findAllV2();
    PersonVO findById(Long id);
    PersonVOV2 findByIdV2(Long id);
    PersonVO create(PersonVO person);
    PersonVO update(PersonVO person);
    PersonVOV2 updateV2(PersonVOV2 person);
    void delete(Long id);
    PersonVOV2 createV2(PersonVOV2 person);
}
