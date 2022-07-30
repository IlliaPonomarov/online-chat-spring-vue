package ua.ponomarov.Illia.chat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.ponomarov.Illia.chat.model.Person;
import ua.ponomarov.Illia.chat.repository.PeopleRepository;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PersonService {

    private final PeopleRepository peopleRepository;

    @Autowired
    public PersonService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }


    public Optional<Person> findByUsername(String username){
        return peopleRepository.findByUsername(username);
    }

     public Person findByPrincipal(Person person){
        return null;
     }


    public List<Person> findAll() {
        return peopleRepository.findAll();
    }

    public Optional<Person> findById(int id) {
        return peopleRepository.findById(id);
    }
}
