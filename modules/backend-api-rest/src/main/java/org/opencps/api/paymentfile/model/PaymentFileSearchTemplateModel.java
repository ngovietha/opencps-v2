// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.09.20 at 05:56:58 PM ICT 
//


package org.opencps.api.paymentFile.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ServiceInfoModel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ServiceInfoModel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dossierId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="dossierNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="counter" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="serviceCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="serviceName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="referenceUid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="createDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="modifiedDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="govAgencyCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="govAgencyName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="applicantName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="applicantIdNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isNew" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="paymentFee" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="paymentAmount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="paymentNote" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bankInfo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="epaymentProfile" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="paymentStatus" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="paymentMethod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="confirmDatetime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="confirmPayload" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="confirmFileType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="confirmFileSize" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="confirmNote" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="approveDatetime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="accountUserName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="govAgencyTaxNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="invoiceTemplateNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="invoiceIssueNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="invoiceNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="invoiceFileType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="invoiceFileSize" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
		"dossierId",
		"dossierNo",
		"counter",
		"serviceCode",
		"serviceName",
		"referenceUid",
		"createDate",
		"modifiedDate",
		"govAgencyCode",
		"govAgencyName",
		"applicantName",
		"applicantIdNo",
		"isNew",
		"paymentFee",
		"paymentAmount",
		"paymentNote",
		"bankInfo",
		"epaymentProfile",
		"paymentStatus",
		"paymentMethod",
		"confirmDatetime",
		"confirmPayload",
		"confirmFileType",
		"confirmFileSize",
		"confirmNote",
		"approveDatetime",
		"accountUserName",
		"govAgencyTaxNo",
		"invoiceTemplateNo",
		"invoiceIssueNo",
		"invoiceNo",
		"invoiceFileType",
		"invoiceFileSize"
})
public class PaymentFileSearchTemplateModel {

	protected Long dossierId;
	protected String dossierNo;
	protected Integer counter;
	protected String serviceCode;
	protected String serviceName;
	protected String referenceUid;
	protected String createDate;
	protected String modifiedDate;
	protected String govAgencyCode;
	protected String govAgencyName;
	protected String applicantName;
	protected String applicantIdNo;
	protected Boolean isNew;
	protected String paymentFee;
	protected Integer paymentAmount;
	protected String paymentNote;
	protected String bankInfo;
	protected String epaymentProfile;
	protected Integer paymentStatus;
	protected String paymentMethod;
	protected String confirmDatetime;
	protected String confirmPayload;
	protected String confirmFileType;
	protected Long confirmFileSize;
	protected String confirmNote;
	protected String approveDatetime;
	protected String accountUserName;
	protected String govAgencyTaxNo;
	protected String invoiceTemplateNo;
	protected String invoiceIssueNo;
	protected String invoiceNo;
	protected String invoiceFileType;
	protected Long invoiceFileSize;

    /**
     * Gets the value of the serviceInfoId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
	public Long getDossierId() {
		return dossierId;
	}

    /**
     * Sets the value of the serviceInfoId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
	public void setDossierId(Long dossierId) {
		this.dossierId = dossierId;
	}

    /**
     * Gets the value of the dossierNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
	public String getDossierNo() {
		return dossierNo;
	}

    /**
     * Sets the value of the dossierNo property.
     * 
     * @param dossierNo
     *     allowed object is
     *     {@link String }
     *     
     */
	public void setDossierNo(String dossierNo) {
		this.dossierNo = dossierNo;
	}

    /**
     * Gets the value of the counter property.
     * 
     * @return
     *     possible object is
     *     {@link int }
     *     
     */
	public Integer getCounter() {
		return counter;
	}

    /**
     * Sets the value of the counter property.
     * 
     * @param counter
     *     allowed object is
     *     {@link int }
     *     
     */
	public void setCounter(Integer counter) {
		this.counter = counter;
	}

    /**
     * Gets the value of the serviceCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
	public String getServiceCode() {
		return serviceCode;
	}

    /**
     * Sets the value of the serviceCode property.
     * 
     * @param serviceCode
     *     allowed object is
     *     {@link String }
     *     
     */
	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

    /**
     * Gets the value of the serviceName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
	public String getServiceName() {
		return serviceName;
	}

    /**
     * Sets the value of the serviceName property.
     * 
     * @param serviceName
     *     allowed object is
     *     {@link String }
     *     
     */
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

    /**
     * Gets the value of the referenceUid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
	public String getReferenceUid() {
		return referenceUid;
	}

    /**
     * Sets the value of the referenceUid property.
     * 
     * @param referenceUid
     *     allowed object is
     *     {@link String }
     *     
     */
	public void setReferenceUid(String referenceUid) {
		this.referenceUid = referenceUid;
	}

    /**
     * Gets the value of the createDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
	public String getCreateDate() {
		return createDate;
	}

    /**
     * Sets the value of the createDate property.
     * 
     * @param createDate
     *     allowed object is
     *     {@link String }
     *     
     */
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

