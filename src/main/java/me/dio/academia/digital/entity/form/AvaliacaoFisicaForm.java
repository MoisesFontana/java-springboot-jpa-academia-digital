package me.dio.academia.digital.entity.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvaliacaoFisicaForm {

  @Positive(message = "O ID do aluno precisa ser positivo.")
  private Long alunoId;

  @NotNull(message = "Preencha o campo PESO corretamente.")
  @Positive(message = "'${validatedValue}' precisa ser positivo.")
  private double peso;

  @NotNull(message = "Preencha o campo ALTURA corretamente.")
  @Positive(message = "'${validatedValue}' precisa ser positivo.")
  @DecimalMin(value = "140", message = "'${validatedValue}' precisa ser pno mínimo {value}.")
  private double altura;
}
