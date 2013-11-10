/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.service;

import br.com.tcc.principal.RestoreTopComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "Edit",
        id = "br.com.tcc.service.Restore")
@ActionRegistration(
        iconBase = "br/com/tcc/service/download2.png",
        displayName = "#CTL_Restore")
@ActionReferences({
    @ActionReference(path = "Menu/SSBD", position = 450),
    @ActionReference(path = "Toolbars/File", position = -100)
})
@Messages("CTL_Restore=Restaurar")
public final class Restore implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        RestoreTopComponent r = new RestoreTopComponent();
        r.open();
        r.requestActive();
    }
}