    /**
     * Gets the value of the modifiedDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
	public String getModifiedDate() {
		return modifiedDate;
	}

    /**
     * Sets the value of the modifiedDate property.
     * 
     * @param modifiedDate
     *     allowed object is
     *     {@link String }
     *     
     */
	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

    /**
     * Gets the value of the govAgencyCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
	public String getGovAgencyCode() {
		return govAgencyCode;
	}

    /**
     * Sets the value of the govAgencyCode property.
     * 
     * @param govAgencyCode
     *     allowed object is
     *     {@link String }
     *     
     */
	public void setGovAgencyCode(String govAgencyCode) {
		this.govAgencyCode = govAgencyCode;
	}

    /**
     * Gets the value of the govAgencyName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
	public String getGovAgencyName() {
		return govAgencyName;
	}

    /**
     * Sets the value of the govAgencyName property.
     * 
     * @param govAgencyName
     *     allowed object is
     *     {@link String }
     *     
     */
	public void setGovAgencyName(String govAgencyName) {
		this.govAgencyName = govAgencyName;
	}

    /**
     * Gets the value of the applicantName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
	public String getApplicantName() {
		return applicantName;
	}

    /**
     * Sets the value of the applicantName property.
     * 
     * @param applicantName
     *     allowed object is
     *     {@link String }
     *     
     */
	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

    /**
     * Gets the value of the applicantIdNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
	public String getApplicantIdNo() {
		return applicantIdNo;
	}

    /**
     * Sets the value of the applicantIdNo property.
     * 
     * @param applicantIdNo
     *     allowed object is
     *     {@link String }
     *     
     */
	public void setApplicantIdNo(String applicantIdNo) {
		this.applicantIdNo = applicantIdNo;
	}

    /**
     * Gets the value of the isNew property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
	public Boolean getIsNew() {
		return isNew;
	}

    /**
     * Sets the value of the isNew property.
     * 
     * @param isNew
     *     allowed object is
     *     {@link Boolean }
     *     
     */
	public void setIsNew(Boolean isNew) {
		this.isNew = isNew;
	}

    /**
     * Gets the value of the paymentFee property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
	public String getPaymentFee() {
		return paymentFee;
	}

    /**
     * Sets the value of the paymentFee property.
     * 
     * @param paymentFee
     *     allowed object is
     *     {@link String }
     *     
     */
	public void setPaymentFee(String paymentFee) {
		this.paymentFee = paymentFee;
	}

    /**
     * Gets the value of the paymentAmount property.
     * 
     * @return
     *     possible object is
     *     {@link int }
     *     
     */
	public Integer getPaymentAmount() {
		return paymentAmount;
	}

