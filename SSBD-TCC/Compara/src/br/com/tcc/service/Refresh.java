/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.service;

import br.com.tcc.principal.AbaConexaoTopComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "Edit",
        id = "br.com.tcc.service.Refresh")
@ActionRegistration(
        iconBase = "br/com/tcc/service/refresh.png",
        displayName = "#CTL_Refresh")
@ActionReferences({
    @ActionReference(path = "Toolbars/File", position = -100)
})
@Messages("CTL_Refresh=Atualizar")
public final class Refresh implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        AbaConexaoTopComponent.criarArvore();
    }
}
