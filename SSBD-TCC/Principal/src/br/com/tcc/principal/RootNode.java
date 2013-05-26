package br.com.tcc.principal;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;

/**
 *
 * @author Jeanne
 */
public class RootNode extends AbstractNode{

    public RootNode(Children children) {
        super(children);
        setDisplayName("Conexão");
    }
    
     @Override
    public Action[] getActions(boolean context) {
        Action[] result = new Action[]{
            new RefreshAction()
        };
        return result;
    }

    private final class RefreshAction extends AbstractAction {

        public RefreshAction() {
            putValue(Action.NAME, "Nova Conexão");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            principalTopComponent.novaConexao();
        }
    }
    
    
    
}
