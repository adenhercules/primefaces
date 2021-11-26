/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;


public class RelatorioUtil {
        private HttpServletResponse response;
        private FacesContext context;
        private ByteArrayOutputStream baos;
        private InputStream stream;
        private Connection con;
        
        public RelatorioUtil(){
            this.context = FacesContext.getCurrentInstance();
            this.response = (HttpServletResponse) context.getExternalContext().getResponse();           
        }
        
        public void getRelatorio() throws Exception {
            stream = this.getClass().getResourceAsStream("/relatorio/produtosIDW.jasper");
            Map<String, Object> params = new HashMap<String, Object>();
            baos = new ByteArrayOutputStream();
            try{
                JasperReport report = (JasperReport) JRLoader.loadObject(stream);
                JasperPrint print = JasperFillManager.fillReport(report, params, getConexao());
                JasperExportManager.exportReportToPdfStream(print, baos);
                response.reset();
                response.setContentType("application/pdf");
                response.setContentLength(baos.size());
                response.setHeader("Content-disposition", "inline: filename=relatorio.pdf");
                response.getOutputStream().write(baos.toByteArray());
                response.getOutputStream().flush();
                response.getOutputStream().close();
                context.responseComplete();
                fecharConexao();
                       
            } catch (JRException ex){
                Logger.getLogger(RelatorioUtil.class.getName()).log(Level.SEVERE,null,ex);
                
            } catch (IOException ex){
                Logger.getLogger(RelatorioUtil.class.getName()).log(Level.SEVERE,null,ex);

            }
        }
        
        public void fecharConexao(){
            try{
                con.close();
                
            } catch (SQLException ex){
                Logger.getLogger(RelatorioUtil.class.getName()).log(Level.SEVERE,null,ex);

            }
        }
        
        private Connection getConexao() throws UtilException, Exception {
            try{
                Class.forName("com.mysql.jdbc.Driver");
                con=DriverManager.getConnection("jdbc:mysql://localhost/primefaces?useSSL=FALSE", "root", "adenserver");
                return con;
            } catch (SQLException ex){
                throw new Exception("Ocorreu um erro de SQL");
            } catch (ClassNotFoundException ex) {
                throw new Exception("Ocorreu um erro, classe não encontrada");
            }
        }
        

        
}

