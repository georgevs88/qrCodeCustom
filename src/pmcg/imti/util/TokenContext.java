package pmcg.imti.util;

import java.util.Date;

/**
 * A token context is a simple token generator and verifier that can be used to
 * inform a system that a user can be trusted without going through
 * authentication.
 * 
 * This context implements a dual token authentication system so that there is a
 * guarantee on the minimum duration of a valid token produced.
 * 
 * A token authentication mechanism works as a fast and simple way to inform
 * another system that a user is trusted.
 * 
 * It should always be protected by a layer of authentication at the generator
 * so that we can guarantee that if a user has the token, then the user can be
 * trusted.
 */
public class TokenContext {
	/**
	 * The duration of a token in milliseconds.
	 * 
	 * The default value is 6 minutes.
	 */
	private long duration;

	/**
	 * The time to start counting from.
	 * 
	 * The default value is the POSIX epoch start (1st of January 1970).
	 */
	private long start;

	/**
	 * The salt used.
	 */
	private String salt;

	/**
	 * Construct a new token context with a default start of zero and duration
	 * of 6 minutes.
	 * 
	 * @param salt
	 *            The salt for this generator.
	 */
	public TokenContext(String salt) {
		start = 0;
		duration = 6 * 60 * 1000;
		this.salt = salt;
	}

	public String getBest(String resource) {
		TokenPair p = getPair(resource);

		if (p.evenExpiration >= p.oddExpiration) {
			return p.evenToken;
		} else {
			return p.oddToken;
		}
	}

	/**
	 * Check if a token is valid for the current context and a given resource
	 * name.
	 * 
	 * @param resource
	 *            The resource.
	 * @param token
	 *            The token to validate.
	 * @return Weather the token is a match.
	 * @throws NoSuchAlgorithmException
	 * @throws IOException
	 */
	public boolean match(String resource, String token) {
		TokenPair p = getPair(resource);
		return p.validate(token);
	}

	/**
	 * Get the token pair for this generator.
	 * 
	 * @param resource
	 *            The resource that we desire to provide access through this
	 *            token.
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws IOException
	 */
	public TokenPair getPair(String resource) {
		long expiryEven, expiryOdd;
		Date current = new Date();

		/* Calculate the expiration time */
		expiryEven = start + ((current.getTime() - start + duration - 1) / duration) * duration;
		expiryOdd = start + ((current.getTime() - start + duration - 1 - duration / 2) / duration)
			* duration + duration / 2;

		TokenPair pair = new TokenPair();
		pair.evenToken = TokenGenerator.generate(salt, new Date(expiryEven), resource);
		pair.evenExpiration = expiryEven;
		pair.oddExpiration = expiryOdd;
		pair.oddToken = TokenGenerator.generate(salt, new Date(expiryOdd), resource);

		return pair;
	}

	/**
	 * Get the starting time for the tokens.
	 * 
	 * @see TokenContext#setStart(Date)
	 */
	public Date getStart() {
		return new Date(start);
	}

	/**
	 * Get the starting time for the tokens, this is only used to define the
	 * alignment of the time intervals.
	 * 
	 * @param start
	 *            The new starting time.
	 */
	public void setStart(Date start) {
		this.start = start.getTime();
	}

	/**
	 * Get the maximum duration (seconds) of a token.
	 */
	public long getDuration() {
		return duration / 1000;
	}

	/**
	 * Set the maximum duration (seconds) of a token.
	 * 
	 * The two generated tokens are interleaved so that one starts in the middle
	 * of the other. This guarantees that, when taking the token with the
	 * longest life span one will always have a token that is valid for at least
	 * half as long as the maximum duration.
	 */
	public void setDuration(long duration) {
		this.duration = duration * 1000;
	}

	/**
	 * Get the salt.
	 * 
	 * A unique salt is what guarantees that the token provided by this
	 * generator is different from one provided by another generator.
	 */
	public String getSalt() {
		return salt;
	}
}
