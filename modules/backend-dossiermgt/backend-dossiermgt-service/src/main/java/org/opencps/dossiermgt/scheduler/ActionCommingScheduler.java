package org.opencps.dossiermgt.scheduler;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.module.framework.ModuleServiceLifecycle;
import com.liferay.portal.kernel.scheduler.SchedulerEngineHelper;
import com.liferay.portal.kernel.scheduler.SchedulerEntryImpl;
import com.liferay.portal.kernel.scheduler.SchedulerException;
import com.liferay.portal.kernel.scheduler.StorageType;
import com.liferay.portal.kernel.scheduler.StorageTypeAware;
import com.liferay.portal.kernel.scheduler.TimeUnit;
import com.liferay.portal.kernel.scheduler.Trigger;
import com.liferay.portal.kernel.scheduler.TriggerFactory;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.opencps.auth.utils.APIDateTimeUtils;
import org.opencps.communication.constants.NotificationTemplateTerm;
import org.opencps.communication.exception.NoSuchNotificationQueueException;
import org.opencps.communication.model.NotificationQueue;
import org.opencps.communication.model.Notificationtemplate;
import org.opencps.communication.service.NotificationQueueLocalServiceUtil;
import org.opencps.communication.service.NotificationtemplateLocalServiceUtil;
import org.opencps.dossiermgt.action.util.OpenCPSConfigUtil;
import org.opencps.dossiermgt.constants.DossierActionUserTerm;
import org.opencps.dossiermgt.constants.DossierTerm;
import org.opencps.dossiermgt.model.Dossier;
import org.opencps.dossiermgt.model.DossierAction;
import org.opencps.dossiermgt.model.DossierActionUser;
import org.opencps.dossiermgt.model.ServiceProcess;
import org.opencps.dossiermgt.service.DossierActionLocalServiceUtil;
import org.opencps.dossiermgt.service.DossierActionUserLocalServiceUtil;
import org.opencps.dossiermgt.service.DossierLocalServiceUtil;
import org.opencps.dossiermgt.service.ServiceProcessLocalServiceUtil;
import org.opencps.kernel.scheduler.StorageTypeAwareSchedulerEntryImpl;
import org.opencps.usermgt.model.Employee;
import org.opencps.usermgt.service.EmployeeLocalServiceUtil;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = ActionCommingScheduler.class)
public class ActionCommingScheduler extends BaseMessageListener {
	private volatile boolean isRunning = false;
	private static final int GROUP_TYPE_SITE = 1;
	
