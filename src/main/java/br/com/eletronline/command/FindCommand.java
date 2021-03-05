package br.com.eletronline.command;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.eletronline.domain.Domain;
import br.com.eletronline.facade.Fachada;

@Component
public class FindCommand implements Command {

  @Autowired private Fachada fachada;

  @Override
  public List<? extends Domain> executar(final Domain domain) {
    return fachada.find(domain);
  }

}
