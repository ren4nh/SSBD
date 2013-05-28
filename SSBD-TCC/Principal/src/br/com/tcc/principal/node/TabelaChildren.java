package br.com.tcc.principal.node;

import br.com.tcc.bean.Conexao;
import br.com.tcc.bean.Tabela;
import org.openide.nodes.Children;
import org.openide.nodes.Node;

/**
 *
 * @author renan
 */
public class TabelaChildren extends Children.Keys {

    private Conexao conexao;

    public TabelaChildren(Conexao conexao) {
        this.conexao = conexao;
    }

   @Override
    protected Node[] createNodes(Object l) {
        Tabela c = (Tabela) l;
        return new Node[]{new TabelaNode(c)};
    }

    @Override
    protected void addNotify() {
        Tabela[] objs = new Tabela[conexao.getListaTabelas().size()];
        for (int i = 0; i < conexao.getListaTabelas().size(); i++) {
            objs[i] = conexao.getListaTabelas().get(i);
        }
        setKeys(objs);
    }
}
