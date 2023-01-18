package ronron.spring.boot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import ronron.spring.boot.model.entities.Animals;
import ronron.spring.boot.model.repositories.AnimalsRepository;

@Service
public class AnimalsService {
    @Autowired
    private AnimalsRepository  animalsRepository;

    @GetMapping
    public Iterable<Animals> getAnimal(String type, String gender, String collors) {
        return animalsRepository.search(type, gender, collors);
    }

    public  Animals save(Animals animal) {
        return animalsRepository.save(animal);
    }

}