    /**
     * Sets the value of the paymentAmount property.
     * 
     * @param paymentAmount
     *     allowed object is
     *     {@link int }
     *     
     */
	public void setPaymentAmount(Integer paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

    /**
     * Gets the value of the paymentNote property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
	public String getPaymentNote() {
		return paymentNote;
	}

    /**
     * Sets the value of the paymentNote property.
     * 
     * @param paymentNote
     *     allowed object is
     *     {@link String }
     *     
     */
	public void setPaymentNote(String paymentNote) {
		this.paymentNote = paymentNote;
	}

    /**
     * Gets the value of the bankInfo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
	public String getBankInfo() {
		return bankInfo;
	}

    /**
     * Sets the value of the bankInfo property.
     * 
     * @param bankInfo
     *     allowed object is
     *     {@link String }
     *     
     */
	public void setBankInfo(String bankInfo) {
		this.bankInfo = bankInfo;
	}

    /**
     * Gets the value of the epaymentProfile property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
	public String getEpaymentProfile() {
		return epaymentProfile;
	}

    /**
     * Sets the value of the epaymentProfile property.
     * 
     * @param epaymentProfile
     *     allowed object is
     *     {@link String }
     *     
     */
	public void setEpaymentProfile(String epaymentProfile) {
		this.epaymentProfile = epaymentProfile;
	}

    /**
     * Gets the value of the paymentStatus property.
     * 
     * @return
     *     possible object is
     *     {@link int }
     *     
     */
	public Integer getPaymentStatus() {
		return paymentStatus;
	}

    /**
     * Sets the value of the paymentStatus property.
     * 
     * @param paymentStatus
     *     allowed object is
     *     {@link int }
     *     
     */
	public void setPaymentStatus(Integer paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

    /**
     * Gets the value of the paymentMethod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
	public String getPaymentMethod() {
		return paymentMethod;
	}

    /**
     * Sets the value of the paymentMethod property.
     * 
     * @param paymentMethod
     *     allowed object is
     *     {@link String }
     *     
     */
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

    /**
     * Gets the value of the confirmDatetime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
	public String getConfirmDatetime() {
		return confirmDatetime;
	}

    /**
     * Sets the value of the confirmDatetime property.
     * 
     * @param confirmDatetime
     *     allowed object is
     *     {@link String }
     *     
     */
	public void setConfirmDatetime(String confirmDatetime) {
		this.confirmDatetime = confirmDatetime;
	}

    /**
     * Gets the value of the confirmPayload property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
	public String getConfirmPayload() {
		return confirmPayload;
	}

    /**
     * Sets the value of the confirmPayload property.
     * 
     * @param confirmPayload
     *     allowed object is
     *     {@link String }
     *     
     */
	public void setConfirmPayload(String confirmPayload) {
		this.confirmPayload = confirmPayload;
	}

    /**
     * Gets the value of the confirmFileType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
	public String getConfirmFileType() {
		return confirmFileType;
	}

    /**
     * Sets the value of the confirmFileType property.
     * 
     * @param confirmFileType
     *     allowed object is
     *     {@link String }
     *     
     */
	public void setConfirmFileType(String confirmFileType) {
		this.confirmFileType = confirmFileType;
	}

    /**
     * Gets the value of the confirmFileSize property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
	public Long getConfirmFileSize() {
		return confirmFileSize;
	}

    /**
     * Sets the value of the confirmFileSize property.
     * 
     * @param confirmFileSize
     *     allowed object is
     *     {@link Long }
     *     
     */
	public void setConfirmFileSize(Long confirmFileSize) {
		this.confirmFileSize = confirmFileSize;
	}

    /**
     * Gets the value of the confirmNote property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
	public String getConfirmNote() {
		return confirmNote;
	}

    /**
     * Sets the value of the confirmNote property.
     * 
     * @param confirmNote
     *     allowed object is
     *     {@link String }
     *     
     */
	public void setConfirmNote(String confirmNote) {
		this.confirmNote = confirmNote;
	}

    /**
     * Gets the value of the approveDatetime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
	public String getApproveDatetime() {
		return approveDatetime;
	}

    /**
     * Sets the value of the approveDatetime property.
     * 
     * @param approveDatetime
     *     allowed object is
     *     {@link String }
     *     
     */
	public void setApproveDatetime(String approveDatetime) {
		this.approveDatetime = approveDatetime;
	}

    /**
     * Gets the value of the accountUserName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
	public String getAccountUserName() {
		return accountUserName;
	}

    /**
     * Sets the value of the accountUserName property.
     * 
     * @param accountUserName
     *     allowed object is
     *     {@link String }
     *     
     */
	public void setAccountUserName(String accountUserName) {
		this.accountUserName = accountUserName;
	}

    /**
     * Gets the value of the govAgencyTaxNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
	public String getGovAgencyTaxNo() {
		return govAgencyTaxNo;
	}

    /**
     * Sets the value of the govAgencyTaxNo property.
     * 
     * @param govAgencyTaxNo
     *     allowed object is
     *     {@link String }
     *     
     */
	public void setGovAgencyTaxNo(String govAgencyTaxNo) {
		this.govAgencyTaxNo = govAgencyTaxNo;
	}

    /**
     * Gets the value of the invoiceTemplateNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
	public String getInvoiceTemplateNo() {
		return invoiceTemplateNo;
	}

    /**
     * Sets the value of the invoiceTemplateNo property.
     * 
     * @param invoiceTemplateNo
     *     allowed object is
     *     {@link String }
     *     
     */
	public void setInvoiceTemplateNo(String invoiceTemplateNo) {
		this.invoiceTemplateNo = invoiceTemplateNo;
	}

    /**
     * Gets the value of the invoiceIssueNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
	public String getInvoiceIssueNo() {
		return invoiceIssueNo;
	}

    /**
     * Sets the value of the invoiceIssueNo property.
     * 
     * @param invoiceIssueNo
     *     allowed object is
     *     {@link String }
     *     
     */
	public void setInvoiceIssueNo(String invoiceIssueNo) {
		this.invoiceIssueNo = invoiceIssueNo;
	}

    /**
     * Gets the value of the invoiceNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
	public String getInvoiceNo() {
		return invoiceNo;
	}

    /**
     * Sets the value of the invoiceNo property.
     * 
     * @param invoiceNo
     *     allowed object is
     *     {@link String }
     *     
     */
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

    /**
     * Gets the value of the invoiceFileType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
	public String getInvoiceFileType() {
		return invoiceFileType;
	}

    /**
     * Sets the value of the invoiceFileType property.
     * 
     * @param invoiceFileType
     *     allowed object is
     *     {@link String }
     *     
     */
	public void setInvoiceFileType(String invoiceFileType) {
		this.invoiceFileType = invoiceFileType;
	}

    /**
     * Gets the value of the invoiceFileSize property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
	public Long getInvoiceFileSize() {
		return invoiceFileSize;
	}

    /**
     * Sets the value of the invoiceFileSize property.
     * 
     * @param invoiceFileSize
     *     allowed object is
     *     {@link Long }
     *     
     */
	public void setInvoiceFileSize(Long invoiceFileSize) {
		this.invoiceFileSize = invoiceFileSize;
	}
}
