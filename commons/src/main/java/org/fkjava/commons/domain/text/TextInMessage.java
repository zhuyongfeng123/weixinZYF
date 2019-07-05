package org.fkjava.commons.domain.text;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.fkjava.commons.domain.InMessage;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement(name = "xml") 
@XmlAccessorType(XmlAccessType.FIELD) 
public class TextInMessage extends InMessage {
	private static final long serialVersionUID = 1L;
	@XmlElement(name = "Content")
	@JsonProperty("Content")
	private String content;

	public TextInMessage() {
		super("text");
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "TextInMessage [content=" + content + ", getToUserName()=" + getToUserName() + ", getFromUserName()="
				+ getFromUserName() + ", getCreateTime()=" + getCreateTime() + ", getMsgType()=" + getMsgType()
				+ ", getMsgId()=" + getMsgId() + "]";
	}
}
