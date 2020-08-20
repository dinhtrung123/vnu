package org.oep.danhmuc.exception;
import com.liferay.portal.kernel.exception.PortalException;

public class DuplicateNameException extends PortalException{
	public DuplicateNameException() {
		super();
	}

	public DuplicateNameException(String msg) {
		super(msg);
	}

	public DuplicateNameException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public DuplicateNameException(Throwable cause) {
		super(cause);
	}
}
