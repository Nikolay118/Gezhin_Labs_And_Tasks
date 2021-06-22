package Package1;
import java.net. *;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File. *;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class Crawler 
{
	public static final String URL_PREFIX = "http://";
	
	
	LinkedList <URLDepthPair> checkedSites = new LinkedList <URLDepthPair> ();
	LinkedList <URLDepthPair> uncheckedSites = new LinkedList <URLDepthPair> ();
	
	public void scanSite(URLDepthPair pair) throws UnknownHostException, IOException
	{
		StringBuffer result = new StringBuffer();
		if (pair.getPrefix().equals(URL_PREFIX) == true)
		{
			URL url = new URL(pair.getUrl());
			Socket socket = new Socket(url.getHost(), 80);
			socket.setSoTimeout(10000);

			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			out.write("GET / HTTP/1.1\r\n");
			out.write("Host: habr.com\r\n");
			out.write("Connection: keep-alive\r\n");
	        out.write("\r\n");
	        
			
			out.flush();
			
			
			String word = "0";
			while ((word = in.readLine()) != null)
			{
				System.out.println(word);
			}
			socket.close();
			in.close();
			out.close();
		}
	}
	
	public static void main(String[] args) throws UnknownHostException, IOException
	{
		
		URLDepthPair pair = new URLDepthPair("http://habr.com", 1);
		Crawler crawler = new Crawler();
		crawler.scanSite(pair);
	}
}


