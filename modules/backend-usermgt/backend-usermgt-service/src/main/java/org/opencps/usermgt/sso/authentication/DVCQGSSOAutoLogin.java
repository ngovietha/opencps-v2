package org.opencps.usermgt.sso.authentication;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.auto.login.AutoLogin;
import com.liferay.portal.kernel.security.auto.login.BaseAutoLogin;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.opencps.usermgt.model.Applicant;
import org.opencps.usermgt.service.ApplicantLocalServiceUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author trungnt
 *
 */
@Component(immediate = true, service = AutoLogin.class)
public class DVCQGSSOAutoLogin extends BaseAutoLogin {

	@Override
	protected String[] doLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {

		User user = getUser(request);

		if (user == null) {
			return null;
		}
		
		_log.info("--->>> DVCQGSSOAutoLogin");

		String[] credentials = new String[3];

		credentials[0] = String.valueOf(user.getUserId());
		credentials[1] = user.getPassword();
		credentials[2] = Boolean.FALSE.toString();

		return credentials;
	}

	protected User getUser(HttpServletRequest request) throws PortalException {

		HttpSession session = request.getSession();

		String mappingClassName = (String) session.getAttribute(_SESSION_API_PRIFIX + "_MAPPING_CLASS_NAME");

		String mappingClassPK = (String) session.getAttribute(_SESSION_API_PRIFIX + "_MAPPING_CLASS_PK");

		long groupId = GetterUtil.getLong(session.getAttribute(_SESSION_API_PRIFIX + "_GROUP_ID"));

		/*Enumeration<String> enumeration = session.getAttributeNames();
		
		List<String> values = Collections.list(enumeration);
		
		for (String value : values) {
			_log.info("========================== > session.getAttributeNames() " + value);
		}*/

		if (Validator.isNotNull(mappingClassName) && Validator.isNotNull(mappingClassPK)) {

			session.removeAttribute(_SESSION_API_PRIFIX + "_MAPPING_CLASS_NAME");
			session.removeAttribute(_SESSION_API_PRIFIX + "_MAPPING_CLASS_PK");
			session.removeAttribute(_SESSION_API_PRIFIX + "_GROUP_ID");
			Applicant applicant = ApplicantLocalServiceUtil.fetchByF_GID_MCN_MCPK(groupId, mappingClassName,
					mappingClassPK);

			if (applicant != null && applicant.getMappingUserId() > 0) {
				return _userLocalService.fetchUser(applicant.getMappingUserId());
			}
		}

		return null;
	}

	@Reference(unbind = "-")
	protected void setUserLocalService(UserLocalService userLocalService) {
		_userLocalService = userLocalService;
	}

	private UserLocalService _userLocalService;
	private String _SESSION_API_PRIFIX = "equinox.http.rest.v2";
	private Log _log = LogFactoryUtil.getLog(DVCQGSSOAutoLogin.class.getName());
}
