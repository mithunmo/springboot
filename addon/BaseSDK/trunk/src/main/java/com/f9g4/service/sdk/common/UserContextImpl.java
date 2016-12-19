package com.f9g4.service.sdk.common;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;


@Component("userContext")
@Scope(value="session")
public class UserContextImpl implements UserContext{

	private static final long serialVersionUID = 507352020190559401L;
	
	private String corelationId;
	private String memberIdNSession;
	

	public String getCorelationId() {
		return corelationId;
	}

	public void setCorelationId(String corelationId) {
		this.corelationId = corelationId;
	}

	public String getMemberIdNSession() {
		return memberIdNSession;
	}

	public void setMemberIdNSession(String memberIdNSession) {
		this.memberIdNSession = memberIdNSession;
	}


	@Override
	public String toString() {
		return "UserContextImpl [corelationId=" + corelationId
				+ ", memberIdNSession=" + memberIdNSession + "]";
	}

		
}
