package br.com.tcc.principal.node;

import br.com.tcc.bean.Conexao;
import br.com.tcc.principal.AbaConexaoTopComponent;
import br.com.tcc.principal.ConexaoTopComponent;
import br.com.tcc.principal.RootNode;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import org.openide.nodes.AbstractNode;
import org.openide.util.lookup.Lookups;

/**
 *
 * @author renan
 */
public class ConexaoNode extends AbstractNode {

    Conexao c;

    public ConexaoNode(Conexao conexao) {
        super(new TabelaChildren(conexao), Lookups.singleton(conexao));
        setDisplayName(conexao.getNome());
        c = conexao;
        setIconBaseWithExtension("br/com/tcc/principal/image/database.png");
    }
    
    @Override
    public Action[] getActions(boolean context) {
        Action[] result = new Action[]{
            new DisconnectAction()
        };
        return result;
    }

    private final class DisconnectAction extends AbstractAction {

        public DisconnectAction() {
            putValue(Action.NAME, "Desconectar");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            AbaConexaoTopComponent.lista.remove(c);
            AbaConexaoTopComponent.criarArvore();
        }
    }
}
