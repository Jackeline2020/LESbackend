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
import br.com.eletronline.domain.Domain;
import br.com.eletronline.domain.Endereco;
import br.com.eletronline.domain.dto.EnderecoDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController("/endereco")
@CrossOrigin
@Api(value = "endereco-controller",
  produces = MediaType.APPLICATION_JSON_VALUE,
  tags = "endereco-controller")
public class EnderecoController {

  @Autowired private ModelMapper modelMapper;

  @Autowired private DeleteCommand deleteCommand;

  @Autowired private FindCommand findCommand;

  @Autowired private SaveCommand saveCommand;

  @Autowired private UpdateCommand updateCommand;

  @GetMapping("/enderecos/{enderecoId}")
  @ApiOperation(
      value = "Retorna um endereço por id",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public EnderecoDTO findEnderecoById(
      @PathVariable(name = "enderecoId") final Long enderecoId) {
    final Endereco enderecoInput = Endereco.builder().id(enderecoId).build();
    final List<? extends Domain> executar = findCommand.executar(enderecoInput);
    return modelMapper.map(executar.get(0), EnderecoDTO.class);
  }

  @PostMapping("/enderecos")
  @ApiOperation(
      value = "Realiza a persistencia de um endereco",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public String save(@RequestBody final EnderecoDTO enderecoDTO) {
    final Endereco enderecoInput = modelMapper.map(enderecoDTO, Endereco.class);
    return saveCommand.executar(enderecoInput);
  }

  @PutMapping("/enderecos/{enderecoId}")
  @ApiOperation(
      value = "Atualiza as informações de um endereco atráves de um id",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public String update(
      @RequestBody final EnderecoDTO enderecoDTO,
      @PathVariable(name = "enderecoId") final Long enderecoId) {
    final Endereco enderecoInput = modelMapper.map(enderecoDTO, Endereco.class);
    enderecoInput.setId(enderecoId);
    return updateCommand.executar(enderecoInput);
  }

  @DeleteMapping("/enderecos/{enderecoId}")
  @ApiOperation(
      value = "Faz a exclusão de um endereco por id",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public String delete(@PathVariable(name = "enderecoId") final Long enderecoId) {
    final Endereco endereco = Endereco.builder().id(enderecoId).build();
    return deleteCommand.executar(endereco);
  }

  @GetMapping("clientes/{cliente}/enderecos")
  @ApiOperation(
      value = "Retorna uma lista de endereços de um cliente por id",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public List<EnderecoDTO> findEnderecosByClienteId(
      @PathVariable(name = "clienteId") final Long clienteId) {
    final Endereco enderecoInput = Endereco.builder().clienteId(clienteId).build();
    return findCommand.executar(enderecoInput)
        .stream().map(endereco -> modelMapper.map(endereco, EnderecoDTO.class))
        .collect(Collectors.toList());
  }
}
