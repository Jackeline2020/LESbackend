package br.com.eletronline.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.eletronline.command.DeleteCommand;
import br.com.eletronline.command.FindCommand;
import br.com.eletronline.command.SaveCommand;
import br.com.eletronline.command.UpdateCommand;
import br.com.eletronline.domain.Cliente;
import br.com.eletronline.domain.Domain;
import br.com.eletronline.domain.dto.ClienteCadastroDTO;
import br.com.eletronline.domain.dto.ClienteDTO;
import br.com.eletronline.domain.dto.ClienteUpdateDTO;
import br.com.eletronline.strategy.PermiteTrocaSenha;
import br.com.eletronline.util.CompararSenha;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController("/cliente")
@CrossOrigin
@Api(value = "cliente-controller",
  produces = MediaType.APPLICATION_JSON_VALUE,
  tags = "cliente-controller")
public class ClienteController {

  @Autowired private ModelMapper modelMapper;

  @Autowired private PermiteTrocaSenha verificarTrocaSenha;

  @Autowired private CompararSenha compararSenha;

  @Autowired private DeleteCommand deleteCommand;

  @Autowired private FindCommand findCommand;

  @Autowired private SaveCommand saveCommand;

  @Autowired private UpdateCommand updateCommand;

  @GetMapping("/clientes/{clienteId}")
  @ApiOperation(
      value = "Retorna um cliente por id",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ClienteDTO findById(@PathVariable(name = "clienteId") final Long clienteId) {
    final Cliente clienteInput = new Cliente();
    clienteInput.setId(clienteId);
    final List<? extends Domain> executar = findCommand.executar(clienteInput);
    return modelMapper.map(executar.get(0), ClienteDTO.class);
  }

  @GetMapping("/clientes")
  @ApiOperation(
      value = "Retorna uma lista de todos os clientes cadastrados",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public List<ClienteDTO> findAll() {
    final Cliente clienteInput = new Cliente();
    return findCommand.executar(clienteInput)
        .stream().map(cliente -> modelMapper.map(cliente, ClienteDTO.class))
        .collect(Collectors.toList());
  }

  @PostMapping("/clientes")
  @ApiOperation(
      value = "Realiza a persistencia de um cliente",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public String save(@RequestBody final ClienteCadastroDTO clienteDTO) {
    final Cliente clienteInput = modelMapper.map(clienteDTO, Cliente.class);
    return saveCommand.executar(clienteInput);
  }

  @PutMapping("/clientes")
  @ApiOperation(
      value = "Atualiza as informações de um cliente atráves de um id",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public String update(
      @RequestBody final ClienteUpdateDTO clienteDTO) {
    final Cliente clienteInput = modelMapper.map(clienteDTO, Cliente.class);
    return updateCommand.executar(clienteInput);
  }

  @DeleteMapping("/clientes/{clienteId}")
  @ApiOperation(
      value = "Faz a exclusão de um cliente por id",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public String delete(@PathVariable(name = "clienteId") final Long clienteId) {
    final Cliente cliente = Cliente.builder().id(clienteId).build();
    return deleteCommand.executar(cliente);
  }

  @PostMapping("/clientes/{clienteId}/senha/permitirTroca")
  @ApiOperation(
      value = "Verifica se a senha digitada corresponde com a atual para permitir a troca",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public String permitirTrocarSenha(
      @PathVariable(name = "clienteId") final Long clienteId,
      @RequestParam final String senhaAtual) {
    return verificarTrocaSenha.permiteTrocaSenha(senhaAtual, clienteId);
  }

  @PostMapping("/clientes/senha/comparar")
  @ApiOperation(
      value = "Faz a comparação de duas senhas",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public String compararSenhas(
      @RequestParam final String senha,
      @RequestParam final String confirmaSenha) {
    return compararSenha.comparar(senha, confirmaSenha);
  }
}
