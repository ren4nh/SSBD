package br.com.tcc.principal;

import java.beans.IntrospectionException;
import java.util.List;
import org.openide.nodes.BeanNode;
import org.openide.nodes.Node;
import org.openide.util.Exceptions;

/**
 *
 * @author Jeanne
 */
public class ChildFactory extends org.openide.nodes.ChildFactory<String> {

    private List<String> resultList;

    public ChildFactory(List<String> resultList) {
        this.resultList = resultList;
    }

    @Override
    protected boolean createKeys(List<String> list) {
        for (String Customer : resultList) {
            list.add(Customer);
        }
        return true;
    }

    @Override
    protected Node createNodeForKey(String c) {
        try {
            return new BeanNode(c);
        } catch (IntrospectionException ex) {
            Exceptions.printStackTrace(ex);
            return null;
        }
    }
}
