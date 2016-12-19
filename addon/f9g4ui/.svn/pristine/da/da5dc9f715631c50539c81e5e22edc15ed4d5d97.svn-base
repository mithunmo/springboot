package com.f9g4.web.forms;

import java.util.Date;

import javax.xml.datatype.XMLGregorianCalendar;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class ReferralForm 
{
	@NotEmpty(message="{require.firstName}")
	private String firstName;
	
	@NotEmpty(message="{require.lastName}")
	private String lastName;
	
	private String phone;
	
	@NotEmpty(message="{require.email}")
	@Email(message="{require.email.format}")
	private String email;
	
	@NotEmpty(message="{require.reason}")
	private String reason;
	
	@NotEmpty(message="{require.background}")
	private String background;
	
	private String status;
	
	private Date expirationDate;
	
	private Date dateSent;
	
	private String dateSentString;
	
	private String referredBy;
	
	
	public String getReferredBy() {
		return referredBy;
	}
	public void setReferredBy(String referredBy) {
		this.referredBy = referredBy;
	}
	public String getDateSentString() {
		return dateSentString;
	}
	public void setDateSentString(String dateSentString) {
		this.dateSentString = dateSentString;
	}
	public String getFirstName()
	{
		return this.firstName;
	}
	public void setFirstName(String firstName)
	{
		this.firstName=firstName;
	}
	
	public String getLastName()
	{
		return this.lastName;
	}
	public void setLastName(String lastName)
	{
		this.lastName=lastName;
	}
	
	public String getPhone()
	{
		return this.phone;
	}
	public void setPhone(String phone)
	{
		this.phone=phone;
	}
	
	public String getEmail()
	{
		return this.email;
	}
	public void setEmail(String email)
	{
		this.email=email;
	}
	
	public String getReason()
	{
		return this.reason;
	}
	public void setReason(String reason)
	{
		this.reason=reason;
	}
	
	public String getBackground()
	{
		return this.background;
	}
	public void setBackground(String background)
	{
		this.background=background;
	}
	public Date getExpirationDate() 
	{
		return expirationDate;
	}
	public void setExpirationDate(Date expirationDate) 
	{
		this.expirationDate = expirationDate;
	}
	public Date getDateSent() 
	{
		return dateSent;
	}
	public void setDateSent(Date dateSent) 
	{
		this.dateSent = dateSent;
	}
	public String getStatus() 
	{
		return status;
	}
	public void setStatus(String status) 
	{
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "ReferralForm [firstName=" + firstName + ", lastName="
				+ lastName + ", phone=" + phone + ", email=" + email
				+ ", reason=" + reason + ", background=" + background
				+ ", status=" + status + ", expirationDate=" + expirationDate
				+ ", dateSent=" + dateSent + ", dateSentString="
				+ dateSentString + ", referredBy=" + referredBy + "]";
	}
}
