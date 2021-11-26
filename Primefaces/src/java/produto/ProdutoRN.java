/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package produto;

import java.util.List;
import util.DAOFactory;


public class ProdutoRN {
    
    private ProdutoDAO produtoDAO;
    
    public ProdutoRN(){
        this.produtoDAO = DAOFactory.criarProdutoDAO();
    }
    public List<Produto> listar(){
        return this.produtoDAO.listar();
    }
    public void salvar (Produto produto){
        Integer codigo = produto.getCod_produto();
        if (codigo == null || codigo == 0) {
            this.produtoDAO.salvar(produto);
        } else {
            this.produtoDAO.atualizar(produto);
        }
    }
    public void excluir(Produto produto){
        this.produtoDAO.excluir(produto);
    }
    
}
