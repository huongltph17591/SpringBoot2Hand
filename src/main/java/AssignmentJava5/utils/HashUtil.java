package AssignmentJava5.utils;

import org.mindrot.jbcrypt.BCrypt;

public class HashUtil {
public static String hash(String origin) {
		
		String pwd =BCrypt.gensalt();
		return BCrypt.hashpw(origin, pwd);
	}
	
	public static boolean verify(String origin,String encrypted) {
		return BCrypt.checkpw(origin, encrypted);
	}
}
