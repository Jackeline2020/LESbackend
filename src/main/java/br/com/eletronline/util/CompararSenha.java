package br.com.eletronline.util;

import static com.google.common.base.Strings.isNullOrEmpty;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

@Component
public class CompararSenha {

  public String comparar(final String senha, final String confirmaSenha) {
    if (isNullOrEmpty(senha) || isNullOrEmpty(confirmaSenha)) {
      return "O campo de Senha e Confirma Senha não podem estar vazios!";
    }
    final String senhaCriptografada = DigestUtils.md5Hex(senha).toUpperCase().toString();
    final String confirmaSenhaCriptografada = DigestUtils.md5Hex(confirmaSenha).toUpperCase().toString();
    if (senhaCriptografada.equals(confirmaSenhaCriptografada)) {
      return null;
    } else {
      return "As senhas não correspondem!";
    }
  }
}
