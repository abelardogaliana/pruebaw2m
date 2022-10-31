package travel.w2m.prueba.controller;

import java.util.ArrayList;
import java.util.List;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import travel.w2m.prueba.dto.SuperHeroesDto;
import travel.w2m.prueba.exception.RecordNotFoundException;
import travel.w2m.prueba.exception.RecordNotModifiedException;
import travel.w2m.prueba.service.SuperHeroesService;

@RestController
@ResponseBody
@RequestMapping("/heroes")
public class SuperHeroesController {

	@Autowired
	SuperHeroesService superHeroesService;

	@GetMapping("/all")
	public ResponseEntity<List<SuperHeroesDto>> all() throws RecordNotFoundException{
		List<SuperHeroesDto> res = new ArrayList<>();
		
		res = superHeroesService.findAll();
		
		if(res != null && res.size() > 0)
			return ResponseEntity.status(HttpStatus.OK).body(res);
		
		else
			throw new RecordNotFoundException();
	}

	@GetMapping("/{id}")
	public ResponseEntity<SuperHeroesDto> findId(@PathVariable long id) throws RecordNotFoundException {

		SuperHeroesDto aux = null;

		aux = superHeroesService.findOne(id);

		if(aux != null)
			return ResponseEntity.status(HttpStatus.OK).body(aux);
		else
			throw new RecordNotFoundException();
	}

	@PutMapping("/{id}")
	public ResponseEntity<SuperHeroesDto> put(@PathVariable String id, @RequestBody SuperHeroesDto input) throws RecordNotModifiedException {
		SuperHeroesDto modified = superHeroesService.modify(Long.valueOf(id), input);
		if(modified != null)
			return ResponseEntity.status(HttpStatus.OK).body(modified);
		else
			throw new RecordNotModifiedException();
	}

	@PostMapping
	public ResponseEntity<Long> post(@RequestBody SuperHeroesDto input) {
		long save = superHeroesService.save(input);
		return ResponseEntity.status(HttpStatus.CREATED).body(save);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable String id) throws RecordNotFoundException {
		Boolean deleted = superHeroesService.delete(Long.valueOf(id));
		
		if(deleted == true)
			return ResponseEntity.status(HttpStatus.OK).body(deleted);
		else
			throw new RecordNotFoundException();
			
	}

}
