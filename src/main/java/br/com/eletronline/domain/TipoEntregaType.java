package br.com.eletronline.domain;

public enum TipoEntregaType {
  RETIRADA_EM_MAOS("RETIRADA EM MÃOS"),
  SEDEX("SEDEX"),
  TRANSPORTADORA("TRANSPORTADORA");

  public String tipoEntrega;

  TipoEntregaType(final String tipo) {
    tipoEntrega = tipo;
  }
}
