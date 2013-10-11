package br.com.tcc.principal;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;

/**
 *
 * @author Renan
 */
public class RootNode extends AbstractNode {

    public RootNode(Children children) {
        super(children);
        setIconBaseWithExtension("br/com/tcc/principal/image/conexao.png");
    }

    @Override
    public Action[] getActions(boolean context) {
        Action[] result = new Action[]{
            new NewConexaoAction(),
            new RefreshAction()
        };
        return result;
    }

    private final class NewConexaoAction extends AbstractAction {

        public NewConexaoAction() {
            putValue(Action.NAME, "Nova Conexão...");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            ConexaoTopComponent c = new ConexaoTopComponent();
            c.open();
            c.requestActive();
        }
    }

    private final class RefreshAction extends AbstractAction {

        public RefreshAction() {
            putValue(Action.NAME, "Refresh");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            AbaConexaoTopComponent.criarArvore();
        }
    }
}
