package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.shop.Buch;
import model.shop.ModelFacade;

@WebServlet("/detail")
public class BuchdetailServlet extends HttpServlet
{
   private static final long serialVersionUID = 1124L;
   
   private ModelFacade facade = null;

   public BuchdetailServlet()
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
      String buchid = request.getParameter("buchid");
      
      Buch  buch = this.facade.findBuchById( Integer.parseInt(buchid) );
      request.setAttribute("buch", buch );
      
      getServletContext().getRequestDispatcher("/buchdetail.jsp").forward(request, response);
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
   {
      this.doGet(request, response);
   }

}
