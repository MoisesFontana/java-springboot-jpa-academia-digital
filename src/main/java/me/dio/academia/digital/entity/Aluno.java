package me.dio.academia.digital.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data //-- Anotação do Lombok para não precisar criar os Getters and Setters
@NoArgsConstructor //-- Cria um construtor vazio para o Hibernate não dar erro
@AllArgsConstructor
//-- Anotações da persistencia do banco de dados
@Entity
@Table(name = "tb_alunos")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Aluno {

  @Id //-- Anotação que determina a Primary Key da tabela
  @GeneratedValue(strategy = GenerationType.IDENTITY) //-- Determina a forma de geração do ID, neste caso será auto-increment
  private Long id;

  private String nome;

  @Column(unique = true)
  private String cpf;

  private String bairro;

  private LocalDate dataDeNascimento;

  @OneToMany(mappedBy = "aluno", fetch = FetchType.LAZY)
  @JsonIgnore
  private List<AvaliacaoFisica> avaliacoes = new ArrayList<>();

}
