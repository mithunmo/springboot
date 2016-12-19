package com.f9g4.dao;

import com.f9g4.domain.AdAddresses;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage AdAddresses entities.
 * 
 */
public interface AdAddressesDAO extends JpaDao<AdAddresses> {

	/**
	 * JPQL Query - findAdAddressesByPostalCode
	 *
	 */
	public Set<AdAddresses> findAdAddressesByPostalCode(String postalCode) throws DataAccessException;

	/**
	 * JPQL Query - findAdAddressesByPostalCode
	 *
	 */
	public Set<AdAddresses> findAdAddressesByPostalCode(String postalCode, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdAddressesByAddressId
	 *
	 */
	public AdAddresses findAdAddressesByAddressId(Integer addressId) throws DataAccessException;

	/**
	 * JPQL Query - findAdAddressesByAddressId
	 *
	 */
	public AdAddresses findAdAddressesByAddressId(Integer addressId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdAddressesByPrimaryKey
	 *
	 */
	public AdAddresses findAdAddressesByPrimaryKey(Integer addressId_1) throws DataAccessException;

	/**
	 * JPQL Query - findAdAddressesByPrimaryKey
	 *
	 */
	public AdAddresses findAdAddressesByPrimaryKey(Integer addressId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllAdAddressess
	 *
	 */
	public Set<AdAddresses> findAllAdAddressess() throws DataAccessException;

	/**
	 * JPQL Query - findAllAdAddressess
	 *
	 */
	public Set<AdAddresses> findAllAdAddressess(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdAddressesByCounty
	 *
	 */
	public Set<AdAddresses> findAdAddressesByCounty(String county) throws DataAccessException;

	/**
	 * JPQL Query - findAdAddressesByCounty
	 *
	 */
	public Set<AdAddresses> findAdAddressesByCounty(String county, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdAddressesByAddressLine2Containing
	 *
	 */
	public Set<AdAddresses> findAdAddressesByAddressLine2Containing(String addressLine2) throws DataAccessException;

	/**
	 * JPQL Query - findAdAddressesByAddressLine2Containing
	 *
	 */
	public Set<AdAddresses> findAdAddressesByAddressLine2Containing(String addressLine2, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdAddressesByCreationDate
	 *
	 */
	public Set<AdAddresses> findAdAddressesByCreationDate(java.util.Calendar creationDate) throws DataAccessException;

	/**
	 * JPQL Query - findAdAddressesByCreationDate
	 *
	 */
	public Set<AdAddresses> findAdAddressesByCreationDate(Calendar creationDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdAddressesByPostalCodeContaining
	 *
	 */
	public Set<AdAddresses> findAdAddressesByPostalCodeContaining(String postalCode_1) throws DataAccessException;

	/**
	 * JPQL Query - findAdAddressesByPostalCodeContaining
	 *
	 */
	public Set<AdAddresses> findAdAddressesByPostalCodeContaining(String postalCode_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdAddressesByCountyContaining
	 *
	 */
	public Set<AdAddresses> findAdAddressesByCountyContaining(String county_1) throws DataAccessException;

	/**
	 * JPQL Query - findAdAddressesByCountyContaining
	 *
	 */
	public Set<AdAddresses> findAdAddressesByCountyContaining(String county_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdAddressesByLastUpdatedBy
	 *
	 */
	public Set<AdAddresses> findAdAddressesByLastUpdatedBy(Integer lastUpdatedBy) throws DataAccessException;

	/**
	 * JPQL Query - findAdAddressesByLastUpdatedBy
	 *
	 */
	public Set<AdAddresses> findAdAddressesByLastUpdatedBy(Integer lastUpdatedBy, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdAddressesByLangCode
	 *
	 */
	public Set<AdAddresses> findAdAddressesByLangCode(String langCode) throws DataAccessException;

	/**
	 * JPQL Query - findAdAddressesByLangCode
	 *
	 */
	public Set<AdAddresses> findAdAddressesByLangCode(String langCode, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdAddressesByAddressLine1Containing
	 *
	 */
	public Set<AdAddresses> findAdAddressesByAddressLine1Containing(String addressLine1) throws DataAccessException;

	/**
	 * JPQL Query - findAdAddressesByAddressLine1Containing
	 *
	 */
	public Set<AdAddresses> findAdAddressesByAddressLine1Containing(String addressLine1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdAddressesByCity
	 *
	 */
	public Set<AdAddresses> findAdAddressesByCity(String city) throws DataAccessException;

	/**
	 * JPQL Query - findAdAddressesByCity
	 *
	 */
	public Set<AdAddresses> findAdAddressesByCity(String city, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdAddressesByState
	 *
	 */
	public Set<AdAddresses> findAdAddressesByState(String state) throws DataAccessException;

	/**
	 * JPQL Query - findAdAddressesByState
	 *
	 */
	public Set<AdAddresses> findAdAddressesByState(String state, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdAddressesByActiveStatus
	 *
	 */
	public Set<AdAddresses> findAdAddressesByActiveStatus(Integer activeStatus) throws DataAccessException;

	/**
	 * JPQL Query - findAdAddressesByActiveStatus
	 *
	 */
	public Set<AdAddresses> findAdAddressesByActiveStatus(Integer activeStatus, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdAddressesByLastUpdateDate
	 *
	 */
	public Set<AdAddresses> findAdAddressesByLastUpdateDate(java.util.Calendar lastUpdateDate) throws DataAccessException;

	/**
	 * JPQL Query - findAdAddressesByLastUpdateDate
	 *
	 */
	public Set<AdAddresses> findAdAddressesByLastUpdateDate(Calendar lastUpdateDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdAddressesByLangCodeContaining
	 *
	 */
	public Set<AdAddresses> findAdAddressesByLangCodeContaining(String langCode_1) throws DataAccessException;

	/**
	 * JPQL Query - findAdAddressesByLangCodeContaining
	 *
	 */
	public Set<AdAddresses> findAdAddressesByLangCodeContaining(String langCode_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdAddressesByCityContaining
	 *
	 */
	public Set<AdAddresses> findAdAddressesByCityContaining(String city_1) throws DataAccessException;

	/**
	 * JPQL Query - findAdAddressesByCityContaining
	 *
	 */
	public Set<AdAddresses> findAdAddressesByCityContaining(String city_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdAddressesByStateContaining
	 *
	 */
	public Set<AdAddresses> findAdAddressesByStateContaining(String state_1) throws DataAccessException;

	/**
	 * JPQL Query - findAdAddressesByStateContaining
	 *
	 */
	public Set<AdAddresses> findAdAddressesByStateContaining(String state_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdAddressesByAddressLine1
	 *
	 */
	public Set<AdAddresses> findAdAddressesByAddressLine1(String addressLine1_1) throws DataAccessException;

	/**
	 * JPQL Query - findAdAddressesByAddressLine1
	 *
	 */
	public Set<AdAddresses> findAdAddressesByAddressLine1(String addressLine1_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdAddressesByCreatedBy
	 *
	 */
	public Set<AdAddresses> findAdAddressesByCreatedBy(Integer createdBy) throws DataAccessException;

	/**
	 * JPQL Query - findAdAddressesByCreatedBy
	 *
	 */
	public Set<AdAddresses> findAdAddressesByCreatedBy(Integer createdBy, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAdAddressesByAddressLine2
	 *
	 */
	public Set<AdAddresses> findAdAddressesByAddressLine2(String addressLine2_1) throws DataAccessException;

	/**
	 * JPQL Query - findAdAddressesByAddressLine2
	 *
	 */
	public Set<AdAddresses> findAdAddressesByAddressLine2(String addressLine2_1, int startResult, int maxRows) throws DataAccessException;

}