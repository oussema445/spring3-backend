package com.oussema.pieces.service;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import com.oussema.pieces.entities.Image;

public interface ImageService {
	Image uplaodImage(MultipartFile file) throws IOException;

	Image getImageDetails(Long id) throws IOException;

	ResponseEntity<byte[]> getImage(Long id) throws IOException;

	void deleteImage(Long id);
	
	Image uplaodImagePiec(MultipartFile file,Long idPiec) throws IOException;
	List<Image> getImagesParPiec(Long piecId);
}