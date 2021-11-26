/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fornecedor;
import java.util.List;
import util.DAOFactory;

public class FornecedorRN {
    
    private FornecedorDAO fornecedorDAO;
    
    public FornecedorRN(){
        this.fornecedorDAO = DAOFactory.criarFornecedorDAO();
    }

    public void setFornecedorDAO(FornecedorDAO fornecedorDAO) {
        this.fornecedorDAO = fornecedorDAO;
    }

    public FornecedorDAO getFornecedorDAO() {
        return fornecedorDAO;
    }
    public List<Fornecedor> listar(){
        return this.fornecedorDAO.listar();
    }
    public void salvar (Fornecedor fornecedor){
        Integer codigo = fornecedor.getCodigo();
        if (codigo == null || codigo == 0) {
            this.fornecedorDAO.salvar(fornecedor);
        } else {
            this.fornecedorDAO.atualizar(fornecedor);
        }
    }
    public void excluir(Fornecedor fornecedor){
        this.fornecedorDAO.excluir(fornecedor);
    }
}
