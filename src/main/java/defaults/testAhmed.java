package defaults;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class testAhmed {

	
	
	public testAhmed() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void getPath() throws UnsupportedEncodingException {

		String path = this.getClass().getClassLoader().getResource("").getPath();

		String fullPath = URLDecoder.decode(path, "UTF-8");

		String pathArr[] = fullPath.split("/WEB-INF/classes/");

		System.out.println(fullPath);

		System.out.println(pathArr[0]);

		fullPath = pathArr[0];

		path.substring(0, 17);

		String reponsePath = "";

// to read a file from webcontent
//
//		reponsePath = new File(fullPath).getPath() + File.separatorChar + "newfile.txt";
//
//		return reponsePath;

	}
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub

		System.out.println( System.getProperty( "catalina.base" ));
		
		String ch = "adzee/dzzdzd/123456.jpg";
		System.out.println(ch.substring(ch.lastIndexOf("/")+1,ch.length()));
				
		
	}

}
