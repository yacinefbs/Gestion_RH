package defaults;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import ma.bps.dao.SalarieDaoImpl;
import ma.bps.entities.Salaries;
import ma.bps.metier.ISalarieMetier;
import ma.bps.metier.SalarieMetierImpl;

public class testAhmed {

	
	public static void main(String[] args) throws UnsupportedEncodingException, ParseException {
		// TODO Auto-generated method stub

//		System.out.println( System.getProperty( "catalina.base" ));
//		
//		String ch = "adzee/dzzdzd/123456.jpg";
//		System.out.println(ch.substring(ch.lastIndexOf("/")+1,ch.length()));
		
//		ISalarieMetier metier = new SalarieMetierImpl();
//		
//		Salaries s = metier.getSalarieById(1L);
//		
//		System.out.println(s.getContrats().size());
		
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date maDate = dateFormat.parse("2006-11-12 15:17:36");
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.HOUR, -1);
        Date result = cal.getTime();
        System.out.println(dateFormat.format(result));
				
		
	}

}
