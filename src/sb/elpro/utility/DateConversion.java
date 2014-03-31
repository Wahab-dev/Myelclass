/**
* This class draws .
* @author Wahab
* @version 1.2
*/

package sb.elpro.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Wahab
 *
 */
public class DateConversion {
	public static String ConverttoMysqlDate(String Date) throws Exception{
		System.out.println("Convert Normal Date to MySqlDate");
		 SimpleDateFormat desiredDateformat = new SimpleDateFormat("yyyy-MM-dd");
		 Date ordate = new SimpleDateFormat("dd-MM-yyyy").parse(Date);
		 String converteddate = desiredDateformat.format(ordate);	
		 System.out.println(" converteddate "+converteddate);
		 return converteddate;
	}
	public static String ConverttoNormalDate(String Date) throws Exception{
		System.out.println("Convert Mysql date To Normal Date ..... "+Date);
		String converteddate = "";
		 SimpleDateFormat desiredDateformat = new SimpleDateFormat("dd-MM-yyyy");
		/* if(Date.equals(null)	 || Date.equalsIgnoreCase("null") || Date.trim().length() == 0){
			 converteddate = "01-01-2014";
		 }else{*/
			 Date ordate = new SimpleDateFormat("yyyy-MM-dd").parse(Date);
			  converteddate = desiredDateformat.format(ordate);	
			 System.out.println(" converteddate "+converteddate);
		// }
		System.out.println(converteddate+"converteddate");
		 return converteddate;
   }

}
