package com.oussema.pieces.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oussema.pieces.entities.Image;
public interface ImageRepository extends JpaRepository<Image , Long> {
	
}
