package plz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ort")
public class OrtServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	private PLZDataStructure plzData = null;

    public OrtServlet() 
    {
        super();
    }

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
	
		String suchPlz = request.getParameter("plz");
	
		if( suchPlz == null )
		{
		   out.println("falscher Parameter");
		   out.println("Aufruf /ort?plz=xxxxx");
		   return;
		}
		
		if( suchPlz.length() != 5 )
		{
		   out.print("---");
		   return;
		}
		
		try
      { 
         Integer.parseInt(suchPlz);
      }
      catch( NumberFormatException exce)
      {
         out.print("---");
         return;
      }
		
		String[] orte = this.plzData.searchOrteWithPlz(suchPlz);
		
		for (String ort : orte)
		{
			out.println( ort + ";");
		}
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

	@Override
	public void destroy()
	{
		super.destroy();
		this.plzData = null;
	}

	@Override
	public void init() throws ServletException
	{
		super.init();
		
		if( this.plzData == null )
		{
			this.plzData = new PLZDataStructure();
			try
			{
				this.loadPLZ();
			}
			catch( IOException exce )
			{
				System.err.println( exce.getMessage() );
				throw new ServletException( exce );
			}
		}
	}
	
	public void loadPLZ() throws IOException
	{
		ServletContext context = this.getServletContext();
		InputStream inStream = context.getResourceAsStream("/WEB-INF/plz.txt");
		
		if (inStream != null) 
		{
		   InputStreamReader inReader = new InputStreamReader(inStream,"UTF-16");
		   BufferedReader reader = new BufferedReader(inReader);
		   
		   String line = null;
		   while ((line = reader.readLine()) != null) 
		   {
			   	String[] res = line.split("\\s+");
				
				String plz = res[0];
				String ort = "";
				for(int i=1; i<res.length; i++)
				{
					ort += res[i]+" ";
				}
				this.plzData.add( plz, ort.trim() );
		   }
		
		   reader.close();
		   inReader.close();
		   inStream.close();
		}
	}

}
