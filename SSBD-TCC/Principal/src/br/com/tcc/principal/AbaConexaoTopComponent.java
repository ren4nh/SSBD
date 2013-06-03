/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.principal;

import br.com.tcc.bean.Conexao;
import br.com.tcc.bean.Tabela;
import br.com.tcc.dao.TabelaDAO;
import br.com.tcc.principal.node.ConexaoChildren;
import java.util.ArrayList;
import java.util.List;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.explorer.ExplorerManager;
import org.openide.explorer.ExplorerUtils;
import org.openide.explorer.view.BeanTreeView;
import org.openide.windows.TopComponent;
import org.openide.util.NbBundle.Messages;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
        dtd = "-//br.com.tcc.principal//Teste2//EN",
        autostore = false)
@TopComponent.Description(
        preferredID = "Teste2TopComponent",
        //iconBase="SET/PATH/TO/ICON/HERE", 
        persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(mode = "explorer", openAtStartup = true)
@ActionID(category = "Window", id = "br.com.tcc.principal.Teste2TopComponent")
@ActionReference(path = "Menu/Window" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_Teste2Action",
        preferredID = "Teste2TopComponent")
@Messages({
    "CTL_Teste2Action=Teste2",
    "CTL_Teste2TopComponent=Conexão",
    "HINT_Teste2TopComponent=This is a Conexão window"
})
public final class AbaConexaoTopComponent extends TopComponent implements ExplorerManager.Provider {

    private static ExplorerManager em = new ExplorerManager();
    public static List<Conexao> lista = new ArrayList<Conexao>();

    public AbaConexaoTopComponent() {
        initComponents();
        setName(Bundle.CTL_Teste2TopComponent());
        setToolTipText(Bundle.HINT_Teste2TopComponent());
//        putClientProperty(TopComponent.PROP_CLOSING_DISABLED, Boolean.TRUE);
//        putClientProperty(TopComponent.PROP_UNDOCKING_DISABLED, Boolean.TRUE);
        criarArvore();
        associateLookup(ExplorerUtils.createLookup(em, getActionMap()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new BeanTreeView();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void componentOpened() {
        // TODO add custom code on component opening
    }

    @Override
    public void componentClosed() {
        // TODO add custom code on component closing
    }

    void writeProperties(java.util.Properties p) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");
        // TODO store your settings
    }

    void readProperties(java.util.Properties p) {
        String version = p.getProperty("version");
        // TODO read your settings according to their version
    }

    public static void criarArvore() {
        List<Conexao> listaCon = new ArrayList<Conexao>();
        for (Conexao conexao : lista) {
            TabelaDAO tabDAO = new TabelaDAO(conexao.getConexao());
            List<Tabela> listaTab = new ArrayList<Tabela>();
            for (Tabela tabela1 : tabDAO.listaTabelas()) {
                Tabela t = new Tabela();
                t.setNome(tabela1.getNome());
                t.setListaColuna(tabDAO.listaColunas(tabela1));
                listaTab.add(t);
            }
            conexao.setListaTabelas(listaTab);
            listaCon.add(conexao);
        }
        em.setRootContext(new RootNode(new ConexaoChildren(listaCon)));
        em.getRootContext().setDisplayName("Conexões");
    }

    @Override
    public ExplorerManager getExplorerManager() {
        return em;
    }
}