	@Override
	protected void doReceive(Message message) throws Exception {
		if (!isRunning) {
			isRunning = true;
		}
		else {
			isRunning = false;
		}
		if (!OpenCPSConfigUtil.isNotificationEnable()) {
			isRunning = false;
			return;
		}
		_log.info("OpenCPS Check Action Comming IS  : " + APIDateTimeUtils.convertDateToString(new Date()));
		
		try {
			Date now = new Date();	
			Company company = CompanyLocalServiceUtil.getCompanyByMx(PropsUtil.get(PropsKeys.COMPANY_DEFAULT_WEB_ID));
			
			List<Group> groups = GroupLocalServiceUtil.getCompanyGroups(company.getCompanyId(), QueryUtil.ALL_POS,
					QueryUtil.ALL_POS);
			
			List<Group> sites = new ArrayList<Group>();
	
			for (Group group : groups) {
				if (group.getType() == GROUP_TYPE_SITE && group.isSite()) {
					sites.add(group);
				}
			}
				
			for (Group site : sites) {
				List<ServiceProcess> lstProcesses = ServiceProcessLocalServiceUtil.getByG_ID(site.getGroupId());
				for (ServiceProcess sp : lstProcesses) {
					if (sp != null) {
						String dueDatePattern = sp.getDueDatePattern();
						try {
							JSONObject dueDateObj = JSONFactoryUtil.createJSONObject(dueDatePattern);
							if (dueDateObj.has(DossierTerm.DUE_DATE_NOTIFY)) {
								String type = "";
								String value = "";
								JSONObject notifyObj = dueDateObj.getJSONObject(DossierTerm.DUE_DATE_NOTIFY);
								if (notifyObj.has(DossierTerm.DUE_DATE_NOTIFY_TYPE)) {
									type = notifyObj.getString(DossierTerm.DUE_DATE_NOTIFY_TYPE);
								}
								if (notifyObj.has(DossierTerm.DUE_DATE_NOTIFY_VALUE)) {
									value = notifyObj.getString(DossierTerm.DUE_DATE_NOTIFY_VALUE);
								}
								List<DossierAction> lstactions = DossierActionLocalServiceUtil.findOverdueByType(now, type, value);
								_log.debug("ACTION COMMING SCHEDULER SIZE: " + lstactions.size());
								for (DossierAction action : lstactions) {
									List<DossierActionUser> lstDaus = DossierActionUserLocalServiceUtil.getByDossierAndStepCode(action.getDossierId(), action.getStepCode());
									_log.debug("ACTION COMMING SCHEDULER LIST USER: " + lstDaus.size());
									Notificationtemplate notiTemplate = NotificationtemplateLocalServiceUtil.fetchByF_NotificationtemplateByType(action.getGroupId(), NotificationTemplateTerm.EMPL_04);
							        Calendar cal = Calendar.getInstance();
							        cal.setTime(now);
							        	  
							        JSONObject payloadObj = JSONFactoryUtil.createJSONObject();
							        try {		
							        	Dossier dossier = DossierLocalServiceUtil.fetchDossier(action.getDossierId());
							        	if (dossier != null) {
								        	payloadObj.put(
													"Dossier", JSONFactoryUtil.createJSONObject(
														JSONFactoryUtil.looseSerialize(dossier)));
							        	}
							        	payloadObj.put("DossierAction", JSONFactoryUtil.looseSerialize(action));
							        }
							        catch (Exception e) {
							        	_log.debug(e);
							        }
							        
									if (notiTemplate != null) {
										if ("minutely".equals(notiTemplate.getInterval())) {
									        cal.add(Calendar.MINUTE, notiTemplate.getExpireDuration());					
										}
										else if ("hourly".equals(notiTemplate.getInterval())) {
									        cal.add(Calendar.HOUR, notiTemplate.getExpireDuration());										
										}
										else {
									        cal.add(Calendar.MINUTE, notiTemplate.getExpireDuration());										
										}
										Date expired = cal.getTime();
										ServiceContext serviceContext = new ServiceContext();
										
										for (DossierActionUser dau : lstDaus) {
											if (dau.getAssigned() == DossierActionUserTerm.ASSIGNED_TH || dau.getAssigned() == DossierActionUserTerm.ASSIGNED_PH) {
												Employee employee = EmployeeLocalServiceUtil.fetchByF_mappingUserId(action.getGroupId(), dau.getUserId());
												String telNo = employee != null ? employee.getTelNo() : StringPool.BLANK;
												String fullName = employee != null ? employee.getFullName() : StringPool.BLANK;
												User u = UserLocalServiceUtil.fetchUser(dau.getUserId());
												NotificationQueue oldQueue = null;
												try {
													oldQueue = NotificationQueueLocalServiceUtil.findByF_NT_CN_CPK_EMAIL(action.getGroupId(), NotificationTemplateTerm.EMPL_04, Dossier.class.getName(), String.valueOf(action.getDossierId()), u != null ? u.getEmailAddress() : StringPool.BLANK);
												}
												catch (NoSuchNotificationQueueException e) {
													_log.debug(e);
												}
												if (oldQueue == null) {
													NotificationQueueLocalServiceUtil.addNotificationQueue(
															dau.getUserId(), action.getGroupId(), 
															NotificationTemplateTerm.EMPL_04, 
															Dossier.class.getName(), 
															String.valueOf(action.getDossierId()), 
															payloadObj.toJSONString(), 
															fullName, 
															fullName, 
															dau.getUserId(), 
															u != null ? u.getEmailAddress() : StringPool.BLANK, 
															telNo, 
															now, 
															expired, 
															serviceContext);																															
												}
											}	
										}
									}
								}
							}
						}
						catch (Exception e) {
							_log.debug(e);
						}
					}
				}
			}			
		}
		catch (Exception e) {
			_log.debug(e);
		}
		_log.info("OpenCPS Check Action Comming HAS BEEN DONE : " + APIDateTimeUtils.convertDateToString(new Date()));	
		isRunning = false;
	}
	
