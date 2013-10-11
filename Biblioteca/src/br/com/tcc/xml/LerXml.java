package br.com.tcc.xml;

import br.com.tcc.bean.Alter;
import br.com.tcc.bean.Coluna;
import br.com.tcc.bean.Create;
import br.com.tcc.bean.Delete;
import br.com.tcc.bean.Tabela;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.File;

/**
 *
 * @author renan
 */
public class LerXml {

    public Create lerCreate() {
        XStream xstream = new XStream(new DomDriver());
        xstream.alias("create", Create.class);
        xstream.alias("tabela", Tabela.class);
        xstream.alias("coluna", Coluna.class);
        xstream.autodetectAnnotations(true);
        File f = new File("create.xml");
        if (f.exists()) {
            Create c = (Create) xstream.fromXML(f);
            return c;
        } else {
            return null;
        }
    }

    public Delete lerDelete() {
        XStream xstream = new XStream(new DomDriver());
        xstream.alias("delete", Delete.class);
        xstream.alias("tabela", Tabela.class);
        xstream.autodetectAnnotations(true);
        File f = new File("delete.xml");
        if (f.exists()) {
            Delete d = (Delete) xstream.fromXML(f);
            return d;
        } else {
            return null;
        }

    }

    public Alter lerAlter() {
        XStream xstream = new XStream(new DomDriver());
        xstream.alias("alter", Alter.class);
        xstream.alias("tabela", Tabela.class);
        xstream.alias("coluna", Coluna.class);
        xstream.autodetectAnnotations(true);
        File f = new File("alter.xml");
        if (f.exists()) {
            Alter a = (Alter) xstream.fromXML(new File("alter.xml"));
            return a;
        }
        return null;
    }
}
