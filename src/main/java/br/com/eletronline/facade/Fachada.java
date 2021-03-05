package br.com.eletronline.facade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import br.com.eletronline.dao.ClienteDAO;
import br.com.eletronline.dao.DAO;
import br.com.eletronline.domain.Cliente;
import br.com.eletronline.domain.Domain;
import br.com.eletronline.strategy.Strategy;
import br.com.eletronline.strategy.ValidarClienteCPF;

@Component
public class Fachada {

  @Autowired private ClienteDAO clienteDAO;

  @Autowired private ValidarClienteCPF validarClienteCPF;

  protected Map<String, DAO> allDao;

  protected Map<String, List<Strategy>> allStrategy;

  Fachada() {
    allDao = loadDao();
    allStrategy = loadStrategy();
  }

  public Map<String, DAO> loadDao() {
    final Map<String, DAO> daos = new HashMap<>();
    daos.put(Cliente.class.getName(), clienteDAO);
    return daos;
  }

  public Map<String, List<Strategy>> loadStrategy() {
    final Map<String, List<Strategy>> strategys = new HashMap<>();

    final List<Strategy> clienteStrategys = new ArrayList<>();
    clienteStrategys.add(validarClienteCPF);

    strategys.put(Cliente.class.getName(), clienteStrategys);
    return strategys;
  }

  public String delete(final Domain domain) {
    final DAO dao = allDao.get(domain.getClass().getName());
    return dao.delete(domain);
  }

  public List<? extends Domain> find(final Domain domain) {
    final DAO dao = allDao.get(domain.getClass().getName());
    return dao.find(domain);
  }

  public String save(final Domain domain) {
    String logErro = null;
    final List<Strategy> strategys = allStrategy.get(domain.getClass().getName());
    if (strategys != null) {
      for (final Strategy strategy : strategys) {
        logErro = strategy.processar(domain);
        if (logErro != null) {
          return logErro;
        }
      }
    }
    final DAO dao = allDao.get(domain.getClass().getName());
    return dao.save(domain);
  }

  public String update(final Domain domain) {
    final DAO dao = allDao.get(domain.getClass().getName());
    return dao.update(domain);
  }
}
