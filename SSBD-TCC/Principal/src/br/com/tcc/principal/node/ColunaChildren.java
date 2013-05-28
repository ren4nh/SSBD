package br.com.tcc.principal.node;

import br.com.tcc.bean.Coluna;
import br.com.tcc.bean.Tabela;
import java.util.ArrayList;
import org.openide.nodes.Index;
import org.openide.nodes.Node;

/**
 *
 * @author renan
 */
public class ColunaChildren extends Index.ArrayChildren {
    
    private Tabela tabela;

    public ColunaChildren(Tabela tabela) {
        this.tabela = tabela;
    }
    
    @Override
    protected java.util.List<Node> initCollection() {
       ArrayList childrenNodes = new ArrayList();
        for (Coluna coluna : tabela.getListaColuna()) {
            Coluna c = new Coluna();
            c.setNome(coluna.getNome());
            childrenNodes.add(new ColunaNode(c));
        }
        return childrenNodes;
    }
    
}
