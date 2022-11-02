package travel.w2m.prueba;

import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.test.context.support.WithUserDetails;

import travel.w2m.prueba.dto.SuperHeroesDto;
import travel.w2m.prueba.entity.SuperHeroes;
import travel.w2m.prueba.repository.SuperHeroesRepository;
import travel.w2m.prueba.service.impl.SuperHeroesServiceImpl;

@ExtendWith(MockitoExtension.class)
public class PruebaApplicationTests {

	@InjectMocks
	SuperHeroesServiceImpl superHeroesService;

	@Mock
	SuperHeroesRepository superHeroesRepository;

	@Test
	@WithUserDetails(value = "admin")
	void testAll() {

		List<SuperHeroes> list = new ArrayList<SuperHeroes>();
		SuperHeroes one = new SuperHeroes(1L, LocalDateTime.of(2022, Month.JUNE, 14, 15, 00, 00), "Superman");
		SuperHeroes two = new SuperHeroes(1L, LocalDateTime.of(2022, Month.JUNE, 14, 15, 00, 00), "Superman");
		SuperHeroes three = new SuperHeroes(1L, LocalDateTime.of(2022, Month.JUNE, 14, 15, 00, 00), "Superman");
		SuperHeroes four = new SuperHeroes(1L, LocalDateTime.of(2022, Month.JUNE, 14, 15, 00, 00), "Superman");

		list.add(one);
		list.add(two);
		list.add(three);
		list.add(four);

		when(superHeroesRepository.findAll()).thenReturn(list);

		List<SuperHeroesDto> listHeroes = superHeroesService.findAll();

		System.out.println("testing : ");
		Assert.assertEquals(4, listHeroes.size());

	}

	@Test
	@WithUserDetails(value = "admin")
	void test1() {

		Optional<SuperHeroes> one = Optional.ofNullable(new SuperHeroes(1L, LocalDateTime.of(2022, Month.JUNE, 14, 15, 00, 00), "Superman"));

		when(superHeroesRepository.findById(1L)).thenReturn(one);

		SuperHeroesDto heroDto = superHeroesService.findOne(one.get().getId());

		System.out.println("testing : ");
		Assert.assertEquals(1L, heroDto.getId().longValue());

	}

}
