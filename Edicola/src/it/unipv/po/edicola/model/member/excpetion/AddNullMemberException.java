package it.unipv.po.edicola.model.member.excpetion;

public class AddNullMemberException extends Exception{
	private static final long serialVersionUID = -402113066218492025L;

	public AddNullMemberException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public AddNullMemberException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public AddNullMemberException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public AddNullMemberException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public AddNullMemberException(Throwable cause) {
		super(cause);
	}
	
	

}
