package com.oussema.pieces.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.oussema.pieces.entities.Pieces;
import com.oussema.pieces.service.PieceService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PieceRESTController {

	@Autowired
	PieceService pieceService ;
	
	@RequestMapping(path="all",method = RequestMethod.GET)
	List<Pieces> getAllPieces(){
		return pieceService.getAllPieces();
	}
	
	
	@RequestMapping(value="/getbyid/{id}",method = RequestMethod.GET)
	public Pieces getPieceById(@PathVariable("id") Long id) {
	return pieceService.getPiece(id);
	}
	
	@RequestMapping(value="/addpiec",method = RequestMethod.POST)
	@PreAuthorize("hasAuthority('ADMIN')")
	public Pieces createPiece(@RequestBody Pieces pieces) {
	return pieceService.savePiece(pieces);
	}
	
	@RequestMapping(value="/updatepiec",method = RequestMethod.PUT)
	public Pieces updatePiece(@RequestBody Pieces pieces) {
	return pieceService.savePiece(pieces);
	}
	
	@RequestMapping(value="/delpiec/{id}",method = RequestMethod.DELETE)
	public void deletePiece(@PathVariable("id") Long id)
	{
	pieceService.deletePieceById(id);
	}
	
	@RequestMapping(value="/piecsnat/{idNat}",method = RequestMethod.GET)
	public List<Pieces> getPiecesBy_NatId(@PathVariable("idNat") Long idNat) {
	return pieceService.findByNatureIdNat(idNat);
	}
	
	@RequestMapping(value="/piecsByName/{nom}",method = RequestMethod.GET)
	public List<Pieces> findByNomPieceContains(@PathVariable("nom") String nom) {
	return pieceService.findByNomPieceContains(nom);
	}
	
}
	