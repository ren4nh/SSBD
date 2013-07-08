package br.com.tcc.service;

import br.com.tcc.bean.Conexao;
import java.util.List;

/**
 *
 * @author Renan
 */
public interface Compara {
    
    public String comparaNome(Conexao baseAntiga, Conexao baseAtual);
}
