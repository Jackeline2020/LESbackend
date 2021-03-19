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
import org.springframework.web.bind.annotation.RestController;
import br.com.eletronline.command.DeleteCommand;
import br.com.eletronline.command.FindCommand;
import br.com.eletronline.command.SaveCommand;
import br.com.eletronline.command.UpdateCommand;
import br.com.eletronline.domain.Cliente;
import br.com.eletronline.domain.Domain;
import br.com.eletronline.domain.Telefone;
import br.com.eletronline.domain.dto.TelefoneDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController("/telefone")
@CrossOrigin
@Api(value = "telefone-controller",
  produces = MediaType.APPLICATION_JSON_VALUE,
  tags = "telefone-controller")
public class TelefoneController {

  @Autowired private ModelMapper modelMapper;

  @Autowired private DeleteCommand deleteCommand;

  @Autowired private FindCommand findCommand;

  @Autowired private SaveCommand saveCommand;

  @Autowired private UpdateCommand updateCommand;

  @GetMapping("/telefones/{telefoneId}")
  @ApiOperation(
      value = "Retorna um telefone por id",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public TelefoneDTO findTelefoneById(
      @PathVariable(name = "telefoneId") final Long telefoneId) {
    final Telefone telefoneInput = Telefone.builder().id(telefoneId).build();
    final List<? extends Domain> executar = findCommand.executar(telefoneInput);
    return modelMapper.map(executar.get(0), TelefoneDTO.class);
  }

  @PostMapping("/telefones/clientes/{clienteId}")
  @ApiOperation(
      value = "Realiza a persistencia de um telefone",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public String save(
      @PathVariable(name = "clienteId") final Long clienteId,
      @RequestBody final TelefoneDTO telefoneDTO) {
    final Telefone telefoneInput = modelMapper.map(telefoneDTO, Telefone.class);
    final Cliente cliente = Cliente.builder().id(clienteId).build();
    telefoneInput.setCliente(cliente);
    return saveCommand.executar(telefoneInput);
  }

  @PutMapping("/telefones/{telefoneId}")
  @ApiOperation(
      value = "Atualiza as informações de um telefone atráves de um id",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public String update(
      @RequestBody final TelefoneDTO telefoneDTO,
      @PathVariable(name = "telefoneId") final Long telefoneId) {
    final Telefone telefoneInput = modelMapper.map(telefoneDTO, Telefone.class);
    telefoneInput.setId(telefoneId);
    return updateCommand.executar(telefoneInput);
  }

  @DeleteMapping("/telefones/{telefoneId}")
  @ApiOperation(
      value = "Faz a exclusão de um telefone por id",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public String delete(@PathVariable(name = "telefoneId") final Long telefoneId) {
    final Telefone telefone = Telefone.builder().id(telefoneId).build();
    return deleteCommand.executar(telefone);
  }

  @GetMapping("clientes/{clienteId}/telefones")
  @ApiOperation(
      value = "Retorna uma lista de telefones de um cliente por id",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public List<TelefoneDTO> findTelefonesByPessoaId(
      @PathVariable(name = "clienteId") final Long clienteId) {
    final Cliente clienteInput = Cliente.builder().id(clienteId).build();
    final Cliente clienteEncontrado = (Cliente) findCommand.executar(clienteInput).get(0);
    return clienteEncontrado.getTelefones()
        .stream().map(telefone -> modelMapper.map(telefone, TelefoneDTO.class))
        .collect(Collectors.toList());
  }
} 
