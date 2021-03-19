package br.com.eletronline.domain;

public enum DocumentoType {
  CPF("CPF"),
  CNPJ("CNPJ"),
  RG("RG");

  public String tipoDocumento;

  DocumentoType(final String tipo) {
    tipoDocumento = tipo;
  }

  String getValue() {
    return tipoDocumento;
  }
}
