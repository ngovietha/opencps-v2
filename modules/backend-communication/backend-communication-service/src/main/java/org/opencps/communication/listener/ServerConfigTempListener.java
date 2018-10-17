package org.opencps.communication.listener;

import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;

import org.apache.commons.lang3.StringEscapeUtils;
import org.opencps.communication.model.ServerConfig;
import org.osgi.service.component.annotations.Component;

@Component(immediate = true, service = ModelListener.class)
public class ServerConfigTempListener extends BaseModelListener<ServerConfig> {

	@Override
	public void onAfterCreate(ServerConfig model) throws ModelListenerException {
	}

	@Override
	public void onAfterUpdate(ServerConfig model) throws ModelListenerException {
	}

	@Override
	public void onBeforeCreate(ServerConfig model) throws ModelListenerException {
//		try {
//			model.setGovAgencyCode(StringEscapeUtils.escapeHtml4(model.getGovAgencyCode()));
//			model.setServerNo(StringEscapeUtils.escapeHtml4(model.getServerNo()));
//			model.setServerName(StringEscapeUtils.escapeHtml4(model.getServerName()));
//			model.setProtocol(StringEscapeUtils.escapeHtml4(model.getProtocol()));
//			//model.setConfigs(StringEscapeUtils.escapeHtml4(model.getConfigs()));
//
//		} catch (Exception e) {
//			_log.error(e);
//		}
	}

	@Override
	public void onBeforeUpdate(ServerConfig model) throws ModelListenerException {
//		try {
//			model.setGovAgencyCode(StringEscapeUtils.escapeHtml4(model.getGovAgencyCode()));
//			model.setServerNo(StringEscapeUtils.escapeHtml4(model.getServerNo()));
//			model.setServerName(StringEscapeUtils.escapeHtml4(model.getServerName()));
//			model.setProtocol(StringEscapeUtils.escapeHtml4(model.getProtocol()));
//			//model.setConfigs(StringEscapeUtils.escapeHtml4(model.getConfigs()));
//
//		} catch (Exception e) {
//			_log.error(e);
//		}
	}


	private Log _log = LogFactoryUtil.getLog(NotificationTemplateTempListener.class.getName());
}