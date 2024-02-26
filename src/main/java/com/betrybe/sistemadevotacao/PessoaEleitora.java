package com.betrybe.sistemadevotacao;

/**
 * Classe Pessoa Eleitora.
 */
public class PessoaEleitora extends Pessoa {

  private String cpf;

  public PessoaEleitora(String nome, String cpf) {
    super.nome = nome;
    this.cpf = cpf;
  }

  /**
   * Getter do CPF.
   */
  public String getCpf() {
    return cpf;
  }

  /**
   * Setter do CPF.
   */
  public void setCpf(String cpf) {
    if (cpf.isEmpty()) {
      throw new IllegalArgumentException("CPF Inválido.");
    }

    this.cpf = cpf;
  }

  public String getNome() {
    return super.getNome();
  }

  public void setNome(String nome) {
    super.setNome(nome);
  }
}
