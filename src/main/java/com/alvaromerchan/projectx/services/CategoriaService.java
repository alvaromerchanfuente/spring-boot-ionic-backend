package com.alvaromerchan.projectx.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alvaromerchan.projectx.domain.Categoria;
import com.alvaromerchan.projectx.repositories.CategoriaRepository;
import com.alvaromerchan.projectx.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
		}
	
		public Categoria insert(Categoria obj) {
			obj.setId(null);
			return repo.save(obj);
		}
	
	}

	
	
