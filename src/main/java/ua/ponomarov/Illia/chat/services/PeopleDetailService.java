package ua.ponomarov.Illia.chat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.ponomarov.Illia.chat.model.Person;
import ua.ponomarov.Illia.chat.repository.PeopleRepository;
import ua.ponomarov.Illia.chat.security.PersonDetails;

import java.util.Optional;

@Service
public class PeopleDetailService implements UserDetailsService {

    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleDetailService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Person> person = peopleRepository.findByUsername(username);

        if (person.isEmpty())
            throw new UsernameNotFoundException("USER NOT FOUND");


        return new PersonDetails(person.get());
    }
}
