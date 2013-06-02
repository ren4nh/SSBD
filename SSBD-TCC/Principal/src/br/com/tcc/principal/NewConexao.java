package br.com.tcc.principal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "File",
        id = "br.com.tcc.principal.NewConexao")
@ActionRegistration(
        iconBase = "br/com/tcc/principal/image/database-add-icon.png",
        displayName = "#CTL_newConexao")
@ActionReference(path = "Menu/File", position = 1300)
@Messages("CTL_newConexao=Nova Conexão")
public final class NewConexao implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        ConexaoTopComponent c = new ConexaoTopComponent();
        c.open();
        c.requestActive();
    }
}
