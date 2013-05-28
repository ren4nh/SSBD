package br.com.tcc.principal.node;

import br.com.tcc.bean.Conexao;
import java.util.List;
import org.openide.nodes.Children;
import org.openide.nodes.Node;

/**
 *
 * @author renan
 */
public class ConexaoChildren extends Children.Keys {

   private List<Conexao> c;

    public ConexaoChildren(List<Conexao> c) {
        this.c = c;
    }

    @Override
    protected Node[] createNodes(Object l) {
        Conexao c = (Conexao) l;
        return new Node[]{new ConexaoNode(c)};
    }

    @Override
    protected void addNotify() {
        Conexao[] objs = new Conexao[c.size()];
        for (int i = 0; i < c.size(); i++) {
            objs[i] = c.get(i);
        }
        setKeys(objs);
    }
}
