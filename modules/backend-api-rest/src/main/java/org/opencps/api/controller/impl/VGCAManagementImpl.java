package org.opencps.api.controller.impl;

import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.util.DLUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.opencps.api.constants.ConstantUtils;
import org.opencps.api.controller.VGCAManagement;
import org.opencps.api.controller.util.MessageUtil;
import org.opencps.auth.utils.DLFolderUtil;

public class VGCAManagementImpl implements VGCAManagement {

	@Override
	public Response vgcaUploadController(HttpServletRequest request, HttpHeaders header, Company company, Locale locale,
			User user, ServiceContext serviceContext, Attachment file) {
		JSONObject result = JSONFactoryUtil.createJSONObject();

		if (file.getDataHandler() != null) {
			result.put(ConstantUtils.VGCA_STATUS, true);		
//			System.out.println("User: " + user.getUserId());
			try {
				FileEntry fileEntry = null;
				InputStream inputStream = file.getDataHandler().getInputStream();
				String sourceFileName = file.getDataHandler().getName();
				String fileType = StringPool.BLANK;
				long fileSize = 0;
				String destination = StringPool.BLANK;
//				System.out.println("FILE NAME: " + sourceFileName);
				if (inputStream != null && Validator.isNotNull(sourceFileName)) {
					
					if(Validator.isNull(fileType)) {
						fileType = MimeTypesUtil.getContentType(sourceFileName);
					}
					
					if(fileSize == 0) {
						fileSize = inputStream.available();
					}
//					System.out.println("FILE NAME: " + fileType);
					String ext = FileUtil.getExtension(sourceFileName);					
					String title = Validator.isNotNull(ext) ? (System.currentTimeMillis() + StringPool.PERIOD + ext) :  String.valueOf(System.currentTimeMillis());

					serviceContext.setAddGroupPermissions(true);
					serviceContext.setAddGuestPermissions(true);

					Calendar calendar = Calendar.getInstance();

					calendar.setTime(new Date());
					
					if (destination == null) {
						destination = StringPool.BLANK;
					}

					destination += calendar.get(Calendar.YEAR) + StringPool.SLASH;
					destination += calendar.get(Calendar.MONTH) + StringPool.SLASH;
					destination += calendar.get(Calendar.DAY_OF_MONTH);
//					System.out.println("FILE NAME: " + destination);
					DLFolder dlFolder = DLFolderUtil.getTargetFolder(user.getUserId(), serviceContext.getScopeGroupId(), serviceContext.getScopeGroupId(), false, 0, destination,
							StringPool.BLANK, false, serviceContext);

					PermissionChecker checker = PermissionCheckerFactoryUtil.create(user);
					PermissionThreadLocal.setPermissionChecker(checker);
					JSONObject fileServerObj = JSONFactoryUtil.createJSONObject();
					
					fileEntry = DLAppLocalServiceUtil.addFileEntry(user.getUserId(), serviceContext.getScopeGroupId(), dlFolder.getFolderId(), title,
						fileType, title, title,
						StringPool.BLANK, inputStream, fileSize, serviceContext);
//					System.out.println("File entry: " + fileEntry);
					String fileName = DLUtil.getPreviewURL(fileEntry, fileEntry.getFileVersion(), (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY), StringPool.BLANK);
//					System.out.println("File name: " + fileName);
					URL url = new URL(request.getAttribute(WebKeys.CURRENT_COMPLETE_URL).toString());
			        String host = url.getHost();
					result.put(ConstantUtils.VGCA_FILENAME, fileName);
					if (fileEntry != null) {
						fileServerObj.put(ConstantUtils.VGCA_FILEENTRYID, fileEntry.getFileEntryId());
						String urlPath = String.format(MessageUtil.getMessage(ConstantUtils.VGCA_URL_PATH), url.getProtocol(), host, (url.getPort() == -1 ? 80 : url.getPort()), fileName);
						
						fileServerObj.put(ConstantUtils.VGCA_URL, urlPath);
						result.put(ConstantUtils.VGCA_FILESERVER, fileServerObj.toJSONString());
					}
				}
				
				
			} catch (IOException e) {
				_log.debug(e);
			} catch (Exception e) {
				_log.debug(e);
			}
			
			result.put(ConstantUtils.VGCA_DOCUMENTNUMBER, StringPool.BLANK);	
		}
		else {
			result.put(ConstantUtils.VGCA_STATUS, false);			
		}
		
		return Response.status(200).entity(result.toJSONString()).build();
	}

	private static final Log _log = LogFactoryUtil.getLog(VGCAManagementImpl.class);
}
