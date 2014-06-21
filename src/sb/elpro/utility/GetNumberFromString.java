/**
* This class draws .
* @author Wahab
* @version 1.2
*/

package sb.elpro.utility;


/**
 * @author Wahab
 * Get the Int/Float from a String 
 * 
 */
public class GetNumberFromString {
	public static float GetFloatFromString(String mystring) throws Exception{
		float numberfromString = Float.parseFloat(mystring.replaceAll("[^\\d.]+|\\.(?!\\d)", ""));
		System.out.println("numberfromString "+numberfromString);
		return numberfromString;
	}
	public static int GetIntFromString(String mystring) throws Exception{
		int numberfromString = Integer.parseInt(mystring.replaceAll("[\\D]", ""));
		System.out.println("numberfromString "+numberfromString);
		return numberfromString;
	}
}
