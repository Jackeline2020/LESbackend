package br.com.eletronline.domain;

public enum TipoEntrega {
  RETIRADA_EM_MAOS("RETIRADA EM MÃOS"),
  SEDEX("SEDEX"),
  TRANSPORTADORA("TRANSPORTADORA");

  public String tipoEntrega;

  TipoEntrega(final String tipo) {
    tipoEntrega = tipo;
  }
}
