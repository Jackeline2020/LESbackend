package br.com.eletronline.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.eletronline.domain.Cliente;
import br.com.eletronline.domain.dto.UserDTO;
import br.com.eletronline.strategy.ValidarLogin;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController("/login")
@CrossOrigin
@Api(value = "login-controller",
  produces = MediaType.APPLICATION_JSON_VALUE,
  tags = "login-controller")
public class LoginController {

  @Autowired private ModelMapper modelMapper;

  @Autowired private ValidarLogin validarLogin;

  @PostMapping("/login")
  @ApiOperation(
      value = "Avalia dados de entrada de um usuário e retorna o id",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public String login(@RequestBody final UserDTO user) {
    final Cliente cliente = modelMapper.map(user, Cliente.class);
    return validarLogin.processar(cliente);
  }
}
