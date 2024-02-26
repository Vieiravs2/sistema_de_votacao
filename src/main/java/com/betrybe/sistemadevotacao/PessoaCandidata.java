package com.betrybe.sistemadevotacao;

/**
 * Classe Pessoa Candidata.
 */
public class PessoaCandidata extends Pessoa {
  int numero;
  int votos;

  /**
   * Inicial.
   */
  public PessoaCandidata(String nome, int numero) {
    this.nome = nome;
    this.numero = numero;
    this.votos = 0;
  }

  /**
   * setNumero.
   */

  public void setNumero(int numero) {
    this.numero = numero;
  }

  /**
   * Setters e Getters.
   */
  public void setVotos(int votos) {
    this.votos = votos;
  }

  public int getNumero() {
    return numero;
  }


  public int getVotos() {
    return votos;
  }

  public void receberVoto() {
    this.votos = this.votos + 1;
  }

  public String getNome() {
    return super.getNome();
  }

  public void setNome(String nome) {
    super.setNome(nome);
  }
}
