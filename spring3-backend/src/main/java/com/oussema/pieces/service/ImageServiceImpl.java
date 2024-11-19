package com.oussema.pieces.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.oussema.pieces.entities.Image;
import com.oussema.pieces.entities.Pieces;
import com.oussema.pieces.repos.ImageRepository;
import com.oussema.pieces.repos.PieceRepository;
@Service
public class ImageServiceImpl implements ImageService{
@Autowired
ImageRepository imageRepository;

@Autowired
PieceService pieceService;

@Override
public Image uplaodImage(MultipartFile file) throws IOException {
	/*
	 * Ce code commenté est équivalent au code utilisant le design pattern Builder
	 * Image image = new Image(null, file.getOriginalFilename(),
	 * file.getContentType(), file.getBytes(), null); return
	 * imageRepository.save(image);
	 */
return imageRepository.save(Image.builder()
.name(file.getOriginalFilename())
.type(file.getContentType())
.image(file.getBytes()).build() );
}
@Override
public Image getImageDetails(Long id) throws IOException{
final Optional<Image> dbImage = imageRepository. findById (id);
return Image.builder()
.idImage(dbImage.get().getIdImage())
.name(dbImage.get().getName())
.type(dbImage.get().getType())
.image(dbImage.get().getImage()).build() ;
}
@Override
public ResponseEntity<byte[]> getImage(Long id) throws IOException{
final Optional<Image> dbImage = imageRepository. findById (id);
return ResponseEntity
.ok()
.contentType(MediaType.valueOf(dbImage.get().getType()))
.body(dbImage.get().getImage());
}
@Override
public void deleteImage(Long id) {
imageRepository.deleteById(id);
}
@Override
public Image uplaodImagePiec(MultipartFile file,Long idPiec)
throws IOException {
Pieces p = new Pieces();
p.setIdPiece(idPiec);
return imageRepository.save(Image.builder()
.name(file.getOriginalFilename())
.type(file.getContentType())
.image(file.getBytes())
.piece(p).build() );
}
@Override
public List<Image> getImagesParPiec(Long piecId) {
Pieces p = PieceRepository.findById(piecId).get();
return p.getImages();
}

}
