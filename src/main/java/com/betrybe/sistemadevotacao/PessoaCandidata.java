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
    if (nome.isEmpty()) {
      throw new IllegalArgumentException("O nome não pode ser nulo ou vazio.");
    }

    if (numero <= 0) {
      throw new IllegalArgumentException("O número deve ser um valor positivo.");
    }

    this.nome = nome;
    this.numero = numero;
    this.votos = 0;
  }

  /**
   * setNumero.
   */

  public void setNumero(int numero) {
    if (numero <= 0) {
      throw new IllegalArgumentException("O número deve ser um valor positivo.");
    }

    this.numero = numero;
  }

  /**
   * Setters e Getters.
   */
  public void setVotos(int votos) {
    if (votos < 0) {
      throw new IllegalArgumentException("O número de votos não pode ser negativo.");
    }

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
}
