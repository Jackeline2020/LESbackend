package br.com.eletronline.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.eletronline.domain.Domain;
import br.com.eletronline.facade.Fachada;

@Component
public class SaveCommand implements Command {

  @Autowired private Fachada fachada;

  @Override
  public String executar(final Domain domain) {
    return fachada.save(domain);
  }

}
