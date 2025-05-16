package br.senac.sp.livraria.tablemodel;

import br.senac.sp.livraria.model.Cliente;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ClienteTableModel extends AbstractTableModel {
    private final String[] cabecalho = {"ID", "Nome", "CPF", "E-mail"};
    private List<Cliente> lista;

    public ClienteTableModel(List<Cliente> lista) {
        this.lista = lista;
    }

    public void setLista(List<Cliente> lista) {
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return cabecalho.length;
    }

    @Override
    public String getColumnName(int column) {
        return cabecalho[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente c = lista.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return c.getId();
            case 1:
                return c.getNome();
            case 2:
                return c.getCpf();
            case 3:
                return c.getEmail();
        }

        return null;
    }
}
