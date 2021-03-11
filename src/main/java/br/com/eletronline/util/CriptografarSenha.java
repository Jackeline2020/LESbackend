package br.com.eletronline.util;

import static com.google.common.base.Strings.isNullOrEmpty;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

@Component
public class CriptografarSenha {

  public String criptografar(final String senha) {
    if (isNullOrEmpty(senha)) {
      return "Erro interno do sistema!";
    }
    return DigestUtils.md5Hex(senha).toUpperCase().toString();
  }
}
