package travel.w2m.prueba.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SuperHeroesDto {

	@NotBlank
	private Long id;
	@NotBlank
	private String name;
	@NotBlank
	private LocalDateTime createdDate;

}