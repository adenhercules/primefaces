/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import fornecedor.FornecedorDAO;
import fornecedor.FornecedorDAOHibernate;
import produto.ProdutoDAO;
import produto.ProdutoDAOHibernate;
import usuario.UsuarioDAO;
import usuario.UsuarioDAOHibernate;

/**
 *
 * @author Unir
 */
public class DAOFactory {
    public static UsuarioDAO criarUsuarioDAO() {
		UsuarioDAOHibernate usuarioDAO = new UsuarioDAOHibernate();
		usuarioDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return usuarioDAO;
	}
    public static ProdutoDAO criarProdutoDAO(){
        ProdutoDAOHibernate produtoDAO= new ProdutoDAOHibernate();
        produtoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
        return produtoDAO;
    }
      public static FornecedorDAO criarFornecedorDAO(){
        FornecedorDAOHibernate fornecedorDAO = new FornecedorDAOHibernate();
        fornecedorDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
        return fornecedorDAO;
    }
}
