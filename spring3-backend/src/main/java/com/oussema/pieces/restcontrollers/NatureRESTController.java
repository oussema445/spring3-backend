package com.oussema.pieces.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.oussema.pieces.entities.Nature;
import com.oussema.pieces.repos.NatureRepository;

@RestController
@RequestMapping("/api/nat")
@CrossOrigin("*")
public class NatureRESTController {

	
	@Autowired
	NatureRepository natureRepository ;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Nature> getAllNatures()
	{
	return natureRepository.findAll();
	}
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Nature getNatureById(@PathVariable("id") Long id) {
	return natureRepository.findById(id).get();
	}
}
