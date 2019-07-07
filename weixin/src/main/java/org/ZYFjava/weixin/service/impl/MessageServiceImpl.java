package org.ZYFjava.weixin.service.impl;

import org.ZYFjava.weixin.service.MessageService;
import org.fkjava.commons.domain.InMessage;
import org.fkjava.commons.domain.OutMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
@Service
public class MessageServiceImpl implements MessageService {

	private static final Logger LOG = LoggerFactory.getLogger(MessageServiceImpl.class);
	@Autowired 
	@Qualifier("inMessageTemplate") 
	private RedisTemplate<String, ? extends InMessage> inMessageTemplate;

	@Override
	public OutMessage onMessage(InMessage msg) {
		LOG.trace("转换后的消息对象：\n{}\n", msg);

	
		try {
			inMessageTemplate.convertAndSend("ZYF_" + msg.getMsgType(), msg);
		} catch (Exception e) {
			LOG.error("把转换的消息放入队列中出现问题：" + e.getLocalizedMessage(), e);
		}
		LOG.trace("转换后的消息对象已经放入队列中");
		return null;
	}
}
