package com.jd.app.beans.postlogin;

import com.jd.app.beans.common.SharedBean;

public class MessageBean extends SharedBean {

	private String messageId;
	private String senderId;
	private String receiverId;
	private String senderName;
	private String receiverFirstname;
	private String sentAt;
	private String deliveredAt;
	private String readAt;
	private String content;
	private boolean hasAttachment;
	private String avatar;

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
	 * @return the receiverId
	 */
	public final String getReceiverId() {
		return receiverId;
	}

	/**
	 * @param receiverId
	 *            the receiverId to set
	 */
	public final void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
	}

	/**
	 * @return the senderName
	 */
	public final String getSenderName() {
		return senderName;
	}

	/**
	 * @param senderName
	 *            the senderName to set
	 */
	public final void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	/**
	 * @return the receiverFirstname
	 */
	public final String getReceiverFirstname() {
		return receiverFirstname;
	}

	/**
	 * @param receiverFirstname
	 *            the receiverFirstname to set
	 */
	public final void setReceiverFirstname(String receiverFirstname) {
		this.receiverFirstname = receiverFirstname;
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
	 * @return the content
	 */
	public final String getContent() {
		return content;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public final void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the hasAttachment
	 */
	public final boolean isHasAttachment() {
		return hasAttachment;
	}

	/**
	 * @param hasAttachment
	 *            the hasAttachment to set
	 */
	public final void setHasAttachment(boolean hasAttachment) {
		this.hasAttachment = hasAttachment;
	}

	/**
	 * @return the avatar
	 */
	public final String getAvatar() {
		return avatar;
	}

	/**
	 * @param avatar
	 *            the avatar to set
	 */
	public final void setAvatar(String avatar) {
		this.avatar = avatar;
	}
}
