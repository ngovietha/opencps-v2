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

package org.opencps.sms.service.base;

import aQute.bnd.annotation.ProviderType;

import com.liferay.exportimport.kernel.lar.ExportImportHelperUtil;
import com.liferay.exportimport.kernel.lar.ManifestSummary;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalServiceRegistry;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import org.opencps.sms.model.SMSGatewayLog;
import org.opencps.sms.service.SMSGatewayLogLocalService;
import org.opencps.sms.service.persistence.SMSGatewayLogPersistence;
import org.opencps.sms.service.persistence.SMSLookUpQueuePersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the sms gateway log local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link org.opencps.sms.service.impl.SMSGatewayLogLocalServiceImpl}.
 * </p>
 *
 * @author khoa
 * @see org.opencps.sms.service.impl.SMSGatewayLogLocalServiceImpl
 * @see org.opencps.sms.service.SMSGatewayLogLocalServiceUtil
 * @generated
 */
@ProviderType
public abstract class SMSGatewayLogLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements SMSGatewayLogLocalService,
		IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link org.opencps.sms.service.SMSGatewayLogLocalServiceUtil} to access the sms gateway log local service.
	 */

	/**
	 * Adds the sms gateway log to the database. Also notifies the appropriate model listeners.
	 *
	 * @param smsGatewayLog the sms gateway log
	 * @return the sms gateway log that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public SMSGatewayLog addSMSGatewayLog(SMSGatewayLog smsGatewayLog) {
		smsGatewayLog.setNew(true);

		return smsGatewayLogPersistence.update(smsGatewayLog);
	}

	/**
	 * Creates a new sms gateway log with the primary key. Does not add the sms gateway log to the database.
	 *
	 * @param smsId the primary key for the new sms gateway log
	 * @return the new sms gateway log
	 */
	@Override
	@Transactional(enabled = false)
	public SMSGatewayLog createSMSGatewayLog(long smsId) {
		return smsGatewayLogPersistence.create(smsId);
	}

	/**
	 * Deletes the sms gateway log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param smsId the primary key of the sms gateway log
	 * @return the sms gateway log that was removed
	 * @throws PortalException if a sms gateway log with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public SMSGatewayLog deleteSMSGatewayLog(long smsId)
		throws PortalException {
		return smsGatewayLogPersistence.remove(smsId);
	}

	/**
	 * Deletes the sms gateway log from the database. Also notifies the appropriate model listeners.
	 *
	 * @param smsGatewayLog the sms gateway log
	 * @return the sms gateway log that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public SMSGatewayLog deleteSMSGatewayLog(SMSGatewayLog smsGatewayLog) {
		return smsGatewayLogPersistence.remove(smsGatewayLog);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(SMSGatewayLog.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return smsGatewayLogPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.sms.model.impl.SMSGatewayLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end) {
		return smsGatewayLogPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.sms.model.impl.SMSGatewayLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator) {
		return smsGatewayLogPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return smsGatewayLogPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) {
		return smsGatewayLogPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public SMSGatewayLog fetchSMSGatewayLog(long smsId) {
		return smsGatewayLogPersistence.fetchByPrimaryKey(smsId);
	}

	/**
	 * Returns the sms gateway log matching the UUID and group.
	 *
	 * @param uuid the sms gateway log's UUID
	 * @param groupId the primary key of the group
	 * @return the matching sms gateway log, or <code>null</code> if a matching sms gateway log could not be found
	 */
	@Override
	public SMSGatewayLog fetchSMSGatewayLogByUuidAndGroupId(String uuid,
		long groupId) {
		return smsGatewayLogPersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the sms gateway log with the primary key.
	 *
	 * @param smsId the primary key of the sms gateway log
	 * @return the sms gateway log
	 * @throws PortalException if a sms gateway log with the primary key could not be found
	 */
	@Override
	public SMSGatewayLog getSMSGatewayLog(long smsId) throws PortalException {
		return smsGatewayLogPersistence.findByPrimaryKey(smsId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery = new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(smsGatewayLogLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(SMSGatewayLog.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("smsId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		IndexableActionableDynamicQuery indexableActionableDynamicQuery = new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(smsGatewayLogLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(SMSGatewayLog.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("smsId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {
		actionableDynamicQuery.setBaseLocalService(smsGatewayLogLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(SMSGatewayLog.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("smsId");
	}

	@Override
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		final PortletDataContext portletDataContext) {
		final ExportActionableDynamicQuery exportActionableDynamicQuery = new ExportActionableDynamicQuery() {
				@Override
				public long performCount() throws PortalException {
					ManifestSummary manifestSummary = portletDataContext.getManifestSummary();

					StagedModelType stagedModelType = getStagedModelType();

					long modelAdditionCount = super.performCount();

					manifestSummary.addModelAdditionCount(stagedModelType,
						modelAdditionCount);

					long modelDeletionCount = ExportImportHelperUtil.getModelDeletionCount(portletDataContext,
							stagedModelType);

					manifestSummary.addModelDeletionCount(stagedModelType,
						modelDeletionCount);

					return modelAdditionCount;
				}
			};

		initActionableDynamicQuery(exportActionableDynamicQuery);

		exportActionableDynamicQuery.setAddCriteriaMethod(new ActionableDynamicQuery.AddCriteriaMethod() {
				@Override
				public void addCriteria(DynamicQuery dynamicQuery) {
					portletDataContext.addDateRangeCriteria(dynamicQuery,
						"modifiedDate");
				}
			});

		exportActionableDynamicQuery.setCompanyId(portletDataContext.getCompanyId());

		exportActionableDynamicQuery.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod<SMSGatewayLog>() {
				@Override
				public void performAction(SMSGatewayLog smsGatewayLog)
					throws PortalException {
					StagedModelDataHandlerUtil.exportStagedModel(portletDataContext,
						smsGatewayLog);
				}
			});
		exportActionableDynamicQuery.setStagedModelType(new StagedModelType(
				PortalUtil.getClassNameId(SMSGatewayLog.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {
		return smsGatewayLogLocalService.deleteSMSGatewayLog((SMSGatewayLog)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {
		return smsGatewayLogPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns all the sms gateway logs matching the UUID and company.
	 *
	 * @param uuid the UUID of the sms gateway logs
	 * @param companyId the primary key of the company
	 * @return the matching sms gateway logs, or an empty list if no matches were found
	 */
	@Override
	public List<SMSGatewayLog> getSMSGatewayLogsByUuidAndCompanyId(
		String uuid, long companyId) {
		return smsGatewayLogPersistence.findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of sms gateway logs matching the UUID and company.
	 *
	 * @param uuid the UUID of the sms gateway logs
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of sms gateway logs
	 * @param end the upper bound of the range of sms gateway logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching sms gateway logs, or an empty list if no matches were found
	 */
	@Override
	public List<SMSGatewayLog> getSMSGatewayLogsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<SMSGatewayLog> orderByComparator) {
		return smsGatewayLogPersistence.findByUuid_C(uuid, companyId, start,
			end, orderByComparator);
	}

	/**
	 * Returns the sms gateway log matching the UUID and group.
	 *
	 * @param uuid the sms gateway log's UUID
	 * @param groupId the primary key of the group
	 * @return the matching sms gateway log
	 * @throws PortalException if a matching sms gateway log could not be found
	 */
	@Override
	public SMSGatewayLog getSMSGatewayLogByUuidAndGroupId(String uuid,
		long groupId) throws PortalException {
		return smsGatewayLogPersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the sms gateway logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.sms.model.impl.SMSGatewayLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of sms gateway logs
	 * @param end the upper bound of the range of sms gateway logs (not inclusive)
	 * @return the range of sms gateway logs
	 */
	@Override
	public List<SMSGatewayLog> getSMSGatewayLogs(int start, int end) {
		return smsGatewayLogPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of sms gateway logs.
	 *
	 * @return the number of sms gateway logs
	 */
	@Override
	public int getSMSGatewayLogsCount() {
		return smsGatewayLogPersistence.countAll();
	}

	/**
	 * Updates the sms gateway log in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param smsGatewayLog the sms gateway log
	 * @return the sms gateway log that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public SMSGatewayLog updateSMSGatewayLog(SMSGatewayLog smsGatewayLog) {
		return smsGatewayLogPersistence.update(smsGatewayLog);
	}

	/**
	 * Returns the sms gateway log local service.
	 *
	 * @return the sms gateway log local service
	 */
	public SMSGatewayLogLocalService getSMSGatewayLogLocalService() {
		return smsGatewayLogLocalService;
	}

	/**
	 * Sets the sms gateway log local service.
	 *
	 * @param smsGatewayLogLocalService the sms gateway log local service
	 */
	public void setSMSGatewayLogLocalService(
		SMSGatewayLogLocalService smsGatewayLogLocalService) {
		this.smsGatewayLogLocalService = smsGatewayLogLocalService;
	}

	/**
	 * Returns the sms gateway log persistence.
	 *
	 * @return the sms gateway log persistence
	 */
	public SMSGatewayLogPersistence getSMSGatewayLogPersistence() {
		return smsGatewayLogPersistence;
	}

	/**
	 * Sets the sms gateway log persistence.
	 *
	 * @param smsGatewayLogPersistence the sms gateway log persistence
	 */
	public void setSMSGatewayLogPersistence(
		SMSGatewayLogPersistence smsGatewayLogPersistence) {
		this.smsGatewayLogPersistence = smsGatewayLogPersistence;
	}

	/**
	 * Returns the sms look up queue local service.
	 *
	 * @return the sms look up queue local service
	 */
	public org.opencps.sms.service.SMSLookUpQueueLocalService getSMSLookUpQueueLocalService() {
		return smsLookUpQueueLocalService;
	}

	/**
	 * Sets the sms look up queue local service.
	 *
	 * @param smsLookUpQueueLocalService the sms look up queue local service
	 */
	public void setSMSLookUpQueueLocalService(
		org.opencps.sms.service.SMSLookUpQueueLocalService smsLookUpQueueLocalService) {
		this.smsLookUpQueueLocalService = smsLookUpQueueLocalService;
	}

	/**
	 * Returns the sms look up queue persistence.
	 *
	 * @return the sms look up queue persistence
	 */
	public SMSLookUpQueuePersistence getSMSLookUpQueuePersistence() {
		return smsLookUpQueuePersistence;
	}

	/**
	 * Sets the sms look up queue persistence.
	 *
	 * @param smsLookUpQueuePersistence the sms look up queue persistence
	 */
	public void setSMSLookUpQueuePersistence(
		SMSLookUpQueuePersistence smsLookUpQueuePersistence) {
		this.smsLookUpQueuePersistence = smsLookUpQueuePersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService getClassNameLocalService() {
		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService) {
		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {
		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		persistedModelLocalServiceRegistry.register("org.opencps.sms.model.SMSGatewayLog",
			smsGatewayLogLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"org.opencps.sms.model.SMSGatewayLog");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return SMSGatewayLogLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return SMSGatewayLog.class;
	}

	protected String getModelClassName() {
		return SMSGatewayLog.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = smsGatewayLogPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = SMSGatewayLogLocalService.class)
	protected SMSGatewayLogLocalService smsGatewayLogLocalService;
	@BeanReference(type = SMSGatewayLogPersistence.class)
	protected SMSGatewayLogPersistence smsGatewayLogPersistence;
	@BeanReference(type = org.opencps.sms.service.SMSLookUpQueueLocalService.class)
	protected org.opencps.sms.service.SMSLookUpQueueLocalService smsLookUpQueueLocalService;
	@BeanReference(type = SMSLookUpQueuePersistence.class)
	protected SMSLookUpQueuePersistence smsLookUpQueuePersistence;
	@ServiceReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameLocalService.class)
	protected com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService;
	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@ServiceReference(type = com.liferay.portal.kernel.service.ResourceLocalService.class)
	protected com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserLocalService.class)
	protected com.liferay.portal.kernel.service.UserLocalService userLocalService;
	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@ServiceReference(type = PersistedModelLocalServiceRegistry.class)
	protected PersistedModelLocalServiceRegistry persistedModelLocalServiceRegistry;
}