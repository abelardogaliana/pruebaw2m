package travel.w2m.prueba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import travel.w2m.prueba.dto.SuperHeroesDto;
import travel.w2m.prueba.entity.SuperHeroes;
import travel.w2m.prueba.mapper.SuperHeroesMapper;
import travel.w2m.prueba.repository.SuperHeroesRepository;
import travel.w2m.prueba.service.SuperHeroesService;

@Service
public class SuperHeroesServiceImpl implements SuperHeroesService {

	@Autowired
	SuperHeroesRepository superHeroesRepository;

	@Override
	@Cacheable(value = "superHeroesCache")
	public List<SuperHeroesDto> findAll() {
		List<SuperHeroesDto> listSuperHeroesDto = null;
		List<SuperHeroes> listSuperHeroes = null;

		listSuperHeroes = superHeroesRepository.findAll();

		listSuperHeroesDto = SuperHeroesMapper.INSTANCE.map(listSuperHeroes);

		System.out.println("Sin cachear");
		return listSuperHeroesDto;
	}

	@Override
	public SuperHeroesDto findOne(Long id) {
		SuperHeroes aux = null;
		SuperHeroesDto superHeroesDto = null;

		aux = superHeroesRepository
				.findById(id).orElse(null);

		superHeroesDto = SuperHeroesMapper.INSTANCE.heroesToHeroesDto(aux);

		return superHeroesDto;
	}

	@Override
	public List<SuperHeroesDto> findBySubStringName(String name) {
		List<SuperHeroesDto> listSuperHeroesDto = null;
		List<SuperHeroes> listSuperHeroes = null;
		
		listSuperHeroes = superHeroesRepository.findByNameContainingIgnoreCase(name);

		listSuperHeroesDto = SuperHeroesMapper.INSTANCE.map(listSuperHeroes);

		return listSuperHeroesDto;
	}
	
	@Override
	public long save(SuperHeroesDto heroDto) {
		
		SuperHeroes aux = SuperHeroesMapper.INSTANCE.heroesDtoToHeroes(heroDto);
		
		aux = superHeroesRepository.save(aux);
		
		return aux.getId();
	}
	
	@Override
	public SuperHeroesDto modify(long id, SuperHeroesDto heroDto) {
		
		SuperHeroesDto superHeroesDto = null;
		SuperHeroes aux = superHeroesRepository.findById(id).orElse(null);
		
		if(aux != null) {
			aux.setCreatedDate(heroDto.getCreatedDate());
			aux.setName(heroDto.getName());
			aux = superHeroesRepository.save(aux);
		}
		
		superHeroesDto = SuperHeroesMapper.INSTANCE.heroesToHeroesDto(aux);
	
		return superHeroesDto;
	}

	@Override
	public boolean delete(long id) {
		
		SuperHeroes aux = superHeroesRepository.findById(id).orElse(null);
		
		if(aux != null) {
			superHeroesRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
	

}
