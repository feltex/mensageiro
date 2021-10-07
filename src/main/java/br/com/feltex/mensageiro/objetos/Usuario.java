package br.com.feltex.mensageiro.objetos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Usuario {
    private String nome;
    private String telefone;
    private String email;
}
