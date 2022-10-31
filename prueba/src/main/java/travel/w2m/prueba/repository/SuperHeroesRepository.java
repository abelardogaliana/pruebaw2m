package travel.w2m.prueba.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import travel.w2m.prueba.entity.SuperHeroes;


public interface SuperHeroesRepository extends JpaRepository<SuperHeroes, Long> {

	List<SuperHeroes> findByNameContainingIgnoreCase(String name);
}