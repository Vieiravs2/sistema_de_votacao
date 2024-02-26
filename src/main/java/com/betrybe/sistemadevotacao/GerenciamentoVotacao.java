package com.betrybe.sistemadevotacao;

import java.util.ArrayList;

/**
 * Classe Gerenciamento de Votação.
 */

public class GerenciamentoVotacao implements GerenciamentoVotacaoInterface {
  private ArrayList<PessoaCandidata> pessoasCandidatas;
  private ArrayList<PessoaEleitora> pessoasEleitoras;
  private ArrayList<String> cpfsComputados;

  /**
   * Constructor.
   */
  public GerenciamentoVotacao() {
    this.pessoasCandidatas = new ArrayList<>();
    this.pessoasEleitoras = new ArrayList<>();
    this.cpfsComputados = new ArrayList<>();
  }


  /**
   * Cadastra a pessoa candidata.
   */
  public void cadastrarPessoaCandidata(String nome, int numero) {
    boolean pessoaCandidataExiste = false;

    for (PessoaCandidata pessoaCandidata : this.pessoasCandidatas) {
      if (pessoaCandidata.getNumero() == numero) {
        pessoaCandidataExiste = true;
        break;
      }
    }

    if (pessoaCandidataExiste) {
      System.out.println("Número da pessoa candidata já utilizado!");
    } else {
      PessoaCandidata novaPessoaCandidata = new PessoaCandidata(nome, numero);
      this.pessoasCandidatas.add(novaPessoaCandidata);
    }
  }

  /**
   * Cadastra a pessoa eleitora.
   */

  public void cadastrarPessoaEleitora(String nome, String cpf) {
    boolean pessoaEleitoraExiste = false;

    for (PessoaEleitora pessoaEleitora : this.pessoasEleitoras) {
      if (pessoaEleitora.getCpf().equals(cpf)) {
        pessoaEleitoraExiste = true;
        break;
      }
    }

    if (pessoaEleitoraExiste) {
      System.out.println("Pessoa eleitora já cadastrada!");
    } else {
      PessoaEleitora pessoaEleitora = new PessoaEleitora(nome, cpf);
      this.pessoasEleitoras.add(pessoaEleitora);
    }
  }

  /**
   * Lança o voto.
   */

  @Override
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {
    if (!cpfsComputados.isEmpty()) {
      for (String cpf : cpfsComputados) {
        if (cpf.equals(cpfPessoaEleitora)) {
          System.out.println("Pessoa eleitora já votou!");
          return;
        }
      }
    }
    cpfsComputados.add(cpfPessoaEleitora);
    for (PessoaCandidata pessoa : pessoasCandidatas) {
      if (pessoa.getNumero() == numeroPessoaCandidata) {
        pessoa.receberVoto();
      }
    }
  }

  /**
   * Mostra o resultado final.
   */

  @Override
  public void mostrarResultado() {
    if (cpfsComputados.isEmpty()) {
      System.out.println("É preciso ter pelo menos um "
          + " voto para mostrar o resultado");
      return;
    }
    int total = cpfsComputados.size();
    for (PessoaCandidata candidata : pessoasCandidatas) {
      System.out.printf("Nome: %s - %d votos ( %d%% )%n",
          candidata.getNome(),
          candidata.getVotos(),
          Math.round((float) candidata.getVotos() / total * 100)
      );
    }
    System.out.printf("Total de votos: %d%n", total);
  }
}