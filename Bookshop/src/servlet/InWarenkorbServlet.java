package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.shop.Buch;
import model.shop.ModelFacade;
import model.shop.Warenkorb;

@WebServlet("/warenkorb")
public class InWarenkorbServlet extends HttpServlet
{
   private static final long serialVersionUID = 1124L;

   private ModelFacade facade = null;

   public InWarenkorbServlet()
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

      HttpSession session = request.getSession();
      Warenkorb wk = (Warenkorb) session.getAttribute("warenkorb");
      if (wk == null)
      {
         wk = new Warenkorb();
         session.setAttribute("warenkorb", wk);
      }

      if (buchid != null)
      {
         Buch buch = this.facade.findBuchById(Integer.parseInt(buchid));
         wk.addBuch(buch);
      }

      request.setAttribute("warenkorb", wk);

      getServletContext().getRequestDispatcher("/warenkorb.jsp").forward(request, response);
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
   {
      this.doGet(request, response);
   }

}
