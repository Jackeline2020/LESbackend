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
import br.com.eletronline.domain.Documento;
import br.com.eletronline.domain.dto.DocumentoDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController("/documento")
@CrossOrigin
@Api(value = "documento-controller",
  produces = MediaType.APPLICATION_JSON_VALUE,
  tags = "documento-controller")
public class DocumentoController {

  @Autowired private ModelMapper modelMapper;

  @Autowired private DeleteCommand deleteCommand;

  @Autowired private FindCommand findCommand;

  @Autowired private SaveCommand saveCommand;

  @Autowired private UpdateCommand updateCommand;

  @PostMapping("clientes/{clienteId}/documentos")
  @ApiOperation(
      value = "Realiza a persistencia de um documento para um cliente",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public String save(
      @PathVariable("clienteId") final Long clienteId,
      @RequestBody final DocumentoDTO documentoDTO) {
    final Documento documentoInput = modelMapper.map(documentoDTO, Documento.class);
    final Cliente cliente = Cliente.builder().id(clienteId).build();
    documentoInput.setCliente(cliente);
    return saveCommand.executar(documentoInput);
  }

  @GetMapping("clientes/{clienteId}/documentos")
  @ApiOperation(
      value = "Retorna uma lista de endereços de um cliente por id",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public List<DocumentoDTO> findDocumentosByClienteId(
      @PathVariable(name = "clienteId") final Long clienteId) {
    final Cliente clienteInput = Cliente.builder().id(clienteId).build();
    final Cliente clienteEncontrado = (Cliente) findCommand.executar(clienteInput).get(0);
    return clienteEncontrado.getDocumentos()
        .stream().map(documento -> modelMapper.map(documento, DocumentoDTO.class))
        .collect(Collectors.toList());
  }

  @PutMapping("clientes/{clienteId}/documentos")
  @ApiOperation(
      value = "Atualiza os dados de um documento para um cliente",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public String update(
      @PathVariable("clienteId") final Long clienteId,
      @RequestBody final DocumentoDTO documentoDTO) {
    final Documento documentoInput = modelMapper.map(documentoDTO, Documento.class);
    final Cliente cliente = Cliente.builder().id(clienteId).build();
    documentoInput.setCliente(cliente);
    return updateCommand.executar(documentoInput);
  }

  @DeleteMapping("/clientes/documentos")
  @ApiOperation(
      value = "Faz a exclusão de um documento por id",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public String delete(@RequestParam("documentoId") final Long documentoId) {
    final Documento documento = Documento.builder().id(documentoId).build();
    return deleteCommand.executar(documento);
  }
}
