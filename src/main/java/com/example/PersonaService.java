package com.example;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService {

    private final PersonaRepository personaRepository;

    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public List<Persona> findAll() {
        return personaRepository.findAll();
    }

    public Persona save(Persona persona) {
        return personaRepository.save(persona);
    }

    public Persona update(Persona persona) {
        return personaRepository.save(persona);
    }

    public void delete(Persona persona) {
        personaRepository.delete(persona);
    }

}
