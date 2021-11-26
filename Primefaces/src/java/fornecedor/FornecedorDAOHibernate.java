/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fornecedor;
import java.util.List;
import org.hibernate.Session;


public class FornecedorDAOHibernate implements FornecedorDAO{
    private Session session;
    
    public void setSession(Session session){
        this.session = session;
    }
    
    public List<Fornecedor> listar(){
        return this.session.createCriteria(Fornecedor.class).list();
    }
    
    public void salvar(Fornecedor fornecedor){
        this.session.save(fornecedor);
    }
    
    public void atualizar(Fornecedor fornecedor){
        this.session.merge(fornecedor);
    }

    
    public void excluir (Fornecedor fornecedor){
        this.session.delete(fornecedor);
    }
}