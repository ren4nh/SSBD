/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.service;

import br.com.tcc.principal.BackupTopComponent;
import br.com.tcc.view.ComparaTopComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "Edit",
        id = "br.com.tcc.service.Backup")
@ActionRegistration(
        iconBase = "br/com/tcc/service/Backup.png",
        displayName = "#CTL_Backup")
@ActionReferences({
    @ActionReference(path = "Menu/SSBD", position = 600, separatorBefore = 550),
    @ActionReference(path = "Toolbars/File", position = -200)
})
@Messages("CTL_Backup=Backup")
public final class Backup implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        BackupTopComponent b = new BackupTopComponent();
        b.open();
        b.requestActive();
    }
}
