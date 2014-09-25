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
	public static String ConverttoMysqlDate(String date) throws Exception{
		String converteddate ="01-01-2014";
		if(date != null && !date.isEmpty()){
			SimpleDateFormat desiredDateformat = new SimpleDateFormat("yyyy-MM-dd");
			Date ordate = new SimpleDateFormat("dd-MM-yyyy").parse(date);
			converteddate = desiredDateformat.format(ordate);
		}
		 return converteddate;
	}
	public static String ConverttoNormalDate(String date) throws Exception{
		String converteddate = "01-01-2014";
		 SimpleDateFormat desiredDateformat = new SimpleDateFormat("dd-MM-yyyy");
		 if(date != null && !date.isEmpty()){ //Be sure to use the parts of && in this order, because java will not proceed to evaluating the the second if the first part of && fails, thus ensuring you will not get a null pointer exception from str.isEmpty() if str is null.
			 Date ordate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
			 converteddate = desiredDateformat.format(ordate);	
		}
		 return converteddate;
   }

}
