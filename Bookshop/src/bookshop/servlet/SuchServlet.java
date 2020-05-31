package servlet;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.shop.Buch;
import model.shop.ModelFacade;

@WebServlet("/suche")
public class SuchServlet extends HttpServlet
{
   private static final long serialVersionUID = 1123L;
   
   private ModelFacade facade = null;

   public SuchServlet()
   {
      super();
   }
   
   @Override
   public void init() throws ServletException
   {
      super.init();
      this.facade = ModelFacade.getInstance();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
   {
      String autorname = request.getParameter("autorname");
      Collection<Buch>  buecher = this.facade.findBuecherFromAutor(autorname);
      request.setAttribute("buecher", buecher );
      
      getServletContext().getRequestDispatcher("/suchergebnis.jsp").forward(request, response);
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
   {
      this.doGet(request, response);
   }
}
