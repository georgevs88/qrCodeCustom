package pmcg.imti.util;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import javax.xml.bind.DatatypeConverter;

/**
 * Simple utility class to generate tokens.
 * 
 * Tokens are fixed expiration codes that allow one to enforce security using
 * "something you have" (the token generator).
 * 
 * The token is generated by concatenating a user defined salt, a timestamp and
 * a resource name into a string that is subsequently hashed with SHA-256 and
 * encoded into URL safe Base64.
 */
public class TokenGenerator {

	/**
	 * Generate a token.
	 * 
	 * @param salt
	 *            A user defined salt to make things harder to crack.
	 * @param t
	 *            The desired time.
	 * @param resource
	 *            A resource description so that the same timestamp/salt pair
	 *            can be used for multiple authentications.
	 * 
	 * @return The resulting token.
	 * @throws NoSuchAlgorithmException
	 * @throws IOException
	 */
	public static String generate(String salt, Date t, String resource) {
		try {
			MessageDigest md;
			md = MessageDigest.getInstance("SHA-256");

			byte[] bytes = (salt + t.toString() + resource).getBytes();
			bytes = md.digest(bytes);

			return new String(DatatypeConverter.printBase64Binary(bytes).replace('+', '-')
				.replace('/', '_').replace('=', ':'));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}
}