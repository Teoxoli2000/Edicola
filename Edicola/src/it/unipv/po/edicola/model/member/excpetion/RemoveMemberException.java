package it.unipv.po.edicola.model.member.excpetion;

public class RemoveMemberException extends Exception {
	private static final long serialVersionUID = 916714655483896578L;

	public RemoveMemberException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public RemoveMemberException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public RemoveMemberException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public RemoveMemberException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public RemoveMemberException(Throwable cause) {
		super(cause);
	}

}
