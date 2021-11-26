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
import produto.Produto;
import produto.ProdutoRN;
import util.RelatorioUtil;



@Named
@RequestScoped
public class ProdutoBean {
    private Produto produto = new Produto();
    private List<Produto> lista = null;
    private String destinoSalvar = "produto";
    
    public Produto getProduto(){
        return produto;
    }
    
    public void setProduto (Produto produto){
        this.produto = produto;
    }
    public List<Produto> getLista(){
        if (this.lista==null){
            ProdutoRN produtoRN = new ProdutoRN();
            this.lista = produtoRN.listar();
        }
        return this.lista;
    }
    
    public String salvar(){
        FacesContext context = FacesContext.getCurrentInstance();
        try{
            ProdutoRN produtoRN = new ProdutoRN();
            produtoRN.salvar(this.produto);
            this.produto = new Produto();
            this.lista = null;
        }catch (Exception e){
            FacesMessage facesMessage = new FacesMessage
                (FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            context.addMessage(null, facesMessage);
        }
        
    return destinoSalvar;
    }
    
    public String editar(){
        return "produtoEditar";
    }
    
    public void excluir(){
        FacesContext context = FacesContext.getCurrentInstance();
        try{
            ProdutoRN produtoRN = new ProdutoRN();
            produtoRN.excluir(this.produto);
            this.produto = new Produto();
            this.lista = null; 
        }catch (Exception e){
            FacesMessage facesMessage = new FacesMessage
                (FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            context.addMessage(null, facesMessage);
        }
    }
    
     public void gerarRelatorioAction() throws Exception {
            RelatorioUtil relatorio = new RelatorioUtil();
            relatorio.getRelatorio();
    
            
}
}
