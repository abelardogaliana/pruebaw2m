package travel.w2m.prueba.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import travel.w2m.prueba.dto.SuperHeroesDto;
import travel.w2m.prueba.entity.SuperHeroes;

@Mapper
public interface SuperHeroesMapper {

	SuperHeroesMapper INSTANCE = Mappers.getMapper(SuperHeroesMapper.class);

	SuperHeroesDto heroesToHeroesDto(SuperHeroes hero);
	
	SuperHeroes heroesDtoToHeroes(SuperHeroesDto heroDto);

	List<SuperHeroesDto> map(List<SuperHeroes> heroes);
}
