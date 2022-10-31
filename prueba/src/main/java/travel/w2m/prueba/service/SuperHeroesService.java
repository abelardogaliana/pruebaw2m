package travel.w2m.prueba.service;

import java.util.List;

import travel.w2m.prueba.annotations.LogExecutionTime;
import travel.w2m.prueba.dto.SuperHeroesDto;

public interface SuperHeroesService {
	@LogExecutionTime
	public List<SuperHeroesDto> findAll();

	@LogExecutionTime
	public SuperHeroesDto findOne(Long id);

	@LogExecutionTime
	public List<SuperHeroesDto> findBySubStringName(String name);

	@LogExecutionTime
	public long save(SuperHeroesDto heroDto);

	@LogExecutionTime
	public SuperHeroesDto modify(long id, SuperHeroesDto heroDto);

	@LogExecutionTime
	public boolean delete(long id);
}
