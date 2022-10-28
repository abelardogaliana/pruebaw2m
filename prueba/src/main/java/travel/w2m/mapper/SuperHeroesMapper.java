package travel.w2m.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import travel.w2m.dto.SuperHeroesDto;
import travel.w2m.entity.SuperHeroes;

@Mapper
public interface SuperHeroesMapper {

	SuperHeroesMapper INSTANCE = Mappers.getMapper(SuperHeroesMapper.class);

	SuperHeroesDto heroesToHeroesDto(SuperHeroes hero);
	
	SuperHeroes heroesDtoToHeroes(SuperHeroesDto heroDto);

	List<SuperHeroesDto> map(List<SuperHeroes> heroes);
}
