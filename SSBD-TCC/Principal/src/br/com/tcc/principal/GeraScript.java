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
        id = "br.com.tcc.principal.GeraScript")
@ActionRegistration(
        iconBase = "br/com/tcc/principal/image/doc-script.gif",
        displayName = "#CTL_GeraScript")
@ActionReferences({
    @ActionReference(path = "Menu/Comparar", position = 1000),
    @ActionReference(path = "Toolbars/File", position = -100)
})
@Messages("CTL_GeraScript=Gerar Script de Sincronização")
public final class GeraScript implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO implement action body
    }
}
