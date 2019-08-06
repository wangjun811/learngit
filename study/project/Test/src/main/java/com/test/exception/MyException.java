package com.test.exception;

/**
 * �Զ����쳣��(�̳�����ʱ�쳣)
 * 
 * @author AlanLee
 * @version 2016/11/26
 */
public class MyException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * �������
	 */
	private String errorCode;

	/**
	 * ��Ϣ�Ƿ�Ϊ�����ļ��е�Key
	 */
	private boolean propertiesKey = true;

	/**
	 * ����һ�������쳣.
	 *
	 * @param message
	 *            ��Ϣ����
	 */
	public MyException(String message) {
		super(message);
	}

	/**
	 * ����һ�������쳣.
	 *
	 * @param errorCode
	 *            �������
	 * @param message
	 *            ��Ϣ����
	 */
	public MyException(String errorCode, String message) {
		this(errorCode, message, true);
	}

	/**
	 * ����һ�������쳣.
	 *
	 * @param errorCode
	 *            �������
	 * @param message
	 *            ��Ϣ����
	 */
	public MyException(String errorCode, String message, Throwable cause) {
		this(errorCode, message, cause, true);
	}

	/**
	 * ����һ�������쳣.
	 *
	 * @param errorCode
	 *            �������
	 * @param message
	 *            ��Ϣ����
	 * @param propertiesKey
	 *            ��Ϣ�Ƿ�Ϊ�����ļ��е�Key
	 */
	public MyException(String errorCode, String message, boolean propertiesKey) {
		super(message);
		this.setErrorCode(errorCode);
		this.setPropertiesKey(propertiesKey);
	}

	/**
	 * ����һ�������쳣.
	 *
	 * @param errorCode
	 *            �������
	 * @param message
	 *            ��Ϣ����
	 */
	public MyException(String errorCode, String message, Throwable cause, boolean propertiesKey) {
		super(message, cause);
		this.setErrorCode(errorCode);
		this.setPropertiesKey(propertiesKey);
	}

	/**
	 * ����һ�������쳣.
	 *
	 * @param message
	 *            ��Ϣ����
	 * @param cause
	 *            ���쳣�ࣨ���Դ����κ��쳣��
	 */
	public MyException(String message, Throwable cause) {
		super(message, cause);
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public boolean isPropertiesKey() {
		return propertiesKey;
	}

	public void setPropertiesKey(boolean propertiesKey) {
		this.propertiesKey = propertiesKey;
	}

}