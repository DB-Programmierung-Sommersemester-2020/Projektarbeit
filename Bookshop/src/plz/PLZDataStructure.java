package plz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PLZDataStructure
{
	private final int PLZ_MAX = 100000;
	
	private List<List<String>> plzToOrt = null;
	private Map<String, List<String>> ortToPlz = null;
	
	public PLZDataStructure()
	{
		super();
		
		this.plzToOrt = new ArrayList<List<String>>(PLZ_MAX);
		for( int i=0; i < PLZ_MAX; i++ )
		{
			this.plzToOrt.add( new ArrayList<String>() );
		}
		
		this.ortToPlz = new HashMap<String,List<String>>();
	}
	
	public void add(String plz, String ort)
	{
		if( this.ortToPlz.containsKey(ort) )
		{
			List<String> tmp = this.ortToPlz.get(ort);
			tmp.add(plz);
		}
		else
		{
			List<String> tmp = new ArrayList<String>();
			tmp.add(plz);
			this.ortToPlz.put(ort, tmp);
		}
			
		
		int pos = Integer.parseInt(plz);
		this.plzToOrt.get(pos).add(ort);
	}
	
	public String[] getOrte(String plz)
	{
		int pos = Integer.parseInt(plz);
		String[] res = new String[ this.plzToOrt.get(pos).size() ];
		return this.plzToOrt.get(pos).toArray( res );
	}
	
	public String[] searchOrteWithPlz(String searchPlz)
	{
		List<String> orte = new ArrayList<String>();
		
		String start = searchPlz;
		String end   = String.valueOf( Integer.parseInt(searchPlz) + 1 );
		
		while( start.length() < 5 )
		{
			start += "0";
		}
		while( end.length() < 5 )
		{
			end += "0";
		}
		
		int startPlz = Integer.parseInt(start);
		int endPlz   = Integer.parseInt(end);
		
		if( searchPlz.charAt(0) == '0' )
		{
			endPlz /= 10;
		}
			
		
		for(int plz = startPlz; plz< endPlz; plz++ )
		{
			String[] plzOrt = getOrte( String.valueOf(plz));
			for( String o : plzOrt )
			{
				String tmp = String.valueOf(plz);
				if( tmp.length() == 4 )
				{
					tmp = "0" + tmp;
				}
				orte.add( tmp + " " + o );
			}
		}
		
		String[] tmp = new String[ orte.size() ];
		return orte.toArray(tmp); 
	}
	
	public String[] getPlz(String ort)
	{
		List<String> res = this.ortToPlz.get(ort);
		if( res != null )
		{
			return res.toArray( new String[res.size()] );
		}
		else
		{
			return (String[]) null;
		}
	}
	
	public String getPlzListAsXML()
	{
		StringBuilder strbuilder = new StringBuilder();
		int count = 1;
		
		strbuilder.append("<plzliste> \n");
		for(int i=0; i <PLZ_MAX; i++)
		{
			String[] orte = this.getOrte( String.valueOf(i) );
			if( orte != null )
			{
				for (int j = 0; j < orte.length; j++)
				{
					strbuilder.append(" <entry id=\"" + count + "\">\n  <plz>" + i + "</plz>\n  <ort>" + orte[j] + "</ort>\n </entry> \n");
					count++;
				}
			}
		}
		strbuilder.append("</plzliste>");
		
		return strbuilder.toString();
	}
}
