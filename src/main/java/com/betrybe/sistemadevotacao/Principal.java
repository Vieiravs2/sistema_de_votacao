package com.betrybe.sistemadevotacao;

import java.util.Scanner;

/**
 * Classe Principal.
 */
public class Principal {

  GerenciamentoVotacao gerenciamentoVotacao = new GerenciamentoVotacao();
  Scanner scanner = new Scanner(System.in);
  int votos = 0;

  /**
   * Main.
   */
  public static void main(String[] args) {
    Principal principal = new Principal();
    principal.candidato();
  }

  /**
   * Candidato.
   */
  private void candidato() {
    System.out.println("Cadastrar pessoa candidata?");
    System.out.println("1 - Sim");
    System.out.println("2 - Não");
    System.out.println("Entre com o número correspondente à opção desejada:");
    String option = scanner.nextLine();
    if (option.equals("1")) {
      System.out.println("Entre com o nome da pessoa candidata:");
      String nome = scanner.nextLine();
      System.out.println("Entre com o número da pessoa candidata:");
      String numeroInput = scanner.nextLine();
      int numero = Integer.parseInt(numeroInput);
      gerenciamentoVotacao.cadastrarPessoaCandidata(nome, numero);
      candidato();
    } else {
      eleitor();
    }
  }


  /**
   * Eleitor.
   */
  private void eleitor() {
    System.out.println("Cadastrar pessoa eleitora?");
    System.out.println("1 - Sim");
    System.out.println("2 - Não");
    System.out.println("Entre com o número correspondente à opção desejada:");
    String option = scanner.nextLine();
    if (option.equals("1")) {
      System.out.println("Entre com o nome da pessoa eleitora:");
      String nome = scanner.nextLine();
      System.out.println("Entre com o cpf da pessoa eleitora:");
      String cpf = scanner.nextLine();
      gerenciamentoVotacao.cadastrarPessoaEleitora(nome, cpf);
      eleitor();
    } else {
      votacao();
    }
  }

  /**
   * Votação.
   */
  private void votacao() {
    System.out.println("Entre com o número correspondente à opção desejada:");
    System.out.println("1 - Votar");
    System.out.println("2 - Resultado Parcial");
    System.out.println("3 - Finalizar Votação");
    String option = scanner.nextLine();
    if (option.equals("1")) {
      System.out.println("Entre com o cpf da pessoa eleitora:");
      String cpf = scanner.nextLine();
      System.out.println("Entre com o número da pessoa candidata:");
      String numeroInput = scanner.nextLine();
      int numero = Integer.parseInt(numeroInput);
      gerenciamentoVotacao.votar(cpf, numero);
      votos++;
      votacao();
    } else if (option.equals("2")) {
      gerenciamentoVotacao.mostrarResultado();
      votacao();
    } else {
      gerenciamentoVotacao.mostrarResultado();
      if (votos == 0) {
        votacao();
      }
    }
  }
}
