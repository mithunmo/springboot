package com.f9g4.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.f9g4.businessobjects.domain.AdCompanyNewsDetailDomain;
import com.f9g4.businessobjects.domain.AdCompanyNewsDomain;
import com.f9g4.businessobjects.services.GetCompanyNewsDetailbyIdRequest;
import com.f9g4.businessobjects.services.GetCompanyNewsDetailbyIdResponse;
import com.f9g4.businessobjects.services.GetCompanyNewsResponse;
import com.f9g4.dao.AdCompanyNewsDAO;
import com.f9g4.dao.AdCompanyNewsDAOImpl;
import com.f9g4.dao.AdCompanyNewsDetailDAO;
import com.f9g4.domain.AdCompanyNews;
import com.f9g4.domain.AdCompanyNewsDetail;
import com.f9g4.services.rest.ICompanyNews;

@Service("companyNews")
public class CompanyNewsService implements ICompanyNews {
	
	@Autowired
	private AdCompanyNewsDAO AdCompanyNewsDAO;
	
	@Autowired
	private AdCompanyNewsDetailDAO AdCompanyNewsDetailDAO;
	

	public GetCompanyNewsResponse getCompanyNews() {
		GetCompanyNewsResponse response = new GetCompanyNewsResponse();
		
		List<AdCompanyNewsDomain> newsdomain= new ArrayList<AdCompanyNewsDomain>();
		 List<AdCompanyNews> newsList=AdCompanyNewsDAO.findAllActiveAdCompanyNewss(0, 10);
		 for (AdCompanyNews adCompanyNews : newsList) {
			AdCompanyNewsDomain domain=new AdCompanyNewsDomain();
			domain.setCompanyNewsId(adCompanyNews.getCompNewsId());
			domain.setContentAlias(adCompanyNews.getContentAlias());
			domain.setContentLocation(adCompanyNews.getContentLocation());
			domain.setContentType(adCompanyNews.getContentType());
			AdCompanyNewsDetailDomain detailDomain=new AdCompanyNewsDetailDomain();
			//We need only one company news details so overwritting with last record if we get more then one this should never happen.
			for (AdCompanyNewsDetail adCompanyNews2 : adCompanyNews.getAdCompanyNewsDetails()) {
				detailDomain.setContentDetail(adCompanyNews2.getContentDetail());
				detailDomain.setContentHeading(adCompanyNews2.getContentHeading());
			}
			
			domain.getCompanyNewsDetails().add(detailDomain);
//			newsdomain.add(domain);
			response.getNews().add(domain);
			
		}
		 
		return response;
	}

	public GetCompanyNewsDetailbyIdResponse getCompanyNewsDetail(
			int newsdetailid) {
		
		GetCompanyNewsDetailbyIdResponse response=new GetCompanyNewsDetailbyIdResponse();
		
		AdCompanyNewsDetail detail= AdCompanyNewsDetailDAO.findAdCompanyNewsDetailByPrimaryKey(newsdetailid);
		
		AdCompanyNewsDetailDomain domain=new AdCompanyNewsDetailDomain();
		
		domain.setCompanyNewDetailId(detail.getCompNewsDtlId());
		domain.setCompanyNewsId(newsdetailid);
		domain.setContentDetail(detail.getContentDetail());
		domain.setContentHeading(detail.getContentHeading());
		domain.setContentImage(detail.getContentImage());
		domain.setContentImagePath(detail.getContentImagePath());
		domain.setCreatedby(detail.getCreatedBy());
		domain.setLastupdateby(detail.getLastUpdatedBy());
		response.setNewsDetail(domain);
		
		return response;
		
		
		
	}

}
