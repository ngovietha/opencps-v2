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

package org.opencps.usermgt.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import org.opencps.usermgt.model.SyncScheduler;
import org.opencps.usermgt.model.SyncSchedulerModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the SyncScheduler service. Represents a row in the &quot;opencps_sync_scheduler&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link SyncSchedulerModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SyncSchedulerImpl}.
 * </p>
 *
 * @author khoavu
 * @see SyncSchedulerImpl
 * @see SyncScheduler
 * @see SyncSchedulerModel
 * @generated
 */
@ProviderType
public class SyncSchedulerModelImpl extends BaseModelImpl<SyncScheduler>
	implements SyncSchedulerModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a sync scheduler model instance should use the {@link SyncScheduler} interface instead.
	 */
	public static final String TABLE_NAME = "opencps_sync_scheduler";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "syncSchedulerId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "className", Types.VARCHAR },
			{ "typeCode", Types.VARCHAR },
			{ "syncDate", Types.TIMESTAMP }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("syncSchedulerId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("className", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("typeCode", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("syncDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE = "create table opencps_sync_scheduler (uuid_ VARCHAR(75) null,syncSchedulerId LONG not null primary key,createDate DATE null,modifiedDate DATE null,className VARCHAR(75) null,typeCode VARCHAR(75) null,syncDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table opencps_sync_scheduler";
	public static final String ORDER_BY_JPQL = " ORDER BY syncScheduler.createDate ASC";
	public static final String ORDER_BY_SQL = " ORDER BY opencps_sync_scheduler.createDate ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(org.opencps.backend.usermgt.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.org.opencps.usermgt.model.SyncScheduler"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(org.opencps.backend.usermgt.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.org.opencps.usermgt.model.SyncScheduler"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(org.opencps.backend.usermgt.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.org.opencps.usermgt.model.SyncScheduler"),
			true);
	public static final long CLASSNAME_COLUMN_BITMASK = 1L;
	public static final long SYNCDATE_COLUMN_BITMASK = 2L;
	public static final long TYPECODE_COLUMN_BITMASK = 4L;
	public static final long UUID_COLUMN_BITMASK = 8L;
	public static final long CREATEDATE_COLUMN_BITMASK = 16L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(org.opencps.backend.usermgt.service.util.ServiceProps.get(
				"lock.expiration.time.org.opencps.usermgt.model.SyncScheduler"));

	public SyncSchedulerModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _syncSchedulerId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSyncSchedulerId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _syncSchedulerId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return SyncScheduler.class;
	}

	@Override
	public String getModelClassName() {
		return SyncScheduler.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("syncSchedulerId", getSyncSchedulerId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("className", getClassName());
		attributes.put("typeCode", getTypeCode());
		attributes.put("syncDate", getSyncDate());

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

		Long syncSchedulerId = (Long)attributes.get("syncSchedulerId");

		if (syncSchedulerId != null) {
			setSyncSchedulerId(syncSchedulerId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String className = (String)attributes.get("className");

		if (className != null) {
			setClassName(className);
		}

		String typeCode = (String)attributes.get("typeCode");

		if (typeCode != null) {
			setTypeCode(typeCode);
		}

		Date syncDate = (Date)attributes.get("syncDate");

		if (syncDate != null) {
			setSyncDate(syncDate);
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
	public long getSyncSchedulerId() {
		return _syncSchedulerId;
	}

	@Override
	public void setSyncSchedulerId(long syncSchedulerId) {
		_syncSchedulerId = syncSchedulerId;
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
	public String getClassName() {
		if (_className == null) {
			return "";
		}
		else {
			return _className;
		}
	}

	@Override
	public void setClassName(String className) {
		_columnBitmask |= CLASSNAME_COLUMN_BITMASK;

		if (_originalClassName == null) {
			_originalClassName = _className;
		}

		_className = className;
	}

	public String getOriginalClassName() {
		return GetterUtil.getString(_originalClassName);
	}

	@Override
	public String getTypeCode() {
		if (_typeCode == null) {
			return "";
		}
		else {
			return _typeCode;
		}
	}

	@Override
	public void setTypeCode(String typeCode) {
		_columnBitmask |= TYPECODE_COLUMN_BITMASK;

		if (_originalTypeCode == null) {
			_originalTypeCode = _typeCode;
		}

		_typeCode = typeCode;
	}

	public String getOriginalTypeCode() {
		return GetterUtil.getString(_originalTypeCode);
	}

	@Override
	public Date getSyncDate() {
		return _syncDate;
	}

	@Override
	public void setSyncDate(Date syncDate) {
		_columnBitmask |= SYNCDATE_COLUMN_BITMASK;

		if (_originalSyncDate == null) {
			_originalSyncDate = _syncDate;
		}

		_syncDate = syncDate;
	}

	public Date getOriginalSyncDate() {
		return _originalSyncDate;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			SyncScheduler.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public SyncScheduler toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (SyncScheduler)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		SyncSchedulerImpl syncSchedulerImpl = new SyncSchedulerImpl();

		syncSchedulerImpl.setUuid(getUuid());
		syncSchedulerImpl.setSyncSchedulerId(getSyncSchedulerId());
		syncSchedulerImpl.setCreateDate(getCreateDate());
		syncSchedulerImpl.setModifiedDate(getModifiedDate());
		syncSchedulerImpl.setClassName(getClassName());
		syncSchedulerImpl.setTypeCode(getTypeCode());
		syncSchedulerImpl.setSyncDate(getSyncDate());

		syncSchedulerImpl.resetOriginalValues();

		return syncSchedulerImpl;
	}

	@Override
	public int compareTo(SyncScheduler syncScheduler) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(),
				syncScheduler.getCreateDate());

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

		if (!(obj instanceof SyncScheduler)) {
			return false;
		}

		SyncScheduler syncScheduler = (SyncScheduler)obj;

		long primaryKey = syncScheduler.getPrimaryKey();

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
		SyncSchedulerModelImpl syncSchedulerModelImpl = this;

		syncSchedulerModelImpl._originalUuid = syncSchedulerModelImpl._uuid;

		syncSchedulerModelImpl._setModifiedDate = false;

		syncSchedulerModelImpl._originalClassName = syncSchedulerModelImpl._className;

		syncSchedulerModelImpl._originalTypeCode = syncSchedulerModelImpl._typeCode;

		syncSchedulerModelImpl._originalSyncDate = syncSchedulerModelImpl._syncDate;

		syncSchedulerModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<SyncScheduler> toCacheModel() {
		SyncSchedulerCacheModel syncSchedulerCacheModel = new SyncSchedulerCacheModel();

		syncSchedulerCacheModel.uuid = getUuid();

		String uuid = syncSchedulerCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			syncSchedulerCacheModel.uuid = null;
		}

		syncSchedulerCacheModel.syncSchedulerId = getSyncSchedulerId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			syncSchedulerCacheModel.createDate = createDate.getTime();
		}
		else {
			syncSchedulerCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			syncSchedulerCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			syncSchedulerCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		syncSchedulerCacheModel.className = getClassName();

		String className = syncSchedulerCacheModel.className;

		if ((className != null) && (className.length() == 0)) {
			syncSchedulerCacheModel.className = null;
		}

		syncSchedulerCacheModel.typeCode = getTypeCode();

		String typeCode = syncSchedulerCacheModel.typeCode;

		if ((typeCode != null) && (typeCode.length() == 0)) {
			syncSchedulerCacheModel.typeCode = null;
		}

		Date syncDate = getSyncDate();

		if (syncDate != null) {
			syncSchedulerCacheModel.syncDate = syncDate.getTime();
		}
		else {
			syncSchedulerCacheModel.syncDate = Long.MIN_VALUE;
		}

		return syncSchedulerCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", syncSchedulerId=");
		sb.append(getSyncSchedulerId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", className=");
		sb.append(getClassName());
		sb.append(", typeCode=");
		sb.append(getTypeCode());
		sb.append(", syncDate=");
		sb.append(getSyncDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("org.opencps.usermgt.model.SyncScheduler");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>syncSchedulerId</column-name><column-value><![CDATA[");
		sb.append(getSyncSchedulerId());
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
			"<column><column-name>className</column-name><column-value><![CDATA[");
		sb.append(getClassName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>typeCode</column-name><column-value><![CDATA[");
		sb.append(getTypeCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>syncDate</column-name><column-value><![CDATA[");
		sb.append(getSyncDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = SyncScheduler.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			SyncScheduler.class, ModelWrapper.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _syncSchedulerId;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _className;
	private String _originalClassName;
	private String _typeCode;
	private String _originalTypeCode;
	private Date _syncDate;
	private Date _originalSyncDate;
	private long _columnBitmask;
	private SyncScheduler _escapedModel;
}