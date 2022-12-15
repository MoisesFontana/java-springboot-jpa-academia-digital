package me.dio.academia.digital.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data //-- Anotação do Lombok para não precisar criar os Getters and Setters
@NoArgsConstructor //-- Cria um construtor vazio para o Hibernate não dar erro
@AllArgsConstructor
//-- Anotações da persistencia do banco de dados
@Entity
@Table(name = "tb_matriculas")
public class Matricula {

  @Id //-- Anotação que determina a Primary Key da tabela
  @GeneratedValue(strategy = GenerationType.IDENTITY) //-- Determina a forma de geração do ID, neste caso será auto-increment
  private Long id;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "aluno_id")
  private Aluno aluno;

  private LocalDateTime dataDaMatricula = LocalDateTime.now();
}
