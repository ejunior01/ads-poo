package br.senac.sp.livraria.dao;

import java.sql.SQLException;
import java.util.List;

public interface InterfaceDao<T> {
    void inserir(T objeto) throws SQLException;

    void alterar(T objeto) throws SQLException;

    void excluir(int id) throws SQLException;

    List<T> listar() throws SQLException;

    List<T> listarPorNome(String nome) throws SQLException;

    T buscar(int id) throws SQLException;
}
