package br.com.eletronline.util;

import static com.google.common.base.Strings.isNullOrEmpty;
import org.springframework.stereotype.Component;

@Component
public class ValidarCPF {

  public String validar(final String cpf) {
    if (!isNullOrEmpty(cpf)) {
      return validarNumerosCpf(getNumeros(cpf));
    }
    return "O campo de CPF não pode estar vazio!";
  }

  private String getNumeros(final String cpf) {
    return cpf.replaceAll("\\D", "");
  }

  private String validarNumerosCpf(final String numerosCpf) {
    if (!verificarEmPadroes(numerosCpf)) {
      if (validarPrimeiroDigito(numerosCpf)) {
        if (validarSegundoDigito(numerosCpf)) {
          return null;
        }
      }
    }
    return "CPF inválido!";
  }

  private Boolean validarPrimeiroDigito(final String numerosCpf) {
    int soma = 0, resultado, digito, peso = 10;
    for (int posicaoDigito = 0; posicaoDigito < 9; posicaoDigito++) {
      digito = (int) (numerosCpf.charAt(posicaoDigito) - 48);
      soma = soma + (digito * peso);
      peso--;
    }
    resultado = 11 - (soma % 11);
    return obterDigitoVerificador(resultado) == numerosCpf.charAt(9);
  }

  private Boolean validarSegundoDigito(final String numerosCpf) {
    int soma = 0, resultado, digito, peso = 11;
    for (int posicaoDigito = 0; posicaoDigito < 10; posicaoDigito++) {
      digito = (int) (numerosCpf.charAt(posicaoDigito) - 48);
      soma = soma + (digito * peso);
      peso--;
    }
    resultado = 11 - (soma % 11);
    return obterDigitoVerificador(resultado) == numerosCpf.charAt(10);
  }

  private char obterDigitoVerificador(int resultado) {
    return (resultado == 10) || (resultado == 11) ? '0' : (char) (resultado + 48);
  }

  private Boolean verificarEmPadroes(final String numerosCpf) {
    return numerosCpf.equals("00000000000") || numerosCpf.equals("11111111111")
        || numerosCpf.equals("22222222222") || numerosCpf.equals("33333333333")
        || numerosCpf.equals("44444444444") || numerosCpf.equals("55555555555")
        || numerosCpf.equals("66666666666") || numerosCpf.equals("77777777777")
        || numerosCpf.equals("88888888888") || numerosCpf.equals("99999999999")
        || (numerosCpf.length() != 11);
  }
}
