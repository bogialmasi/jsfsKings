package hu.kiralyok.services;

import hu.kiralyok.domain.King;
import hu.kiralyok.domain.Kingdom;
import hu.kiralyok.repositories.KingRepository;
import hu.kiralyok.repositories.KingdomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;

@Service
public class KingdomService {

    @Autowired
    private KingdomRepository kingdomRepository;
    @Autowired
    private KingRepository kingRepository;

    public List<Kingdom> getKingdoms() {
        return kingdomRepository.findAllByOrderByName();
    }

    public Kingdom getKingdomById(int id) {
        Optional<Kingdom> kingdom = kingdomRepository.findById(id);
        if (kingdom.isPresent()) {
            return kingdom.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public List<King> getKingsByKingdom(int id) {
        Optional<Kingdom> kingdom = kingdomRepository.findById(id);
        if (kingdom.isPresent()) {
            return kingdom.get().getKings();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public Kingdom addKingdom(Kingdom kingdom) {
        if (isUnique(kingdom.getName())) {
            return kingdomRepository.save(kingdom);
        }
        throw new ResponseStatusException(HttpStatus.CONFLICT);
    }

    private boolean isUnique(String name) {
        List<Kingdom> kingdoms = kingdomRepository.findAll();
        for (Kingdom kingdom : kingdoms) {
            if (kingdom.getName().equals(name)) {
                return false;
            }
        }
        return true;
    }

    public void deleteKingdom(int id) {
        Optional<Kingdom> category = kingdomRepository.findById(id);
        if (category.isPresent()) {
            kingdomRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public void updateKingdom(int id, int area, int population) {
        Optional<Kingdom> optionalKingdom = kingdomRepository.findById(id);
        if (optionalKingdom.isPresent()) {
            Kingdom kingdom = optionalKingdom.get();
            kingdom.setArea(area);
            kingdom.setPopulation(population);
            kingdomRepository.save(kingdom);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
