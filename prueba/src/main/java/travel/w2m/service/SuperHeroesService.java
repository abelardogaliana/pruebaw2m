package travel.w2m.service;

import java.util.List;

import travel.w2m.dto.SuperHeroesDto;

public interface SuperHeroesService {
	public List<SuperHeroesDto> findAll();

	public SuperHeroesDto findOne(Long id);
	
	public List<SuperHeroesDto> findBySubStringName(String name);

	public long save(SuperHeroesDto heroDto);

	public SuperHeroesDto modify(long id, SuperHeroesDto heroDto);
	
	public boolean delete (long id);
}
