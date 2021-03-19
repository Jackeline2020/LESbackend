package br.com.eletronline.domain;

public enum EnderecoType {
  ENTREGA("ENTREGA"),
  COBRANCA("COBRANÇA");

  public String tipoEndereco;

  EnderecoType(final String tipo) {
    tipoEndereco = tipo;
  }
}
