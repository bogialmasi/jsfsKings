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

    public Kingdom getKingdomById(long id) {
        Optional<Kingdom> kingdom = kingdomRepository.findById(id);
        if (kingdom.isPresent()) {
            return kingdom.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public List<King> getKingsByKingdom(long id) {
        Optional<Kingdom> kingdom = kingdomRepository.findById(id);
        if (kingdom.isPresent()) {
            return kingdom.get().getKings();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public Kingdom addKingdom(Kingdom category) {
    }

    public void deleteKingdom(int id) {
    }

    public void updateKingdom(int id, int area, int population) {
    }
}
