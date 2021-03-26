package br.com.eletronline.controller;
import java.util.List;
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
import br.com.eletronline.domain.Produto;
import br.com.eletronline.domain.dto.ProdutoDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController("/produto")
@CrossOrigin
@Api(value = "produto-controller",
  produces = MediaType.APPLICATION_JSON_VALUE,
  tags = "produto-controller")
public class ProdutoController {

  @Autowired private ModelMapper modelMapper;

  @Autowired private DeleteCommand deleteCommand;

  @Autowired private FindCommand findCommand;

  @Autowired private SaveCommand saveCommand;

  @Autowired private UpdateCommand updateCommand;

  @GetMapping("/produtos/{produtoId}")
  @ApiOperation(
      value = "Retorna um produto por id",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ProdutoDTO findProdutoById(
      @PathVariable(name = "produtoId") final Long produtoId) {
    final Produto produtoInput = Produto.builder().id(produtoId).build();
    final List<? extends Domain> executar = findCommand.executar(produtoInput);
    return modelMapper.map(executar.get(0), ProdutoDTO.class);
  }

  @PostMapping("/produtos")
  @ApiOperation(
      value = "Realiza a persistencia de um produto",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public String save(@RequestBody final ProdutoDTO produtoDTO) {
    final Produto produtoInput = modelMapper.map(produtoDTO, Produto.class);
    return saveCommand.executar(produtoInput);
  }
  
  @PutMapping("/produtos/{produtoId}")
  @ApiOperation(
      value = "Atualiza as informações de um produto atráves de um id",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public String update(
      @RequestBody final ProdutoDTO produtoDTO,
      @PathVariable(name = "produtoId") final Long produtoId) {
    final Produto produtoInput = modelMapper.map(produtoDTO, Produto.class);
    produtoInput.setId(produtoId);
    return updateCommand.executar(produtoInput);
  }

  @DeleteMapping("/produtos/{produtoId}")
  @ApiOperation(
      value = "Faz a exclusão de um produto por id",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public String delete(@PathVariable(name = "produtoId") final Long produtoId) {
    final Produto produto = Produto.builder().id(produtoId).build();
    return deleteCommand.executar(produto);
  }
  
} 
