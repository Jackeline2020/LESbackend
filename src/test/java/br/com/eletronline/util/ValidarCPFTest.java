package br.com.eletronline.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class ValidarCPFTest {

  private ValidarCPF validarCPF = new ValidarCPF();

  @Test
  public void deveriaRetornarMensagemParaCPFNulo() {
    final String expected = "O campo de CPF não pode estar vazio!";

    final String actual = validarCPF.validar(null);
    assertEquals(expected, actual);
  }

  @Test
  public void deveriaRetornarMensagemParaCPFVazio() {
    final String expected = "O campo de CPF não pode estar vazio!";

    final String actual = validarCPF.validar("");
    assertEquals(expected, actual);
  }

  @Test
  public void deveriaRetornarMensagemParaCPFInvalido() {
    final String expected = "CPF inválido!";

    final String actual = validarCPF.validar("123.232.321-23");
    assertEquals(expected, actual);
  }

  @Test
  public void deveriaRetornarNullParaCPFValido() {
    final String expected = null;

    final String actual = validarCPF.validar("676.732.150-80");
    assertEquals(expected, actual);
  }
}
