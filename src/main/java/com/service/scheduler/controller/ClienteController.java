package com.service.scheduler.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.scheduler.model.Cliente;
import com.service.scheduler.repository.ClienteRepository;

@RestController
@RequestMapping(value = "/agenda/cliente") 
public class ClienteController {
	
	
	@Autowired
	ClienteRepository clienteRepository;	
	
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<Cliente>> pesquisarTodos(){
		List<Cliente> clienteList = clienteRepository.findAll();
		if(clienteList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<List<Cliente>>(clienteList, HttpStatus.OK);
		}
	} 


	@GetMapping(value = "/nome/{variavel}")
	public List<Cliente> pesquisa(@PathVariable("variavel") String var) {
		// SELECT DE REPOSITORY (MAIS OPÇÕES)
		// String var = @PathVariable("variavel");
		//Cliente c1 = clienteRepository.findByNome(var);
		//System.out.println("Cliente : " + c1.getNome());

		//List<Cliente> clienteList = clienteRepository.findByNomeContaining(var);

		return null;//clienteList;

		//		for (Peca peca : p2) {
		//			System.out.println("peca : " + peca.getMaterial());
		//		}
	}


	// nova implementação

	@PostMapping("/add")
	public ResponseEntity<Cliente> savePeca(@RequestBody @Valid Cliente cliente) {
		return new ResponseEntity<Cliente>(clienteRepository.save(cliente), HttpStatus.CREATED);
	}

	@PutMapping("/up/{id}")
	public ResponseEntity<Cliente> updatePeca(@PathVariable(value="id") Integer id,
			@RequestBody @Valid Cliente cliente) {
		Optional<Cliente> clienteOp = clienteRepository.findById(id);
		if(!clienteOp.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			cliente.setId(clienteOp.get().getId());
			return new ResponseEntity<Cliente>(clienteRepository.save(cliente), HttpStatus.OK);
		}
	}

	@DeleteMapping("/del/{id}")
	public ResponseEntity<?> deletePeca(@PathVariable(value="id") Integer id) {
		Optional<Cliente> clienteOp = clienteRepository.findById(id);
		if(!clienteOp.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			clienteRepository.delete(clienteOp.get());
			return new ResponseEntity<>(HttpStatus.OK);
		}
	} 	
	
	
	
	
	

}
