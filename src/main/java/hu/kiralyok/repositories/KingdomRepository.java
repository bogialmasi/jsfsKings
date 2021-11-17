package hu.kiralyok.repositories;

import hu.kiralyok.domain.King;
import hu.kiralyok.domain.Kingdom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KingdomRepository extends JpaRepository<Kingdom, Integer> {
    public List<Kingdom> findAllByOrderByName();

}
