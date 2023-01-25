package ronron.spring.boot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ronron.spring.boot.model.entities.Animals;
import ronron.spring.boot.model.entities.Users;
import ronron.spring.boot.model.enuns.Situation;
import ronron.spring.boot.model.repositories.AnimalsRepository;

import java.util.Optional;

@Service
public class AnimalsService {
    @Autowired
    private AnimalsRepository  animalsRepository;

    public Animals save(Users user, Animals animal) {
        animal.setUser(user);
        return animalsRepository.save(animal);
    }


    public Animals animalUpdate(Users user, Integer id, Animals animal) {
        Optional<Animals> opAnimal = animalsRepository.findById(id);
        if (opAnimal.isPresent()) {
            Animals nobanco = opAnimal.get();
            if (nobanco.getUser().getId() == user.getId()) {
                animal.setId(id);
                animal.setUser(user);
                return animalsRepository.save(animal);
            }
        }
        return null;
    }

    public Iterable<Animals> search(String type, String gender, String collors) {
        return animalsRepository.search(type, gender, collors);
    }

    public Iterable<Animals> searchLost(boolean perdidos) {
        return animalsRepository.searchLost(perdidos);
    }

    public Iterable<Animals> searchBySituation(Situation situation) {
        return animalsRepository.searchBySituation(situation);
    }

    public Iterable<Animals> findByUser(Users user) {
        return animalsRepository.findByUser(user);
    }
}
