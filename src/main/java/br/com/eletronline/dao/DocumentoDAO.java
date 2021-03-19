package br.com.eletronline.dao;

import static java.util.Objects.nonNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;
import br.com.eletronline.domain.Cliente;
import br.com.eletronline.domain.Documento;
import br.com.eletronline.domain.Domain;
import br.com.eletronline.domain.TipoDocumento;
import br.com.eletronline.repository.DocumentoRepository;

@Component
public class DocumentoDAO implements DAO {

  @Autowired private ClienteDAO clienteDAO;

  @Autowired private TipoDocumentoDAO tipoDocumentoDAO;

  @Autowired private DocumentoRepository documentoRepository;

  @Override
  public String delete(final Domain domain) {
    final Documento documento = (Documento) domain;
    final Documento documentoEncontrado = documentoRepository.findById(documento.getId()).orElse(null);
    if (nonNull(documentoEncontrado)) {
      documentoRepository.delete(documentoEncontrado);
      return "Documento excluído com sucesso!";
    } else {
      return "Erro interno do sistema! Documento não encontrado!";
    }
  }

  @Override
  public List<? extends Domain> find(final Domain domain) {
    final Documento documento = (Documento) domain;
    List<Documento> documentos = new ArrayList<>();
    if (documento.getId() != null) {
      documentos.add(findById(documento.getId()));
    } else {
      documentos = findAll();
    }
    return documentos;
  }

  @Override
  public List<Documento> findAll() {
    return documentoRepository.findAll();
  }

  @Override
  public Documento findById(final Long id) {
    final Documento documento = documentoRepository.findById(id).orElse(null);
    return documento;
  }

  public Optional<Documento> findDocumentoByNumero(final String numero) {
    final Documento documento = Documento.builder().numero(numero).build();
    return documentoRepository.findOne(Example.of(documento));
  }

  @Override
  public String save(final Domain domain) {
    final Documento documento = (Documento) domain;
    final Cliente cliente = clienteDAO.findById(documento.getCliente().getId());
    if (nonNull(cliente)) {
      documento.setCliente(cliente);
      documento.setDataCadastro(LocalDate.now());
      documentoRepository.save(documento);
      return "Documento cadastrado com sucesso!";
    } else {
      return "Erro interno do sistema! Cliente não encontrado!";
    }
  }

  @Override
  public String update(final Domain domain) {
    final Documento documentoUpdate = (Documento) domain;
    final Documento documento = documentoRepository.findById(documentoUpdate.getId()).orElse(null);
    if (nonNull(documento)) {
      final Cliente cliente = clienteDAO.findById(documento.getCliente().getId());
      if (nonNull(cliente)) {
        if (cliente.getId().equals(documentoUpdate.getCliente().getId())) {
          documento.setNumero(documentoUpdate.getNumero() != null ? documentoUpdate.getNumero() : documento.getNumero());
          documento.setValidade(documentoUpdate.getValidade() != null ? documentoUpdate.getValidade() : documento.getValidade());
          if (nonNull(documentoUpdate.getTipo().getId())) {
            if (!documento.getTipo().getId().equals(documentoUpdate.getTipo().getId())) {
              final TipoDocumento tipoDocumento = tipoDocumentoDAO.findById(documentoUpdate.getTipo().getId());
              if (nonNull(tipoDocumento)) {
                documento.setTipo(tipoDocumento);
              } else {
                return "Tipo de documento não encontrado! Tente outro!";
              }
            }
          }
          documentoRepository.save(documento);
          return "Documento atualizado com sucesso!";
        } else {
          return "O documento que coube atualização não é o mesmo do cliente informado!";
        }
      } else {
        return "Erro interno do sistema! Cliente não encontrado!";
      }
    } else {
      return "Erro interno do sistema! Documento não encontrado!";
    }
  }

  @Override
  public String registrarLog(String registro) {
    // TODO Auto-generated method stub
    return null;
  }

}
