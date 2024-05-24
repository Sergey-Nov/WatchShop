package org.example.repository;

import org.example.entity.Watches;
import org.example.entity.enums.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WatchesJPARepository extends JpaRepository<Watches, String> {
    List<Watches> getWatchesByType(Type type);
    List<Watches> getMechanicalWatchesWithPriceLower(int price);
    List<Watches> findAll();
}
