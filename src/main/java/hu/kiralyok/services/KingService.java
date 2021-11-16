package hu.kiralyok.services;

import hu.kiralyok.domain.King;
import hu.kiralyok.repositories.KingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

    @Service
    public class KingService {

        @Autowired
        private KingRepository repository;

        public List<King> getKings() {
            return repository.findAll();
        }

        public King getKingById(long id) {
            Optional<King> king = repository.findById(id);
            if (king.isPresent()) {
                return king.get();
            }
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        /*---------------------------------------------------------------------------*/

        public King addKing(King king) {
            if (isUnique(king.getName())) {
                return repository.save(king);
            }
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }

        private boolean isUnique(String name) {
            List<King> kings = repository.findAll();
            for (King king : kings) {
                if (king.getName().equals(name)) {
                    return false;
                }
            }
            return true;
        }

        /*---------------------------------------------------------------------------*/


        public void killKing(long id) {
            Optional<King> king = repository.findById(id);
            if (king.isPresent()) {
                repository.deleteById(id);
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            }
        }

        /*---------------------------------------------------------------------------*/

        public void updateKing(long id, int death) {
            Optional<King> optionalCategory = repository.findById(id);
            if (optionalCategory.isPresent()) {
                King king = optionalCategory.get();
                king.setDeath(death);
                repository.save(king);
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            }
        }

    }

}
