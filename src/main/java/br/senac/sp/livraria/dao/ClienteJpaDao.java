package br.senac.sp.livraria.dao;

import br.senac.sp.livraria.model.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.sql.SQLException;
import java.util.List;

public class ClienteJpaDao implements InterfaceDao<Cliente> {
    private final EntityManager manager;

    public ClienteJpaDao(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public void inserir(Cliente cliente) throws SQLException {
        this.manager.getTransaction().begin();
        this.manager.persist(cliente);
        this.manager.getTransaction().commit();
    }

    @Override
    public void alterar(Cliente cliente) throws SQLException {
        this.manager.getTransaction().begin();
        this.manager.merge(cliente);
        this.manager.getTransaction().commit();
    }

    @Override
    public void excluir(int id) throws SQLException {
        Cliente cliente = this.buscar(id);
        this.manager.getTransaction().begin();
        this.manager.remove(cliente);
        this.manager.getTransaction().commit();
    }

    @Override
    public List<Cliente> listar() throws SQLException {
        CriteriaBuilder criteriaBuilder = this.manager.getCriteriaBuilder();
        CriteriaQuery<Cliente> criteriaQuery = criteriaBuilder.createQuery(Cliente.class);
        Root<Cliente> clienteRoot = criteriaQuery.from(Cliente.class);

        criteriaQuery.select(clienteRoot);

        Query query = this.manager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Override
    public List<Cliente> listarPorNome(String nome) throws SQLException {
        CriteriaBuilder criteriaBuilder = this.manager.getCriteriaBuilder();
        CriteriaQuery<Cliente> criteriaQuery = criteriaBuilder.createQuery(Cliente.class);
        Root<Cliente> clienteRoot = criteriaQuery.from(Cliente.class);

        criteriaQuery.select(clienteRoot);
        criteriaQuery.where(criteriaBuilder.equal(clienteRoot.get("nome"), nome));

        Query query = this.manager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Override
    public Cliente buscar(int id) throws SQLException {
        return this.manager.find(Cliente.class, id);
    }
}
