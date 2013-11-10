package br.com.tcc.service;

import br.com.tcc.bean.Alter;
import br.com.tcc.bean.Auxiliar;
import br.com.tcc.bean.Coluna;
import br.com.tcc.bean.Conexao;
import br.com.tcc.bean.Create;
import br.com.tcc.bean.Delete;
import br.com.tcc.bean.Tabela;
import br.com.tcc.xml.GerarXml;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Renan
 */
public class ComparaTabela {

    public Map<String,String> compara(Conexao baseAntiga, Conexao baseAtual) {
        Create create = new Create();
        Delete delete = new Delete();
        Alter alter = new Alter();
        ComparaConstraints cc = new ComparaConstraints();
        Auxiliar aux;
        Map<String,String> mapa = new HashMap<String, String>();
        List<Tabela> listaCreate = new ArrayList<Tabela>();
        List<Tabela> listaDelete = new ArrayList<Tabela>();
        StringBuilder resultado = new StringBuilder();
        StringBuilder diferente = new StringBuilder();
        resultado.append("<html>");
        for (Tabela tabelaAtual : baseAtual.getListaTabelas()) {
            if (baseAntiga.getListaTabelas().contains(tabelaAtual)) {
                resultado.append("<font color=BLACK>As tabelas ").append(baseAtual.getNome()).append(".").append(tabelaAtual.getNome()).append(" e ").append(baseAntiga.getNome()).append(".").append(baseAntiga.getListaTabelas().get(baseAntiga.getListaTabelas().indexOf(tabelaAtual)).getNome()).append(" possuem o mesmo nome.</font><br />");
                ComparaColuna comparaColuna = new ComparaColuna(baseAntiga.getListaTabelas().get(baseAntiga.getListaTabelas().indexOf(tabelaAtual)), tabelaAtual, baseAntiga.getNome(), baseAtual.getNome());
                aux = comparaColuna.compara();
                Auxiliar aPk = cc.comparaPk(tabelaAtual, baseAntiga.getListaTabelas().get(baseAntiga.getListaTabelas().indexOf(tabelaAtual)));
                Auxiliar aFk = cc.comparaFk(tabelaAtual, baseAntiga.getListaTabelas().get(baseAntiga.getListaTabelas().indexOf(tabelaAtual)));
                if (aPk.getTabela() != null) {
                    aux.getTabela().setPk(aPk.getTabela().getPk());
                }
                aux.getTabela().setListaFk(aFk.getTabela().getListaFk());
                resultado.append(aFk.getResultado().get("igual") == null ? "" : aFk.getResultado().get("igual"));
                diferente.append(aFk.getResultado().get("dif") == null ? "" : aFk.getResultado().get("dif"));
                resultado.append(aPk.getResultado().get("igual") == null ? "" : aPk.getResultado().get("igual"));
                diferente.append(aPk.getResultado().get("dif") == null ? "" : aPk.getResultado().get("dif"));
                resultado.append(aux.getResultado().get("igual") == null ? "" : aux.getResultado().get("igual"));
                diferente.append(aux.getResultado().get("dif") == null ? "" : aux.getResultado().get("dif"));
                if (aux.getTabela() != null) {
                    alter.getListaTabela().add(aux.getTabela());
                }
            } else {
                diferente.append("<font color=GREEN>Deverá ser criada a tabela ").append(tabelaAtual.getNome()).append(" na base de dados ").append(baseAntiga.getNome()).append("</font><br />");
                listaCreate.add(tabelaAtual);
            }
        }
        for (Tabela tabelaAntiga : baseAntiga.getListaTabelas()) {
            if (!baseAtual.getListaTabelas().contains(tabelaAntiga)) {
                diferente.append("<font color=RED>Deverá ser deletada a tabela ").append(tabelaAntiga.getNome()).append(" na base de dados ").append(baseAntiga.getNome()).append("</font><br />");
                tabelaAntiga.setListaColuna(null);
                listaDelete.add(tabelaAntiga);
            } else {
                Tabela tabDelete = new Tabela();
                Tabela tabelaAtual = baseAtual.getListaTabelas().get(baseAtual.getListaTabelas().indexOf(tabelaAntiga));
                for (Coluna colunaAntiga : tabelaAntiga.getListaColuna()) {
                    if (!tabelaAtual.getListaColuna().contains(colunaAntiga)) {
                        tabDelete.getListaColuna().add(colunaAntiga);
                        diferente.append("<font color=RED>Deverá ser deletada a coluna ").append(tabelaAntiga.getNome()).append(".").append(colunaAntiga.getNome()).append(" na base de dados ").append(baseAntiga.getNome()).append("</font><br />");
                    }
                }
                if (!tabDelete.getListaColuna().isEmpty()) {
                    tabDelete.setNome(tabelaAntiga.getNome());
                    listaDelete.add(tabDelete);
                }
            }
        }
        resultado.append("</html>");
        create.setListaTabela(listaCreate);
        delete.setListaTabelas(listaDelete);
        GerarXml.gerarCreate(create);
        GerarXml.gerarDelete(delete);
        GerarXml.gerarAlter(alter);
        mapa.put("igual", resultado.toString());
        mapa.put("dif", diferente.toString().trim().isEmpty() ? "As bases de dados são iguais !" : diferente.toString());
        return mapa;
    }
}
