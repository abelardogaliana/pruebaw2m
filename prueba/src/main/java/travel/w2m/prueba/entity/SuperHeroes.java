package travel.w2m.prueba.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "SUPERHEROES")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SuperHeroes {

	private @Id @GeneratedValue Long id;
	@Column(name = "created_date")
	private LocalDateTime createdDate;
	@Column(name = "name")
	private String name;
	

}