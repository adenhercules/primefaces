/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package produto;

import java.util.List;


public interface ProdutoDAO {
    public List<Produto> listar();
    
    public void salvar(Produto produto);
    public void excluir (Produto produto);
    public void atualizar (Produto produto);
}
