package com.f9g4.test.servicesdk;

import static org.junit.Assert.assertNotNull;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.UUID;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.util.Assert;

import com.f9g4.businessobjects.domain.AdActiveUserDomain;
import com.f9g4.businessobjects.domain.TrRecentlyViewedDomain;
import com.f9g4.businessobjects.services.AddRecentlyViewedBoardRequest;
import com.f9g4.businessobjects.services.AddRecentlyViewedBoardResponse;
import com.f9g4.businessobjects.services.AddUserLogRequest;
import com.f9g4.businessobjects.services.GetActiveuserResponse;
import com.f9g4.servicesdk.DataCaptureServiceSDK;

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class })
@ContextConfiguration(locations = { "classpath*:applicationContext.xml" })
public class DataCaptureServiceTest {

	@Autowired
	private DataCaptureServiceSDK dataCaptureServiceSDK;

	@Test
	public void testAddRecentActivities() {
		AddRecentlyViewedBoardRequest request = new AddRecentlyViewedBoardRequest();
		TrRecentlyViewedDomain domain = new TrRecentlyViewedDomain();
		domain.setBoardId(26);
		try {
			XMLGregorianCalendar xc;
			GregorianCalendar gc = new GregorianCalendar();
			gc.setTimeInMillis(Calendar.getInstance().getTimeInMillis());
			xc = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
			domain.setEventTime(xc);
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		domain.setUserId(17);
		domain.setCreatedby(17);
		domain.setLastupdateby(17);
		request.setLogBoard(domain);

		AddRecentlyViewedBoardResponse response = dataCaptureServiceSDK
				.addRecentlyViewBoard(request);
		Assert.notNull(response);

	}

	@Test
	public void testLogger() {
		AdActiveUserDomain domain = new AdActiveUserDomain();
		domain.setUserId(17);
		domain.setCreatedby(17);
		domain.setLoginDate(this.toXMLDateobject());
		
		domain.setSessionId(UUID.randomUUID().toString());
		AddUserLogRequest request = new AddUserLogRequest();
		request.setUserLogger(domain);

		dataCaptureServiceSDK.logUserData(request);
	}

	@Test
	public void testgetActiveUserLoggedRecord() {
		GetActiveuserResponse domain = dataCaptureServiceSDK
				.getActiveUserLoggedRecord("45f68a59-cecf-4714-a255-f1b1504c4557");
		assertNotNull(domain);
		assertNotNull(domain.getUserinfo());

	}

	private XMLGregorianCalendar toXMLDateobject() {
		try {
			XMLGregorianCalendar xc;
			GregorianCalendar gc = new GregorianCalendar();
			gc.setTimeInMillis(Calendar.getInstance().getTimeInMillis());
			xc = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
			return xc;
		} catch (Exception e) {
			return null;
		}
	}
}
