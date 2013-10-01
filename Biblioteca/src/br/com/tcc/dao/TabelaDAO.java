package br.com.tcc.dao;

import br.com.tcc.bean.Coluna;
import br.com.tcc.bean.ForeignKey;
import br.com.tcc.bean.PrimaryKey;
import br.com.tcc.bean.Tabela;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author renan
 */
public class TabelaDAO {

    private static Connection conexao;

    public TabelaDAO(Connection conexao) {
        TabelaDAO.conexao = conexao;
    }

    public List<Tabela> listaTabelas() {
        List<Tabela> listaTabela = new ArrayList<>();
        try {
            DatabaseMetaData dmd = conexao.getMetaData();
            ResultSet rs = dmd.getTables(null, "public", null, new String[]{"TABLE"});
            while (rs.next()) {
                Tabela tab = new Tabela();
                tab.setNome(rs.getString(3));
                tab.setPk(checkPk(tab));
                tab.setListaFk(checkFk(tab));
                listaTabela.add(tab);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TabelaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaTabela;
    }

    public List<Coluna> listaColunas(Tabela tabela) {
        List<Coluna> listaColuna = new ArrayList<>();
        try {          
            DatabaseMetaData dmd = conexao.getMetaData();
            ResultSet rs = dmd.getColumns(conexao.getCatalog(), "public", tabela.getNome(), null);
            while (rs.next()) {
                Coluna c = new Coluna();
                c.setNome(rs.getString(4));
                c.setTipo(rs.getString(6));
                c.setTamanho(rs.getString(7));
                c.setNulo(rs.getString(18));
                c.setCasas(rs.getString(9));
                listaColuna.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TabelaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaColuna;
    }

    private PrimaryKey checkPk(Tabela t) {
        PrimaryKey pk = null;
        try {
            DatabaseMetaData dmd = conexao.getMetaData();
            ResultSet rs = dmd.getPrimaryKeys(null, null, t.getNome());
            while (rs.next()) {
                pk = new PrimaryKey();
                pk.setColuna(rs.getString(4));
                pk.setNome(rs.getString(6));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TabelaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pk;

    }

    private List<ForeignKey> checkFk(Tabela t) {
        List<ForeignKey> lista = new ArrayList<>();
        try {
            DatabaseMetaData dmd = conexao.getMetaData();
            ResultSet rs = dmd.getImportedKeys(null, null, t.getNome());
            while (rs.next()) {
                ForeignKey fk = new ForeignKey();
                fk.setNome(rs.getString(12));
                fk.setNomeColuna(rs.getString(8));
                fk.setTabelaReferencia(rs.getString(3));
                fk.setColunaReferencia(rs.getString(4));
                fk.setUpdateRule(ruleType(rs.getShort(10)));
                fk.setDeleteRule(ruleType(rs.getShort(11)));
                lista.add(fk);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TabelaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    private ForeignKey.RuleType ruleType(short indice) {
        switch (indice) {
            case 0:
                return ForeignKey.RuleType.CASCADE;
            case 1:
                return ForeignKey.RuleType.RESTRICT;
            case 2:
                return ForeignKey.RuleType.NULL;
            case 3:
                return ForeignKey.RuleType.NOACTION;
        }
        return ForeignKey.RuleType.DEFAULT;

    }
}
