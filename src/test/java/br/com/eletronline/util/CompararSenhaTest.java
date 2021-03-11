package br.com.eletronline.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class CompararSenhaTest {

  private CompararSenha compararSenha = new CompararSenha();

  @Test
  public void deveriaRetornarNullParaSenhasIguais() {
    final String senha = "12345";
    final String confirmaSenha = "12345";
    final String expected = null;

    final String actual = compararSenha.comparar(senha, confirmaSenha);
    assertEquals(expected, actual);
  }

  @Test
  public void deveriaRetornarMensagemDeErroParaParametroNulo() {
    final String senha = "12345";
    final String confirmaSenha = null;
    final String expected = "O campo de Senha e Confirma Senha não podem estar vazios!";

    final String actual = compararSenha.comparar(senha, confirmaSenha);
    assertEquals(expected, actual);
  }

  @Test
  public void deveriaRetornarMensagemDeErroParaParametroVazio() {
    final String senha = "12345";
    final String confirmaSenha = "";
    final String expected = "O campo de Senha e Confirma Senha não podem estar vazios!";

    final String actual = compararSenha.comparar(senha, confirmaSenha);
    assertEquals(expected, actual);
  }

  @Test
  public void deveriaRetornarMensagemDeErroParaSenhasDiferentes() {
    final String senha = "12345";
    final String confirmaSenha = "1234";
    final String expected = "As senhas não correspondem!";

    final String actual = compararSenha.comparar(senha, confirmaSenha);
    assertEquals(expected, actual);
  }
}
