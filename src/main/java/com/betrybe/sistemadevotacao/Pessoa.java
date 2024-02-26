package com.betrybe.sistemadevotacao;

/**
 * Classe Pessoa.
 */
public abstract class Pessoa {

  protected String nome;

  /**
   * Setter e Getter.
   */
  public void setNome(String name) {
    this.nome = name;
  }

  public String getNome() {
    return this.nome;
  }

}
