package it.unipv.po.edicola.model.member.excpetion;

public class AddEmailMemberException extends Exception{
	private static final long serialVersionUID = -6045133770862424523L;

	public AddEmailMemberException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public AddEmailMemberException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public AddEmailMemberException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public AddEmailMemberException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public AddEmailMemberException(Throwable cause) {
		super(cause);
	}

}
