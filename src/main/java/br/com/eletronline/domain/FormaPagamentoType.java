package br.com.eletronline.domain;

public enum FormaPagamentoType {
  CARTAO_CREDITO("CARTÃO DE CRÉDITO"), 
  CARTAO_DEBITO("CARTÃO DE DÉBITO"),
  BOLETO("BOLETO");

  public String formaPagamento;

  FormaPagamentoType(final String pagamento) {
    formaPagamento = pagamento;
  }
}
