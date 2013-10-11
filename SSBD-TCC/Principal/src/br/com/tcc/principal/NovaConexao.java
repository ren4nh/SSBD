/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.principal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "Edit",
        id = "br.com.tcc.principal.NovaConexao")
@ActionRegistration(
        iconBase = "br/com/tcc/principal/image/New-Database-icon.png",
        displayName = "#CTL_NovaConexao")
@ActionReferences({
    @ActionReference(path = "Menu/Comparar", position = 600),
    @ActionReference(path = "Toolbars/File", position = -400)
})
@Messages("CTL_NovaConexao=Nova Conexao")
public final class NovaConexao implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        ConexaoTopComponent c = new ConexaoTopComponent();
        c.open();
        c.requestActive();
    }
}
