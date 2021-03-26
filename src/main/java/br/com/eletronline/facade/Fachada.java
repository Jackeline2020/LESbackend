package br.com.eletronline.facade;

import static com.google.common.base.Strings.isNullOrEmpty;
import static java.util.Objects.nonNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import br.com.eletronline.dao.DAO;
import br.com.eletronline.dao.ClienteDAO;
import br.com.eletronline.dao.DocumentoDAO;
import br.com.eletronline.dao.EnderecoDAO;
import br.com.eletronline.dao.TelefoneDAO;
import br.com.eletronline.dao.ProdutoDAO;
import br.com.eletronline.domain.Domain;
import br.com.eletronline.domain.Cliente;
import br.com.eletronline.domain.Documento;
import br.com.eletronline.domain.Endereco;
import br.com.eletronline.domain.Telefone;
import br.com.eletronline.domain.Produto;
import br.com.eletronline.strategy.Strategy;
import br.com.eletronline.strategy.ValidarExistenciaCPF;
import br.com.eletronline.strategy.ValidarExistenciaClienteEmail;

@Component
public class Fachada {

  @Autowired
  private ClienteDAO clienteDAO;

  @Autowired
  private DocumentoDAO documentoDAO;

  @Autowired
  private EnderecoDAO enderecoDAO;

  @Autowired
  private TelefoneDAO telefoneDAO;

  @Autowired
  private ProdutoDAO produtoDAO;
  
  @Autowired
  private ValidarExistenciaCPF validarExistenciaCPF;

  @Autowired
  private ValidarExistenciaClienteEmail validarExistenciaClienteEmail;

  protected Map<String, DAO> allDao;

  protected Map<String, List<Strategy>> allStrategy;

  private void configMaps() {
    allDao = loadDao();
    allStrategy = loadStrategy();
  }

  public Map<String, DAO> loadDao() {
    final Map<String, DAO> daos = new HashMap<>();
    daos.put(Cliente.class.getName(), clienteDAO);
    daos.put(Documento.class.getName(), documentoDAO);
    daos.put(Endereco.class.getName(), enderecoDAO);
    daos.put(Telefone.class.getName(), telefoneDAO);
    daos.put(Produto.class.getName(), produtoDAO);
    return daos;
  }

  public Map<String, List<Strategy>> loadStrategy() {
    final Map<String, List<Strategy>> strategys = new HashMap<>();

    final List<Strategy> clienteStrategys = new ArrayList<>();
    clienteStrategys.add(validarExistenciaClienteEmail);

    final List<Strategy> documentoStrategys = new ArrayList<>();
    documentoStrategys.add(validarExistenciaCPF);

    strategys.put(Cliente.class.getName(), clienteStrategys);
    strategys.put(Documento.class.getName(), documentoStrategys);
    return strategys;
  }

  public String delete(final Domain domain) {
    configMaps();
    final DAO dao = allDao.get(domain.getClass().getName());
    return dao.delete(domain);
  }

  public List<? extends Domain> find(final Domain domain) {
    configMaps();
    final DAO dao = allDao.get(domain.getClass().getName());
    return dao.find(domain);
  }

  public String save(final Domain domain) {
    configMaps();
    String logErro = null;
    final List<Strategy> strategys = allStrategy.get(domain.getClass().getName());
    if (nonNull(strategys)) {
      for (final Strategy strategy : strategys) {
        logErro = strategy.processar(domain);
        if (!isNullOrEmpty(logErro)) {
          return logErro;
        }
      }
    }
    final DAO dao = allDao.get(domain.getClass().getName());
    return dao.save(domain);
  }

  public String update(final Domain domain) {
    configMaps();
    String logErro = null;
    final List<Strategy> strategys = allStrategy.get(domain.getClass().getName());
    if (nonNull(strategys)) {
      for (final Strategy strategy : strategys) {
        logErro = strategy.processar(domain);
        if (!isNullOrEmpty(logErro)) {
          return logErro;
        }
      }
    }
    final DAO dao = allDao.get(domain.getClass().getName());
    return dao.update(domain);
  }
}
