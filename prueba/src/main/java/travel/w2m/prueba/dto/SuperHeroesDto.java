package travel.w2m.prueba.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SuperHeroesDto {

	private Long id;
	private String name;
	private LocalDateTime created_date;

}