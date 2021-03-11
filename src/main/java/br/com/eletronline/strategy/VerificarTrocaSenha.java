package br.com.eletronline.strategy;

import static java.util.Objects.nonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import br.com.eletronline.dao.ClienteDAO;
import br.com.eletronline.domain.Cliente;
import br.com.eletronline.util.CriptografarSenha;

@Component
public class VerificarTrocaSenha {

  @Autowired private ClienteDAO clienteDAO;

  @Autowired private CriptografarSenha criptografarSenha;

  public String verificarTrocaSenha(final String senhaNova, final Long clienteId) {
    final Cliente cliente = clienteDAO.findById(clienteId);
    if (nonNull(cliente)) {
      final String senhaNovaCriptografada = criptografarSenha.criptografar(senhaNova);
      if (cliente.getSenha().equals(senhaNovaCriptografada)) {
        return null;
      } else {
        return "A senha digitada não corresponde!";
      }
    } else {
      return "Cliente não entrado para id: " + clienteId;
    }
  }
}
