package br.com.tcc.service;

import br.com.tcc.bean.Alter;
import br.com.tcc.bean.Auxiliar;
import br.com.tcc.bean.Conexao;
import br.com.tcc.bean.Create;
import br.com.tcc.bean.Delete;
import br.com.tcc.bean.Tabela;
import br.com.tcc.xml.GerarXml;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Renan
 */
public class ComparaTabela {

    public String compara(Conexao baseAntiga, Conexao baseAtual) {
        Create create = new Create();
        Delete delete = new Delete();
        Alter alter = new Alter();
        Auxiliar aux;
        List<Tabela> listaCreate = new ArrayList<Tabela>();
        List<Tabela> listaDelete = new ArrayList<Tabela>();
        StringBuilder resultado = new StringBuilder();
        resultado.append("<html>");
        for (Tabela tabelaAtual : baseAtual.getListaTabelas()) {
            if (baseAntiga.getListaTabelas().contains(tabelaAtual)) {
                resultado.append("<font color=BLACK>As tabelas ").append(baseAtual.getNome()).append(".").append(tabelaAtual.getNome()).append(" e ").append(baseAntiga.getNome()).append(".").append(baseAntiga.getListaTabelas().get(baseAntiga.getListaTabelas().indexOf(tabelaAtual)).getNome()).append(" possuem o mesmo nome.</font><br />");
                ComparaColuna comparaColuna = new ComparaColuna(baseAntiga.getListaTabelas().get(baseAntiga.getListaTabelas().indexOf(tabelaAtual)), tabelaAtual, baseAntiga.getNome(), baseAtual.getNome());
                aux = comparaColuna.compara();
                resultado.append(aux.getResultado());
                if (!aux.getTabela().getListaColuna().isEmpty()) {
                    alter.getListaTabela().add(aux.getTabela());
                }
                } else {
                    resultado.append("<font color=GREEN>Deverá ser criada a tabela ").append(tabelaAtual.getNome()).append(" na base de dados ").append(baseAntiga.getNome()).append("</font><br />");
                    listaCreate.add(tabelaAtual);
                }
            }
            for (Tabela tabelaAntiga : baseAntiga.getListaTabelas()) {
                if (!baseAtual.getListaTabelas().contains(tabelaAntiga)) {
                    resultado.append("<font color=RED>Deverá ser deletada a tabela ").append(tabelaAntiga.getNome()).append(" na base de dados ").append(baseAntiga.getNome()).append("</font><br />");
                    tabelaAntiga.setListaColuna(null);
                    listaDelete.add(tabelaAntiga);
                }
            }
            resultado.append("</html>");
            create.setListaTabela(listaCreate);
            delete.setListaTabelas(listaDelete);
            GerarXml.gerarCreate(create);
            GerarXml.gerarDelete(delete);
            GerarXml.gerarAlter(alter);
            return resultado.toString();
        }
    }
