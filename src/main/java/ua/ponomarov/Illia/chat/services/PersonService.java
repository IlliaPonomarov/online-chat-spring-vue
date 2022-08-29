package ua.ponomarov.Illia.chat.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.ponomarov.Illia.chat.dto.PersonDTO;
import ua.ponomarov.Illia.chat.model.Chat;
import ua.ponomarov.Illia.chat.model.Person;
import ua.ponomarov.Illia.chat.repository.ChatRepository;
import ua.ponomarov.Illia.chat.repository.PeopleRepository;

import java.util.Collections;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PersonService {

    private final PeopleRepository peopleRepository;
    private final ChatRepository chatRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public PersonService(PeopleRepository peopleRepository, ChatRepository chatRepository, ModelMapper modelMapper) {
        this.peopleRepository = peopleRepository;
        this.chatRepository = chatRepository;
        this.modelMapper = modelMapper;
    }

    public Optional<Person> findByUsername(String username){
        return peopleRepository.findByUsername(username);
    }

    public List<Chat> getAllChatsOfPerson(String nameOfAuthenticatedPerson){
        Optional<Person> person = peopleRepository.findByUsername(nameOfAuthenticatedPerson);

        if (person.isEmpty())
            return Collections.emptyList();


        return person.get().getChats();
    }

    public Optional<Person> findByEmail(String email){
        return peopleRepository.findByEmail(email);
    }

    public Person findByPrincipal(Person person){
        return null;
    }

    public Person convertToPerson(PersonDTO personDTO){
        return modelMapper.map(personDTO, Person.class);
    }
    public List<Person> findAll() {
        return peopleRepository.findAll();
    }

    public Optional<Person> findById(int id) {
        return peopleRepository.findById(id);
    }
}