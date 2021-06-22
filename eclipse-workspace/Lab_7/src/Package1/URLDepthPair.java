package Package1;

public class URLDepthPair {
	
	String url;
	static int depth;
	
	
	public URLDepthPair(String new_url, int new_depth)
	{
		url = new_url;
		depth = new_depth;
	}
	
	public String pairToString()
	{
		return ("url:" + url + ";depth:" + depth);
	}
		
	public String getPrefix()
	{
			return url.substring(0, 7);
	}
		
	public String getUrl()
	{
			return url;
	}
		
	public int getDepth()
	{
		return depth;
	}
}
