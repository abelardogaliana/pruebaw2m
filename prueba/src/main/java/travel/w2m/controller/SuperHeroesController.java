package travel.w2m.controller;

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

import travel.w2m.dto.SuperHeroesDto;
import travel.w2m.service.SuperHeroesService;

@RestController
@ResponseBody
@RequestMapping("/heroes")
public class SuperHeroesController {

	@Autowired
	SuperHeroesService superHeroesService;

	@GetMapping("/all")
	public ResponseEntity<List<SuperHeroesDto>> all() {
		return ResponseEntity.status(HttpStatus.OK).body(superHeroesService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<SuperHeroesDto> findId(@PathVariable long id) {

		SuperHeroesDto aux = null;

		aux = superHeroesService.findOne(id);

		return ResponseEntity.status(HttpStatus.OK).body(aux);
	}

	@PutMapping("/{id}")
	public ResponseEntity<SuperHeroesDto> put(@PathVariable String id, @RequestBody SuperHeroesDto input) {
		SuperHeroesDto modified = superHeroesService.modify(Long.valueOf(id), input);
		return ResponseEntity.status(HttpStatus.OK).body(modified);
	}

	@PostMapping
	public ResponseEntity<Long> post(@RequestBody SuperHeroesDto input) {
		long save = superHeroesService.save(input);
		return ResponseEntity.status(HttpStatus.CREATED).body(save);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable String id) {
		Boolean deleted = superHeroesService.delete(Long.valueOf(id));
		return ResponseEntity.status(HttpStatus.OK).body(deleted);
	}

}
