/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package produto;

import java.util.List;
import org.hibernate.Session;


public class ProdutoDAOHibernate implements ProdutoDAO{
    private Session session;
    
    public void setSession(Session session){
        this.session = session;
    }
    
    @Override
    public List<Produto> listar(){
        return this.session.createCriteria(Produto.class).list();
    }
    
    @Override
    public void salvar(Produto produto){
        this.session.save(produto);
    }
    
    @Override
    public void atualizar(Produto produto){
        this.session.merge(produto);
    }

    
    @Override
    public void excluir (Produto produto){
        this.session.delete(produto);
    }
}
