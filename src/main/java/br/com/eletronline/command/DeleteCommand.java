package br.com.eletronline.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.eletronline.domain.Domain;
import br.com.eletronline.facade.Fachada;

@Component
public class DeleteCommand implements Command {

  @Autowired private Fachada fachada;

  @Override
  public Object executar(final Domain domain) {
    return fachada.delete(domain);
  }

}
