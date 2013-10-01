//package br.com.tcc.dao;
//
//import br.com.tcc.bean.Coluna;
//import br.com.tcc.bean.Tabela;
//import java.sql.Connection;
//
///**
// *
// * @author renan
// */
//public class CreateDAO {
//
//    private static Connection conexao;
//
//    public CreateDAO(Connection conexao) {
//        CreateDAO.conexao = conexao;
//    }
//
//    public void create(Tabela t) {
//        StringBuilder sql = new StringBuilder();
//        if (t != null) {
//            sql.append("create table ").append(t.getNome()).append(" ( ");
//            for (Coluna coluna : t.getListaColuna()) {
//                if (t.getListaColuna().size() > 1 || coluna.getPk().equalsIgnoreCase("SIM") || coluna.getFk() != null) {
//                    sql.append(coluna.getNome()).append(coluna.getTipo()).append(" (").append(coluna.getTamanho()).append
//                            (!coluna.getCasas().isEmpty() ? "," + coluna.getCasas() : "").append(")").append(",");
//                } else {
//                    sql.append(coluna.getNome()).append(coluna.getTipo()).append(" (").append(coluna.getTamanho()).append
//                            (!coluna.getCasas().isEmpty() ? "," + coluna.getCasas() : "").append(")");
//                }
//            }
//        }
//    }
//}
//
