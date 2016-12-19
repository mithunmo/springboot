package com.f9g4.dao;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import com.f9g4.domain.AdEmailTemplates;

/**
 * DAO to manage TrPortfolio entities.
 * 
 */
public interface AdEmailTemplatesDAO extends JpaDao<AdEmailTemplates> {

	/**
	 * JPQL Query - findTrPortfolioByCreatedBy
	 *
	 */
	public AdEmailTemplates findAdEmailTemplatesById(Integer id);
	
	public AdEmailTemplates findAdEmailTemplatesByTemplateCode(String code);
	
	public Set<AdEmailTemplates> findAdEmailTemplatesByTemplateCodeContaining(String code);
	
}