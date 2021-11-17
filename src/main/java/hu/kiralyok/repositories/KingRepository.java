package hu.kiralyok.repositories;

import hu.kiralyok.domain.King;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
    public interface KingRepository extends JpaRepository<King, Integer> {
        public List<King> findAllByOrderByName();

    }
