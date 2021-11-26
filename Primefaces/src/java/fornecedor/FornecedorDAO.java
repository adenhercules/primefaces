/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fornecedor;
import java.util.List;

public interface FornecedorDAO {
    
    public List<Fornecedor> listar();
    
    public void salvar(Fornecedor fornecedor);
    public void excluir (Fornecedor fornecedor);
    public void atualizar (Fornecedor fornecedor);
    
}
