package br.com.eletronline.strategy;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import br.com.eletronline.dao.DocumentoDAO;
import br.com.eletronline.domain.Documento;
import br.com.eletronline.domain.Domain;
import br.com.eletronline.util.ValidarCPF;

@Component
public class ValidarExistenciaCPF implements Strategy {

  @Autowired private DocumentoDAO documentoDAO;

  @Autowired private ValidarCPF validarCPF;

  @Override
  public String processar(final Domain domain) {
    if (verificarInstancia(domain)) {
      final Documento documento = (Documento) domain;
      return verificarDocumento(documento);
    }
    return "Erro interno do sistema!";
  }

  @Override
  public Boolean verificarInstancia(final Domain domain) {
    return domain instanceof Documento;
  }

  private String verificarDocumento(final Documento documento) {
    final Optional<Documento> documentoBusca = documentoDAO.findDocumentoByNumero(documento.getNumero());
    if (documentoBusca.isEmpty()) {
      return validarCPF.validar(documento.getNumero());
    } else {
      return "O CPF digitado está indisponível!";
    }
  }

}
