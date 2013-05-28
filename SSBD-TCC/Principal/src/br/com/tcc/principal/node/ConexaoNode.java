package br.com.tcc.principal.node;

import br.com.tcc.bean.Conexao;
import org.openide.nodes.AbstractNode;
import org.openide.util.lookup.Lookups;

/**
 *
 * @author renan
 */
public class ConexaoNode extends AbstractNode {
    
    public ConexaoNode(Conexao conexao) {
        super( new TabelaChildren(conexao), Lookups.singleton(conexao) );
        setDisplayName(conexao.getNome());
        setIconBaseWithExtension("br/com/tcc/principal/image/database.png");
    }
    
}
