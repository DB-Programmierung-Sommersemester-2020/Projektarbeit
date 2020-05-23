package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.shop.Warenkorb;

@WebServlet("/kaufinfo")
public class KaufInfoServlet extends HttpServlet
{
   private static final long serialVersionUID = 1124L;

   public KaufInfoServlet()
   {
      super();
   }

   @Override
   public void init() throws ServletException
   {
      super.init();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
   {
      HttpSession session = request.getSession();
      Warenkorb wk = (Warenkorb) session.getAttribute("warenkorb");
      if (wk == null)
      {
         wk = new Warenkorb();
         session.setAttribute("warenkorb", wk);
      }

      request.setAttribute("warenkorb", wk);

      getServletContext().getRequestDispatcher("/kaufinformation.jsp").forward(request, response);
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
   {
      this.doGet(request, response);
   }

}
