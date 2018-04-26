package com.example.curso.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.curso.domain.Categoria;
import com.example.curso.repositories.CategoriaRepository;
import com.example.curso.services.exceptions.ObjectNotFoundException;





@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repositorio;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repositorio.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}

}
