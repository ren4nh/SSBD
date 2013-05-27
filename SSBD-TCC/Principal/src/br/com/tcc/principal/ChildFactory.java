package br.com.tcc.principal;

import br.com.tcc.bean.Tabela;
import java.beans.IntrospectionException;
import java.util.List;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.BeanNode;
import org.openide.nodes.Children;
import org.openide.nodes.Node;
import org.openide.util.Exceptions;
import org.openide.util.lookup.Lookups;

/**
 *
 * @author renan
 */
public class ChildFactory extends org.openide.nodes.ChildFactory<Tabela> {

    private List<Tabela> resultList;

    public ChildFactory(List<Tabela> resultList) {
        this.resultList = resultList;
    }

    @Override
    protected boolean createKeys(List<Tabela> list) {
        for (Tabela Customer : resultList) {
            list.add(Customer);
        }
        return true;
    }

    @Override
    protected Node createNodeForKey(Tabela c) {
        Node node = new AbstractNode(Children.LEAF);
        node.setDisplayName(c.getNome());
        return node;
    }
}
