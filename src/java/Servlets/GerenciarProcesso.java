/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Beans.File;
import Beans.Processo;
import DAO.ProcessoDAO;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
/**
 *
 * @author Thales
 */
@MultipartConfig
public class GerenciarProcesso extends HttpServlet {
        @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
            ProcessoDAO processoDAO = null;
            try {
                processoDAO = new ProcessoDAO();
            } catch (InstantiationException ex) {
                Logger.getLogger(GerenciarProcesso.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Processo processo = new Processo();
            
            // --------------- UPLOAD ----------------------
        DiskFileItemFactory dfif = new DiskFileItemFactory();
        ServletFileUpload sfu = new ServletFileUpload(dfif);

        if (!ServletFileUpload.isMultipartContent(request)) {
              // tratar erro
        }

        try {
            List items = sfu.parseRequest(request);
            
            FileItem descFI = (FileItem) items.get(0);
            String assunto = descFI.getString();
            
            FileItem tipoProcessoFI = (FileItem) items.get(1);
            String tipoProcesso = tipoProcessoFI.getString();
            
            FileItem fileFI = (FileItem) items.get(2);
            byte[] bytes = read(fileFI);
            
            
            
            
            //processo.setIdUsuario(id_usuario); // PRONTO
            //processo.setIdSetor(1); // A FAZER - PEGAR O SETOR DO ID A CIMA
            ///////////////////////////// dataaaaaaaaaaaaaaaaaaaaaa
            Date data = new Date(System.currentTimeMillis());    
            SimpleDateFormat formatarDate = new SimpleDateFormat("dd-MM-yyyy");     
            String data_criacao = formatarDate.format(data);
            //////////////////////////////////////////////////////
            
            File file = new File();                   
            file.setDescription(fileFI.getContentType());
            file.setName(fileFI.getName());
            file.setData(bytes);

//            FileDao fdao = new FileDaoImpl();
//            fdao.add(file);
            
            HttpSession session = request.getSession(); 
            ServletContext context = session.getServletContext(); 
            String realContextPath = context.getRealPath(request.getContextPath()); 
            
            java.io.File uploadedFile = new java.io.File("C:\\processos/"+new java.util.Date().getTime()+"_"+fileFI.getName());
            String Path_processo = "C:\\processos/"+new java.util.Date().getTime()+"_"+fileFI.getName();
            fileFI.write(uploadedFile);
            
            
            int i = Integer.parseInt(request.getParameter("id_user"));
            int idSetor = Integer.parseInt(request.getParameter("setor"));
            processo.setIdUsuario(i);
            processo.setIdSetor(idSetor);
            processo.setAssunto(assunto);
            processo.setTipoProcesso(tipoProcesso); 
            processo.setCaminhoArquivo(Path_processo); // PRONTO
            processo.setDataAbertura(data_criacao); // PRONTO
            processo.setSetorAtual("0"); // PRONTO
            processo.setSituacao("Em Andamento"); // PRONTO
             
            
            
            processoDAO.AdicionaProcesso(processo);
            
            
        } catch (FileUploadException e) {
            // tratar erro
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        //response.sendRedirect("novoProcesso.jsp");
            
            //----------------------------------------------
            response.sendRedirect(request.getContextPath() + "/novoProcesso.jsp");
         

        
        }
        
        	private byte[] read(FileItem fi) throws IOException{
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		InputStream is = fi.getInputStream();
		int read = 0;
		final byte[] b = new byte[1024];

		while ((read = is.read(b)) != -1) {
			out.write(b, 0, read);
		}
		return out.toByteArray();
	}
}


