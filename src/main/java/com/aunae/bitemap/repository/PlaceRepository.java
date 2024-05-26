package com.aunae.bitemap.repository;

import com.aunae.bitemap.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlaceRepository extends JpaRepository<Place, Long> {
    Optional<Place> findByName(String name);
}