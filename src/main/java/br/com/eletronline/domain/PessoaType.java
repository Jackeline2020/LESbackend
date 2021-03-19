package br.com.eletronline.domain;

public enum PessoaType {
  CLIENTE("CLIENTE"),
  FUNCIONARIO("FUNCIONARIO");

  public String tipoPessoa;

  PessoaType(final String tipo) {
    tipoPessoa = tipo;
  }

}
