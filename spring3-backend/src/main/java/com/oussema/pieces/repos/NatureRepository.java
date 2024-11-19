package com.oussema.pieces.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oussema.pieces.entities.Nature;

public interface NatureRepository extends JpaRepository<Nature, Long> {

}
