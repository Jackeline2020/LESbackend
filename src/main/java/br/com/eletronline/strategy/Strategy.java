package br.com.eletronline.strategy;

import br.com.eletronline.domain.Domain;

public interface Strategy {

  public String processar(final Domain domain);

  public Boolean verificarInstancia(final Domain domain);
}
