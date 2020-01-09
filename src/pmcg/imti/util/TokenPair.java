package pmcg.imti.util;

/**
 * Simple container for a pair of tokens.
 */
public class TokenPair {
	public String evenToken;
	public long evenExpiration;
	public String oddToken;
	public long oddExpiration;

	/**
	 * Check if a given token matches any of the pair components.
	 * 
	 * @param aToken The token to verify.
	 * @return Weather aToken is a match for this pair.
	 */
	public boolean validate(String aToken) {
		return evenToken.equals(aToken) || oddToken.equals(aToken);
	}
}
