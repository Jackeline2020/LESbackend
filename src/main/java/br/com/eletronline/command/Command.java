package br.com.eletronline.command;

import br.com.eletronline.domain.Domain;

public interface Command {

	Object executar(final Domain domain);
}
