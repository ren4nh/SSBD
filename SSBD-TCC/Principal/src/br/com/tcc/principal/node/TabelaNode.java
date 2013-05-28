package br.com.tcc.principal.node;

import br.com.tcc.bean.Tabela;
import org.openide.nodes.AbstractNode;
import org.openide.util.lookup.Lookups;

/**
 *
 * @author renan
 */
public class TabelaNode extends AbstractNode {

    private Tabela tabela;
    
    public TabelaNode(Tabela key) {
        super(new ColunaChildren(key), Lookups.singleton(key) );
        this.tabela = key;
        setDisplayName(key.getNome());
        setIconBaseWithExtension("br/com/tcc/principal/image/tabela.png");
    }
}
