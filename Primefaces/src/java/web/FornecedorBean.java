/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import fornecedor.Fornecedor;
import fornecedor.FornecedorRN;


@Named
@RequestScoped
public class FornecedorBean {
        private Fornecedor fornecedor = new Fornecedor();
    private List<Fornecedor> lista = null;
    private String destinoSalvar = "fornecedorSucesso";
    
    public Fornecedor getFornecedor(){
        return fornecedor;
    }
    
    public void setFornecedor (Fornecedor fornecedor){
        this.fornecedor = fornecedor;
    }
    public List<Fornecedor> getLista(){
        if (this.lista==null){
            FornecedorRN fornecedorRN = new FornecedorRN();
            this.lista = fornecedorRN.listar();
        }
        return this.lista;
    }

    public String getDestinoSalvar() {
        return destinoSalvar;
    }

    public void setDestinoSalvar(String destinoSalvar) {
        this.destinoSalvar = destinoSalvar;
    }
    
    
    
    public String salvar(){
        FacesContext context = FacesContext.getCurrentInstance();
        try{
            FornecedorRN fornecedorRN = new FornecedorRN();
            fornecedorRN.salvar(this.fornecedor);
            this.fornecedor = new Fornecedor();
            this.lista = null;
        }catch (Exception e){
            FacesMessage facesMessage = new FacesMessage
                (FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            context.addMessage(null, facesMessage);
        }
        
    return destinoSalvar;
    }
    
    public String editar(){
        return "/Logado/fornecedor";
    }
    
    public void excluir(){
        FacesContext context = FacesContext.getCurrentInstance();
        try{
            FornecedorRN fornecedorRN = new FornecedorRN();
            fornecedorRN.excluir(this.fornecedor);
            this.fornecedor = new Fornecedor();
            this.lista = null; 
        }catch (Exception e){
            FacesMessage facesMessage = new FacesMessage
                (FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            context.addMessage(null, facesMessage);
        }
    }
    
    
}
