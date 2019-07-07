package org.ZYFjava.weixin.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.fkjava.commons.domain.InMessage;
import org.fkjava.commons.domain.event.EventInMessage;
import org.fkjava.commons.domain.text.TextInMessage;
public class MessageTypeRegister {

	private static Map<String, Class<? extends InMessage>> typeMap = new ConcurrentHashMap<>();

	static {
		register("text", TextInMessage.class);
		register("event", EventInMessage.class);
		register("location", TextInMessage.class);
		register("image", TextInMessage.class);
		register("video", TextInMessage.class);
		register("shortvideo", TextInMessage.class);
		register("voice", TextInMessage.class);
	}
	public static void register(String type, Class<? extends InMessage> cla) {
		typeMap.put(type, cla);
	}
	public static Class<? extends InMessage> getClass(String type) {
		return typeMap.get(type);
	}
}