	  @Activate
	  @Modified
	  protected void activate(Map<String,Object> properties) throws SchedulerException {
		  String listenerClass = getClass().getName();
		  Trigger jobTrigger = _triggerFactory.createTrigger(listenerClass, listenerClass, new Date(), null, 15, TimeUnit.MINUTE);

		  _schedulerEntryImpl = new SchedulerEntryImpl(getClass().getName(), jobTrigger);
		  _schedulerEntryImpl = new StorageTypeAwareSchedulerEntryImpl(_schedulerEntryImpl, StorageType.PERSISTED);
//		  _schedulerEntryImpl.setTrigger(jobTrigger);

		  if (_initialized) {
			  deactivate();
		  }

	    _schedulerEngineHelper.register(this, _schedulerEntryImpl, DestinationNames.SCHEDULER_DISPATCH);
	    _initialized = true;
	  }
	  
	@Deactivate
	protected void deactivate() {
		if (_initialized) {
			try {
				_schedulerEngineHelper.unschedule(_schedulerEntryImpl, getStorageType());
		    } catch (SchedulerException se) {
		        if (_log.isWarnEnabled()) {
		        	_log.warn("Unable to unschedule trigger", se);
		        }
		    }

		      _schedulerEngineHelper.unregister(this);
		}
		_initialized = false;
	}

	/**
	 * getStorageType: Utility method to get the storage type from the scheduler entry wrapper.
	 * @return StorageType The storage type to use.
	*/
	protected StorageType getStorageType() {
	    if (_schedulerEntryImpl instanceof StorageTypeAware) {
	    	return ((StorageTypeAware) _schedulerEntryImpl).getStorageType();
	    }
	    
	    return StorageType.PERSISTED;
	}
	  
	/**
	   * setModuleServiceLifecycle: So this requires some explanation...
	   * 
	   * OSGi will start a component once all of it's dependencies are satisfied.  However, there
	   * are times where you want to hold off until the portal is completely ready to go.
	   * 
	   * This reference declaration is waiting for the ModuleServiceLifecycle's PORTAL_INITIALIZED
	   * component which will not be available until, surprise surprise, the portal has finished
	   * initializing.
	   * 
	   * With this reference, this component activation waits until portal initialization has completed.
	   * @param moduleServiceLifecycle
	   */
	@Reference(target = ModuleServiceLifecycle.PORTAL_INITIALIZED, unbind = "-")
	protected void setModuleServiceLifecycle(ModuleServiceLifecycle moduleServiceLifecycle) {
	}
	  
	@Reference(unbind = "-")
	protected void setTriggerFactory(TriggerFactory triggerFactory) {
		_triggerFactory = triggerFactory;
	}

	@Reference(unbind = "-")
	protected void setSchedulerEngineHelper(SchedulerEngineHelper schedulerEngineHelper) {
		_schedulerEngineHelper = schedulerEngineHelper;
	}
	
	private SchedulerEngineHelper _schedulerEngineHelper;
	private TriggerFactory _triggerFactory;
	private volatile boolean _initialized;
	private SchedulerEntryImpl _schedulerEntryImpl = null;

	private Log _log = LogFactoryUtil.getLog(ActionCommingScheduler.class);
}
