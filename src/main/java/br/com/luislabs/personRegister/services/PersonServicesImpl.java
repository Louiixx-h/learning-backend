package br.com.luislabs.personRegister.services;

import br.com.luislabs.personRegister.data.vo.v2.PersonVOV2;
import br.com.luislabs.personRegister.exceptions.ResourceNotFoundException;
import br.com.luislabs.personRegister.data.vo.v1.PersonVO;
import br.com.luislabs.personRegister.mapper.PersonMapper;
import br.com.luislabs.personRegister.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonServicesImpl implements PersonService {

    private final Logger logger = Logger.getLogger(PersonServicesImpl.class.getName());

    private final PersonRepository repository;
    private final PersonMapper mapper;

    public PersonServicesImpl(PersonRepository repository, PersonMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<PersonVO> findAll() {
        logger.info("Finding All people!");
        return mapper.personToPersonVO(repository.findAll());
    }

    @Override
    public List<PersonVOV2> findAllV2() {
        logger.info("Finding All people!");
        return mapper.personToPersonVOV2(repository.findAll());
    }

    @Override
    public PersonVO findById(Long id) {
        logger.info("Finding one person!");
        var person = repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("No records found for this ID")
        );
        return mapper.personToPersonVO(person);
    }

    @Override
    public PersonVOV2 findByIdV2(Long id) {
        logger.info("Finding one person!");
        var person = repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("No records found for this ID")
        );
        return mapper.personToPersonVOV2(person);
    }

    @Override
    public PersonVO create(PersonVO person) {
        logger.info("Creating one person!");
        var personSaved = repository.save(mapper.personVOToPerson(person));
        return mapper.personToPersonVO(personSaved);
    }

    @Override
    public PersonVOV2 createV2(PersonVOV2 person) {
        logger.info("Creating one person with V2!");
        var personSaved = repository.save(mapper.personVOV2ToPerson(person));
        return mapper.personToPersonVOV2(personSaved);
    }

    @Override
    public PersonVO update(PersonVO person) {
        logger.info("Updating one person!");
        var entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        return mapper.personToPersonVO(repository.save(entity));
    }

    @Override
    public PersonVOV2 updateV2(PersonVOV2 person) {
        logger.info("Updating one person with V2!");
        var entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        return mapper.personToPersonVOV2(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        logger.info("Deleting one person!");
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        repository.delete(entity);
    }
}
