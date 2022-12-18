package br.edu.infnet.catalogo.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 60, nullable = false, unique = true)
	private String nome;

	@ManyToOne
	@JoinColumn(name = "catagoria_id")
	private Categoria categoria;

	@ManyToOne
	@JoinColumn(name = "medida_id")
	private Medida medida;

	@Column(nullable = false)
	private Double valor;
}
