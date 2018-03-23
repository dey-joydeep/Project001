package com.jd.app.websocket;

public class MessageHolder {

	private String messageId;
	private String senderId;
	private String recieverId;
	private String file;
	private String message;
	private String sentAt;
	private String deliveredAt;
	private String readAt;
	private String deliveryStatus;

	/**
	 * @return the messageId
	 */
	public final String getMessageId() {
		return messageId;
	}

	/**
	 * @param messageId
	 *            the messageId to set
	 */
	public final void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	/**
	 * @return the senderId
	 */
	public final String getSenderId() {
		return senderId;
	}

	/**
	 * @param senderId
	 *            the senderId to set
	 */
	public final void setSenderId(String senderId) {
		this.senderId = senderId;
	}

	/**
	 * @return the recieverId
	 */
	public final String getRecieverId() {
		return recieverId;
	}

	/**
	 * @param recieverId
	 *            the recieverId to set
	 */
	public final void setRecieverId(String recieverId) {
		this.recieverId = recieverId;
	}

	/**
	 * @return the file
	 */
	public final String getFile() {
		return file;
	}

	/**
	 * @param file
	 *            the file to set
	 */
	public final void setFile(String file) {
		this.file = file;
	}

	/**
	 * @return the message
	 */
	public final String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public final void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the sentAt
	 */
	public final String getSentAt() {
		return sentAt;
	}

	/**
	 * @param sentAt
	 *            the sentAt to set
	 */
	public final void setSentAt(String sentAt) {
		this.sentAt = sentAt;
	}

	/**
	 * @return the deliveredAt
	 */
	public final String getDeliveredAt() {
		return deliveredAt;
	}

	/**
	 * @param deliveredAt
	 *            the deliveredAt to set
	 */
	public final void setDeliveredAt(String deliveredAt) {
		this.deliveredAt = deliveredAt;
	}

	/**
	 * @return the readAt
	 */
	public final String getReadAt() {
		return readAt;
	}

	/**
	 * @param readAt
	 *            the readAt to set
	 */
	public final void setReadAt(String readAt) {
		this.readAt = readAt;
	}

	/**
	 * @return the deliveryStatus
	 */
	public final String getDeliveryStatus() {
		return deliveryStatus;
	}

	/**
	 * @param deliveryStatus
	 *            the deliveryStatus to set
	 */
	public final void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}
}
