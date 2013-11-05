package br.com.tcc.principal.node;

import br.com.tcc.bean.Coluna;
import br.com.tcc.bean.ForeignKey;
import br.com.tcc.bean.PrimaryKey;
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
            boolean pk = false;
            boolean fk = false;
            for (PrimaryKey foreignKey : tabela.getPk()) {
                if (foreignKey.getColuna().equalsIgnoreCase(coluna.getNome())) {
                    fk = true;
                }
            }
            for (ForeignKey foreignKey : tabela.getListaFk()) {
                if (foreignKey.getNomeColuna().equalsIgnoreCase(coluna.getNome())) {
                    fk = true;
                }
            }
            childrenNodes.add(new ColunaNode(coluna, pk, fk));
        }
        return childrenNodes;
    }
}
