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
        Create c = (Create) xstream.fromXML(new File("create.xml"));
        return c;
    }

    public Delete lerDelete() {
        XStream xstream = new XStream(new DomDriver());
        xstream.alias("delete", Delete.class);
        xstream.alias("tabela", Tabela.class);
        xstream.autodetectAnnotations(true);
        Delete d = (Delete) xstream.fromXML(new File("delete.xml"));
        return d;
    }

    public Alter lerAlter() {
        XStream xstream = new XStream(new DomDriver());
        xstream.alias("alter", Alter.class);
        xstream.alias("tabela", Tabela.class);
        xstream.alias("coluna", Coluna.class);
        xstream.autodetectAnnotations(true);
        Alter a = (Alter) xstream.fromXML(new File("alter.xml"));
        return a;
    }
}
