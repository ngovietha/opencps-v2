/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package org.opencps.dossiermgt.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import org.opencps.dossiermgt.model.NewsBoard;
import org.opencps.dossiermgt.model.NewsBoardModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the NewsBoard service. Represents a row in the &quot;opencps_newsboard&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link NewsBoardModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link NewsBoardImpl}.
 * </p>
 *
 * @author huymq
 * @see NewsBoardImpl
 * @see NewsBoard
 * @see NewsBoardModel
 * @generated
 */
@ProviderType
public class NewsBoardModelImpl extends BaseModelImpl<NewsBoard>
	implements NewsBoardModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a news board model instance should use the {@link NewsBoard} interface instead.
	 */
	public static final String TABLE_NAME = "opencps_newsboard";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "newBoardId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "newsTitle", Types.VARCHAR },
			{ "newsContent", Types.VARCHAR },
			{ "newsStatus", Types.INTEGER }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("newBoardId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("newsTitle", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("newsContent", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("newsStatus", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE = "create table opencps_newsboard (uuid_ VARCHAR(75) null,newBoardId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,newsTitle VARCHAR(75) null,newsContent VARCHAR(75) null,newsStatus INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table opencps_newsboard";
	public static final String ORDER_BY_JPQL = " ORDER BY newsBoard.createDate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY opencps_newsboard.createDate DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(org.opencps.backend.dossiermgt.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.org.opencps.dossiermgt.model.NewsBoard"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(org.opencps.backend.dossiermgt.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.org.opencps.dossiermgt.model.NewsBoard"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(org.opencps.backend.dossiermgt.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.org.opencps.dossiermgt.model.NewsBoard"),
			true);
	public static final long COMPANYID_COLUMN_BITMASK = 1L;
	public static final long GROUPID_COLUMN_BITMASK = 2L;
	public static final long UUID_COLUMN_BITMASK = 4L;
	public static final long CREATEDATE_COLUMN_BITMASK = 8L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(org.opencps.backend.dossiermgt.service.util.ServiceProps.get(
				"lock.expiration.time.org.opencps.dossiermgt.model.NewsBoard"));

	public NewsBoardModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _newBoardId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setNewBoardId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _newBoardId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return NewsBoard.class;
	}

	@Override
	public String getModelClassName() {
		return NewsBoard.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("newBoardId", getNewBoardId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("newsTitle", getNewsTitle());
		attributes.put("newsContent", getNewsContent());
		attributes.put("newsStatus", getNewsStatus());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long newBoardId = (Long)attributes.get("newBoardId");

		if (newBoardId != null) {
			setNewBoardId(newBoardId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String newsTitle = (String)attributes.get("newsTitle");

		if (newsTitle != null) {
			setNewsTitle(newsTitle);
		}

		String newsContent = (String)attributes.get("newsContent");

		if (newsContent != null) {
			setNewsContent(newsContent);
		}

		Integer newsStatus = (Integer)attributes.get("newsStatus");

		if (newsStatus != null) {
			setNewsStatus(newsStatus);
		}
	}

	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@Override
	public long getNewBoardId() {
		return _newBoardId;
	}

	@Override
	public void setNewBoardId(long newBoardId) {
		_newBoardId = newBoardId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_columnBitmask = -1L;

		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@Override
	public String getNewsTitle() {
		if (_newsTitle == null) {
			return "";
		}
		else {
			return _newsTitle;
		}
	}

	@Override
	public void setNewsTitle(String newsTitle) {
		_newsTitle = newsTitle;
	}

	@Override
	public String getNewsContent() {
		if (_newsContent == null) {
			return "";
		}
		else {
			return _newsContent;
		}
	}

	@Override
	public void setNewsContent(String newsContent) {
		_newsContent = newsContent;
	}

	@Override
	public int getNewsStatus() {
		return _newsStatus;
	}

	@Override
	public void setNewsStatus(int newsStatus) {
		_newsStatus = newsStatus;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				NewsBoard.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			NewsBoard.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public NewsBoard toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (NewsBoard)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		NewsBoardImpl newsBoardImpl = new NewsBoardImpl();

		newsBoardImpl.setUuid(getUuid());
		newsBoardImpl.setNewBoardId(getNewBoardId());
		newsBoardImpl.setGroupId(getGroupId());
		newsBoardImpl.setCompanyId(getCompanyId());
		newsBoardImpl.setUserId(getUserId());
		newsBoardImpl.setUserName(getUserName());
		newsBoardImpl.setCreateDate(getCreateDate());
		newsBoardImpl.setModifiedDate(getModifiedDate());
		newsBoardImpl.setNewsTitle(getNewsTitle());
		newsBoardImpl.setNewsContent(getNewsContent());
		newsBoardImpl.setNewsStatus(getNewsStatus());

		newsBoardImpl.resetOriginalValues();

		return newsBoardImpl;
	}

	@Override
	public int compareTo(NewsBoard newsBoard) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), newsBoard.getCreateDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof NewsBoard)) {
			return false;
		}

		NewsBoard newsBoard = (NewsBoard)obj;

		long primaryKey = newsBoard.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		NewsBoardModelImpl newsBoardModelImpl = this;

		newsBoardModelImpl._originalUuid = newsBoardModelImpl._uuid;

		newsBoardModelImpl._originalGroupId = newsBoardModelImpl._groupId;

		newsBoardModelImpl._setOriginalGroupId = false;

		newsBoardModelImpl._originalCompanyId = newsBoardModelImpl._companyId;

		newsBoardModelImpl._setOriginalCompanyId = false;

		newsBoardModelImpl._setModifiedDate = false;

		newsBoardModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<NewsBoard> toCacheModel() {
		NewsBoardCacheModel newsBoardCacheModel = new NewsBoardCacheModel();

		newsBoardCacheModel.uuid = getUuid();

		String uuid = newsBoardCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			newsBoardCacheModel.uuid = null;
		}

		newsBoardCacheModel.newBoardId = getNewBoardId();

		newsBoardCacheModel.groupId = getGroupId();

		newsBoardCacheModel.companyId = getCompanyId();

		newsBoardCacheModel.userId = getUserId();

		newsBoardCacheModel.userName = getUserName();

		String userName = newsBoardCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			newsBoardCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			newsBoardCacheModel.createDate = createDate.getTime();
		}
		else {
			newsBoardCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			newsBoardCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			newsBoardCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		newsBoardCacheModel.newsTitle = getNewsTitle();

		String newsTitle = newsBoardCacheModel.newsTitle;

		if ((newsTitle != null) && (newsTitle.length() == 0)) {
			newsBoardCacheModel.newsTitle = null;
		}

		newsBoardCacheModel.newsContent = getNewsContent();

		String newsContent = newsBoardCacheModel.newsContent;

		if ((newsContent != null) && (newsContent.length() == 0)) {
			newsBoardCacheModel.newsContent = null;
		}

		newsBoardCacheModel.newsStatus = getNewsStatus();

		return newsBoardCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", newBoardId=");
		sb.append(getNewBoardId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", newsTitle=");
		sb.append(getNewsTitle());
		sb.append(", newsContent=");
		sb.append(getNewsContent());
		sb.append(", newsStatus=");
		sb.append(getNewsStatus());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("org.opencps.dossiermgt.model.NewsBoard");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>newBoardId</column-name><column-value><![CDATA[");
		sb.append(getNewBoardId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>newsTitle</column-name><column-value><![CDATA[");
		sb.append(getNewsTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>newsContent</column-name><column-value><![CDATA[");
		sb.append(getNewsContent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>newsStatus</column-name><column-value><![CDATA[");
		sb.append(getNewsStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = NewsBoard.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			NewsBoard.class, ModelWrapper.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _newBoardId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _newsTitle;
	private String _newsContent;
	private int _newsStatus;
	private long _columnBitmask;
	private NewsBoard _escapedModel;
}