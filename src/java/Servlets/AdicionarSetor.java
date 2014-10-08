package Servlets;

    import Beans.Setor;
    import DAO.SetorDAO;
    import java.io.IOException;
    import java.util.logging.Level;
    import java.util.logging.Logger;
    import javax.servlet.RequestDispatcher;
    import javax.servlet.ServletException;
    import javax.servlet.annotation.WebServlet;
    import javax.servlet.http.HttpServlet;
    import javax.servlet.http.HttpServletRequest;
    import javax.servlet.http.HttpServletResponse; 

    @WebServlet (name = "AdicionarSetor", urlPatterns = {"/AdicionarSetor"})
    public class AdicionarSetor extends HttpServlet {
    
        protected void service (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            try {
                SetorDAO setorDAO = new SetorDAO();
                String acao = request.getParameter("acao");
                
                if (acao.equals("ExcluirSetor")) {
                    int idSetor = Integer.parseInt(request.getParameter("idSetor"));
                    
                    Setor setor = new Setor();
                    setor.setIdSetor(idSetor);
                    
                    setorDAO.ExcluirSetor(setor);
                    
                    
                    response.sendRedirect("Setor.jsp");
                    
                } else if(acao.equals("ModificarSetor")){
                    
                    int id = Integer.parseInt(request.getParameter("idSetor"));
                    String nome = request.getParameter("nome");
                    String sigla = request.getParameter("sigla");
                    String chefe = request.getParameter("chefe");
                    String telefone = request.getParameter("telefone");
                    
                    Setor setor = new Setor();
                    setor.setNome(nome);
                    setor.setSigla(sigla);
                    setor.setChefe(chefe);
                    setor.setTelefone(telefone);
                    setor.setIdSetor(id);
                    
                    setorDAO.ModificarSetor(setor);
                    
                    // response.sendRedirect("/Setor.jsp");
                    RequestDispatcher td = request.getRequestDispatcher("/Setor.jsp");
                    td.forward(request, response);
                    
                }else if(acao.equals("AdicionarSetor")){
                    String nome = request.getParameter("nome");
                    String sigla = request.getParameter("sigla");
                    String chefe = request.getParameter("chefe");
                    String telefone = request.getParameter("telefone");
                    
                    Setor setor = new Setor();
                    setor.setNome(nome);
                    setor.setSigla(sigla);
                    setor.setChefe(chefe);
                    setor.setTelefone(telefone);
                    
                    
                    setorDAO.AdicionarSetor(setor);
                    
                    RequestDispatcher rd = request.getRequestDispatcher("/Setor.jsp");
                    rd.forward(request, response);
                    
                }
            } catch (InstantiationException ex) {
                Logger.getLogger(AdicionarSetor.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
        }
}
