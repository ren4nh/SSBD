package br.com.tcc.principal.node;

import br.com.tcc.bean.Coluna;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.util.lookup.Lookups;

/**
 *
 * @author renan
 */
public class ColunaNode extends AbstractNode {

    private Coluna coluna;

    public ColunaNode(Coluna key) {
        super(Children.LEAF, Lookups.fixed(new Object[]{key}));
        this.coluna = key;
        setDisplayName(key.getNome());
        if (key.isPk()) {
            setIconBaseWithExtension("br/com/tcc/principal/image/pkey.gif");
        } else if (key.isFk()) {
            setIconBaseWithExtension("br/com/tcc/principal/image/fkey.gif");
        } else {
            setIconBaseWithExtension("br/com/tcc/principal/image/coluna.png");
        }
    }
}
