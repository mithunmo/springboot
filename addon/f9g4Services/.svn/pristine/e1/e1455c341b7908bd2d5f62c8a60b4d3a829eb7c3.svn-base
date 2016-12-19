package com.f9g4.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllTrBoards", query = "select myTrBoard from TrBoard myTrBoard"),
		@NamedQuery(name = "findTrBoardByBoardId", query = "select myTrBoard from TrBoard myTrBoard where myTrBoard.boardId = ?1"),
		@NamedQuery(name = "findTrBoardByBoardPrice", query = "select myTrBoard from TrBoard myTrBoard where myTrBoard.boardPrice = ?1"),
		@NamedQuery(name = "findTrBoardByCreatedBy", query = "select myTrBoard from TrBoard myTrBoard where myTrBoard.createdBy = ?1"),
		@NamedQuery(name = "findTrBoardByCreationDate", query = "select myTrBoard from TrBoard myTrBoard where myTrBoard.creationDate = ?1"),
		@NamedQuery(name = "findTrBoardByDescription", query = "select myTrBoard from TrBoard myTrBoard where myTrBoard.description = ?1"),
		@NamedQuery(name = "findTrBoardByDescriptionContaining", query = "select myTrBoard from TrBoard myTrBoard where myTrBoard.description like ?1"),
		@NamedQuery(name = "findTrBoardByExpirationDate", query = "select myTrBoard from TrBoard myTrBoard where myTrBoard.expirationDate = ?1"),
		@NamedQuery(name = "findTrBoardByKeyword", query = "select myTrBoard from TrBoard myTrBoard where myTrBoard.keyword = ?1"),
		@NamedQuery(name = "findTrBoardByKeywordContaining", query = "select myTrBoard from TrBoard myTrBoard where myTrBoard.keyword like ?1"),
		@NamedQuery(name = "findTrBoardByLangCode", query = "select myTrBoard from TrBoard myTrBoard where myTrBoard.langCode = ?1"),
		@NamedQuery(name = "findTrBoardByLangCodeContaining", query = "select myTrBoard from TrBoard myTrBoard where myTrBoard.langCode like ?1"),
		@NamedQuery(name = "findTrBoardByLastUpdateDate", query = "select myTrBoard from TrBoard myTrBoard where myTrBoard.lastUpdateDate = ?1"),
		@NamedQuery(name = "findTrBoardByLastUpdatedBy", query = "select myTrBoard from TrBoard myTrBoard where myTrBoard.lastUpdatedBy = ?1"),
		@NamedQuery(name = "findTrBoardByName", query = "select myTrBoard from TrBoard myTrBoard where myTrBoard.name = ?1"),
		@NamedQuery(name = "findTrBoardByNameContaining", query = "select myTrBoard from TrBoard myTrBoard where myTrBoard.name like ?1"),
		@NamedQuery(name = "findTrBoardByPrimaryKey", query = "select myTrBoard from TrBoard myTrBoard where myTrBoard.boardId = ?1"),
		@NamedQuery(name = "findTrBoardByPublishToMp", query = "select myTrBoard from TrBoard myTrBoard where myTrBoard.publishToMp = ?1 AND myTrBoard.activeStatus = 1"),
		@NamedQuery(name = "findTrBoardByPortfolioId", query = "select myTrBoard from TrBoard myTrBoard where myTrBoard.trPortfolio.portfolioId = ?1 and myTrBoard.adUsersByCurrentUserId.userId=myTrBoard.adUsersByOriginalUserId.userId and myTrBoard.activeStatus = 1 "),

		@NamedQuery(name = "findTrBoardByPortfolioIdforBuyer", query = "select myTrBoard from TrBoard myTrBoard where myTrBoard.trPortfolio.portfolioId = ?1  and myTrBoard.activeStatus = 1 and myTrBoard.publishToMp = 1"),
		@NamedQuery(name = "findTrBoardByPortfolioIdforUser", query = "select myTrBoard from TrBoard myTrBoard where myTrBoard.trPortfolio.portfolioId = ?1 and myTrBoard.adUsersByOriginalUserId.userId = ?2  "),

		
		@NamedQuery(name = "findTrBoardByCurrentUserId", query = "select myTrBoard from TrBoard myTrBoard where myTrBoard.adUsersByCurrentUserId.userId = ?1"),
		@NamedQuery(name = "findTrBoardByBoardIds", query = "select myTrBoard from TrBoard myTrBoard where myTrBoard.boardId in ?1"),
		@NamedQuery(name = "findTrBoardByTotalPrice", query = "select myTrBoard from TrBoard myTrBoard where myTrBoard.totalPrice = ?1"),
		//Check the board is not deleted and still available(470), and the original user is still valid(not deleted and not expired).
		@NamedQuery(name = "findTrBoardByContainingPublishToMP", query = "select myTrBoard from TrBoard myTrBoard, AdUserMemberships myMembership " +
				"where myTrBoard.publishToMp in ?1 AND myTrBoard.trPortfolio.sellable in ?2 AND myTrBoard.adLookupValuesStatusId.lookupCode = 'AVAILABLE' AND myTrBoard.activeStatus = 1 AND sysdate() between myTrBoard.effectiveDate and myTrBoard.expirationDate " +
				"AND myTrBoard.adUsersByOriginalUserId.activeStatus = 1 AND myTrBoard.adUsersByOriginalUserId = myMembership.adUsers AND sysdate() between myMembership.effectiveDate and myMembership.expirationDate"),
		//Old logic Get sample boards for all users
		/*@NamedQuery(name = "findTrBoardForSample", query = "select myTrBoard from TrBoard myTrBoard " +
				"where myTrBoard.publishToMp = 2 AND myTrBoard.adLookupValuesStatusId.lookupCode = 'AVAILABLE' AND myTrBoard.activeStatus = 0 " +
				"AND myTrBoard.adUsersByOriginalUserId.activeStatus = 1 AND ( myTrBoard.adUsersByOriginalUserId.adLookupValuesByRegStatusId.lookupCode = 'SBSC' OR myTrBoard.adUsersByOriginalUserId.adLookupValuesByRegStatusId.lookupCode = 'CF' OR myTrBoard.adUsersByOriginalUserId.adLookupValuesByRegStatusId.lookupCode = 'WC') "),
				//Get sample boards for all users
		@NamedQuery(name = "findTrBoardForSampleByUserId", query = "select myTrBoard from TrBoard myTrBoard " +
				"where myTrBoard.publishToMp = 2 AND myTrBoard.adLookupValuesStatusId.lookupCode = 'AVAILABLE' AND myTrBoard.activeStatus = 0 " +
				"AND myTrBoard.adUsersByOriginalUserId.userId IN ?1 AND myTrBoard.adUsersByOriginalUserId.activeStatus = 1 AND ( myTrBoard.adUsersByOriginalUserId.adLookupValuesByRegStatusId.lookupCode = 'SBSC' OR myTrBoard.adUsersByOriginalUserId.adLookupValuesByRegStatusId.lookupCode = 'CF' OR myTrBoard.adUsersByOriginalUserId.adLookupValuesByRegStatusId.lookupCode = 'WC') "),*/
		//Get sample boards for all users		
		@NamedQuery(name = "findTrBoardForSample", query = "select myTrBoard from TrBoard myTrBoard " +
				"where myTrBoard.publishToMp = 2 AND myTrBoard.adLookupValuesStatusId.lookupCode = 'AVAILABLE' AND myTrBoard.activeStatus = 0 " +
				"AND myTrBoard.adUsersByOriginalUserId.activeStatus = 1 AND  myTrBoard.boardPrice = 1.00 AND myTrBoard.totalPrice = 1.00 AND (myTrBoard.name Like 'Example%' OR myTrBoard.name LIKE 'Sample%') "),
				//Get sample boards for all users
		@NamedQuery(name = "findTrBoardForSampleByUserId", query = "select myTrBoard from TrBoard myTrBoard " +
				"where myTrBoard.publishToMp = 2 AND myTrBoard.adLookupValuesStatusId.lookupCode = 'AVAILABLE' AND myTrBoard.activeStatus = 0 " +
				"AND myTrBoard.adUsersByOriginalUserId.userId IN ?1 AND myTrBoard.adUsersByOriginalUserId.activeStatus = 1 AND myTrBoard.boardPrice = 1.00 AND myTrBoard.totalPrice = 1.00 AND (myTrBoard.name Like 'Example%' OR myTrBoard.name LIKE 'Sample%') ")
		})

/**
?1 - designer name
?2 ,?3 - rating start and end
?4, ?5 - countryid's 
?6, ?7 - langids
?8, ?9 - skills id
?10 - awards - string

?11  - product  - p_category_id1
?12   - product type - p_category_id2
?13  -  category 3   -  p_category_id3
?14  -  category 4  -  p_category_id4 // no use for now
?15   -     season year ids - p_ss_year_id
?16   -     season year ids - p_ss_year_id
?17   -  saletype ids'  (image types) - p_sale_type_id
?18   -  saletype ids'  (image types) - p_sale_type_id
?19   -  price low
?20   -  price high
?21   -  Limit
?22   -  keywords
?23 - ?32 : catagory 4
?33 : st_mem_pricing_options id
?34 : category 3
 */

@NamedNativeQueries({
	@NamedNativeQuery(name = "findTrBoardsBySearchCriteria", query = 
	"SELECT tbm.*,tbi.*,(tbm.total_price+((tbm.total_price*commission)/100)) TEMP_SALE_PRICE "+
	" from tr_board tbm, tr_board_images tbi, st_mem_pricing_options po"+
	" where tbm.board_id = tbi.board_id "+
    "AND po.mem_pricing_id = ?33 "+
	"AND EXISTS ( "+
			"SELECT 1 "+
			" from tr_board tb " +
			" where "  +
			/* Designer Name */
			"  EXISTS (SELECT \'1\' FROM ad_users au WHERE au.active_status = 1 and upper(concat(FirstName, LastName)) like upper(replace(?1 ,' ','%')) AND au.user_id = tb.original_user_id AND au.admin_rating >1)" +
			
			/* Rating  for 5 Pass Low/High=5, 4 to 1 = low=1 and high =4 and for ALL = 0 and 5*/
			// " AND  (SELECT ifNULL(SUM(AVG_RATING),0) FROM tr_ratings tr WHERE tr.user_id = tb.original_user_id) Between ?2 AND ?3 " +
			" AND (SELECT ifNULL(ifNULL(SUM(AVG_RATING),0)/ifNULL(COUNT(AVG_RATING),1),0) FROM tr_ratings tr WHERE tr.user_id = tb.original_user_id) Between ?2 AND ?3 " +
			
			/* Designer Country PASS STRING OF COUNTRY IDs enclosed in ' */
			" AND EXISTS (SELECT 1 FROM ad_addresses aad WHERE aad.active_status = 1 and aad.user_id = tb.original_user_id AND ( aad.country_id in (?4) "  + /* Enclose String in single quotes */ 
		    " OR aad.country_id = IFNULL(?5, aad.country_id ))) " + /*Pass NULL If no data */
	
		    /* Languages PASS LANG CODE*/
			" AND EXISTS (SELECT 1 FROM ad_user_languages aul WHERE aul.active_status = 1 and aul.user_id = tb.original_user_id AND (aul.language_id in (?6)" + /* Enclose String in single quotes */
			" OR aul.language_id  = IFNULL(?7, aul.language_id))) " +			
	
			/* Skills PASS SKILL CODE */
			" AND EXISTS (SELECT 1 FROM ad_user_skills aus WHERE  aus.active_status = 1 and aus.user_id = tb.original_user_id AND (aus.skill_id in (?8) " + /* Enclose String in single quotes */
		    " OR aus.skill_id = IFNULL(?9, aus.skill_id))) " + 
			
			/* Schools,Awards,Events,Markets */
			" AND EXISTS (SELECT 1 FROM ad_users au  WHERE  au.active_status = 1 and upper(IFNULL(au.school_awards,'X')) like upper(?10) and au.user_id = tb.original_user_id ) " +

			/* Product Pass NULL if no Value */
			" AND EXISTS (Select 1 from tr_portfolio tp where tp.active_status = 1  and  tb.portfolio_id = tp.portfolio_id " +
			
					" AND tp.cat_level1_id =IFNULL(?11 ,tp.cat_level1_id) " +

					" AND tp.cat_level2_id = IFNULL(?12 ,tp.cat_level2_id) " +
					
					//" AND tb.cat_level3_id = IFNULL(?13 ,tb.cat_level3_id) " + //Move to keyword
					
					//" AND IFNULL(tb.cat_level4_id, 0) = IFNULL(?14, IFNULL(tb.cat_level4_id,0)) " + //Move to keyword
					
					/* Season PASS SEASON YEAR ID leave it blank to get all*/
					" AND (tp.season_year_id IN (?15) OR tp.season_year_id = IFNULL(?16, tp.season_year_id)) " +
			 ")" +		
			/* Board File Format */
			" AND ( tb.SALE_TYPE_ID IN (?17) OR tb.SALE_TYPE_ID = IFNULL(?18, tb.SALE_TYPE_ID)) " +
					
			/* price_range_options */
			" AND (tbm.total_price+((tbm.total_price*commission)/100)) between ifnull(?19, (tbm.total_price+((tbm.total_price*commission)/100))) and ifnull(?20,  (tbm.total_price+((tbm.total_price*commission)/100))) "  +  

			/* keywords */
			" AND EXISTS (SELECT 1 FROM ad_users au WHERE au.active_status = 1 " + 
			" and upper(tb.keyword) like upper(?22) " +
			/* for category level 3*/
			" and upper(tb.keyword) like upper(?34) " +
			/* for category 4*/
			" and ( upper(tb.keyword) like upper(?23) " +
			" OR upper(tb.keyword) like upper(?24) " +
			" OR upper(tb.keyword) like upper(?25) " +
			" OR upper(tb.keyword) like upper(?26) " +
			" OR upper(tb.keyword) like upper(?27) " +
			" OR upper(tb.keyword) like upper(?28) " +
			" OR upper(tb.keyword) like upper(?29) " +
			" OR upper(tb.keyword) like upper(?30) " +
			" OR upper(tb.keyword) like upper(?31) " +
			" OR upper(tb.keyword) like upper(?32) ) " +
			" and au.user_id = tb.original_user_id ) " +

			/* Exclude Expired members */
			" AND EXISTS (select 1 From ad_user_memberships aum Where aum.user_id = tb.original_user_id and sysdate() between aum.effective_date and aum.expiration_date) "  +
			
			/*Show only Available Boards */
			" AND EXISTS (SELECT 1 FROM ad_lookup_values alv where alv.active_status = 1 and alv.lookup_code = 'AVAILABLE' and alv. lookup_value_id = tb.status_id) " + 
			
			//04302014 Fred - new logic to check the original user is visible user=================================
			/*Portfolio has to be sellable*/
			" AND EXISTS (SELECT 1 FROM tr_portfolio tp WHERE tp.sellable = 1 and tp.portfolio_id = tb.portfolio_id) "+
			/*Designer has reviewed portfolio pages more than 3*/
			" AND EXISTS (SELECT 1 FROM tr_portfolio tp LEFT JOIN tr_board tbp ON tp.portfolio_id = tbp.portfolio_id "+
			" WHERE tp.sellable = 0 AND tp.active_status = 1 AND tbp.active_status = 1 AND tbp.publish_to_mp = 1 AND tp.user_id = tb.original_user_id "+
			" GROUP BY tbp.original_user_id "+
			" HAVING COUNT(tbp.board_id) >= 3) "+
			//=====================================================================================================
			
			/*Other Conditions */
            " AND tb.active_status = 1 "  + /*Show only those that are not deleted */
            " AND tb.current_user_id = tb.original_user_id " +   /*Show only those on the market */
            " AND tb.Expiration_Date > SYSDATE() " +
            " AND tb.Publish_to_mp = 1 " + /*Show only those on the market */
            " AND tbm.board_id = tb.board_id " +
            " ) "+
			" ORDER BY tbm.effective_date desc LIMIT 0, ?21" /*Show only top n records */
            ,
			resultClass = com.f9g4.domain.TrBoardSearch.class
		) 
	
	,  @NamedNativeQuery(name = "findTrBoardsFromRecentlyViewedBoards", query = 
			" select tb.*, tbi.*,(tb.total_price+((tb.total_price*commission)/100)) TEMP_SALE_PRICE " //apply company commission
			+ "  from tr_recently_viewed  tv,  tr_board tb, tr_board_images tbi, ad_lookup_values av, ad_lookup_types at,st_mem_pricing_options po "
			+ "  where tb.board_id = tv.board_id  " 
			+ "  and tb.board_id = tbi.board_id  and av.lookup_type_id = at.lookup_type_id " 
			+ "  and at.lookup_type = 'BOARD_SALE_STATUS' "
			+ "  and tb.publish_to_mp = 1 and tb.active_status = 1 " 
			+ "  and tb.status_id = av.lookup_value_id "	
			+ "  and av.lookup_code = 'AVAILABLE' "
			+ "  and tb.expiration_date > sysdate() " 
			+ " and tv.user_id = ?1 " 
			+ " and po.mem_pricing_id = ?3 " /*Company Pricing Option */
			+ " order by event_timestamp desc "  
			+ " limit 0, ?2 "
            ,
			resultClass = com.f9g4.domain.TrBoardSearch.class
	   )
	
	,  @NamedNativeQuery(name = "findTrBoardsForMayWeSuggest", query = 
			" select tb.*, tbi.*, (tb.total_price+((tb.total_price*commission)/100)) TEMP_SALE_PRICE " //apply company commission
					+ "  from tr_board tb, tr_board_images tbi, ad_lookup_values av, ad_lookup_types at, ad_users au, ad_user_memberships aum, st_mem_pricing_options po, tr_portfolio tp "
					+ "  where " 
					+ "  tb.board_id = tbi.board_id  and av.lookup_type_id = at.lookup_type_id " 
					+ "  and tb.original_user_id = au.user_id" //join ad_user table
					+ "  and tb.original_user_id = aum.user_id" //join ad_user_membership table
					+ "  and tb.portfolio_id = tp.portfolio_id " //join tr_portfolio table
					+ "  and au.active_status = 1" //the user must be active
					+ "  and aum.expiration_date > sysdate()" //the user must be not expired
					+ "  and at.lookup_type = 'BOARD_SALE_STATUS' "
					+ "  and tb.publish_to_mp = 1 and tb.active_status = 1 " 
					+ "  and tb.status_id = av.lookup_value_id "	
					+ "  and av.lookup_code = 'AVAILABLE' "
					+ "  and tb.expiration_date > sysdate() " 
					+ "  and po.mem_pricing_id = ?2 " /*Company Pricing Option */
					+ "  and tp.sellable = 1 " /* Boards have to be in the sellable portfolio */
					+ "  and au.admin_rating between ?3 and ?4 " /* Check designer's admin rating */
					/* board designer has to be visible designer */
					+ "  AND EXISTS (SELECT 1 FROM tr_portfolio tpi LEFT JOIN tr_board tbpi ON tpi.portfolio_id = tbpi.portfolio_id "
					+ "  	WHERE tpi.sellable = 0 AND tpi.active_status = 1 AND tbpi.active_status = 1 AND tbpi.publish_to_mp = 1 AND tpi.user_id = tb.original_user_id "
					+ "   	GROUP BY tbpi.original_user_id "
					+ "   	HAVING COUNT(tbpi.board_id) >= 3) "
					+ "  order by effective_date desc "  
					+ " limit 0, ?1 "
		            ,
					resultClass = com.f9g4.domain.TrBoardSearch.class					
		)
 })

@Table( name = "tr_board")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "f9g4/com/f9g4/app/domain", name = "TrBoard")
@XmlRootElement(namespace = "f9g4/com/f9g4/app/domain")
public class TrBoard implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/**
	 */
	
	@Column(name = "BOARD_ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer boardId;
	/**
	 */

	@Column(name = "NAME", length = 500, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String name;
	/**
	 */

	@Column(name = "DESCRIPTION", length = 4000)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String description;
	/**
	 * Designers wants to get paid
	 * 
	 */

	@Column(name = "BOARD_PRICE", scale = 2, precision = 15, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal boardPrice;
	
	/**
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EFFECTIVE_DATE", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar effectiveDate;
	
	/**
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EXPIRATION_DATE", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar expirationDate;
	/**
	 * Post to Market Place. 1= Post 0 = Do not Post
	 * 
	 */

	@Column(name = "PUBLISH_TO_MP", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer publishToMp;
	/**
	 */

	@Column(name = "KEYWORD", length = 4000)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String keyword;
	/**
	 */

	@Column(name = "TOTAL_PRICE", scale = 2, precision = 15, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal totalPrice;
	/**
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATION_DATE", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar creationDate;
	/**
	 */

	@Column(name = "CREATED_BY", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer createdBy;
	/**
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_UPDATE_DATE", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar lastUpdateDate;
	/**
	 */

	@Column(name = "LAST_UPDATED_BY", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer lastUpdatedBy;
	/**
	 */

	@Column(name = "LANG_CODE", length = 10, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String langCode;

	
	@Column(name = "ACTIVE_STATUS", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer activeStatus;
	
	@ManyToOne//(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "STATUS_ID", referencedColumnName = "LOOKUP_VALUE_ID", nullable = false) })
	@XmlTransient
	AdLookupValues adLookupValuesStatusId;

	/**
	 */
	@ManyToOne//(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "SALE_TYPE_ID", referencedColumnName = "LOOKUP_VALUE_ID", nullable = false) })
	@XmlTransient
	AdLookupValues adLookupValues;
	/**
	 */
	@ManyToOne//(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "CAT_LEVEL3_ID", referencedColumnName = "CATEGORY_ID", nullable = true) })
	@XmlTransient
	StCategoryMaster stCategoryMasterByCatLevel3Id;
	/**
	 */
	@ManyToOne//(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "CAT_LEVEL4_ID", referencedColumnName = "CATEGORY_ID", nullable = true) })
	@XmlTransient
	StCategoryMaster stCategoryMasterByCatLevel4Id;
	/**
	 */
	@ManyToOne//(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "ORIGINAL_USER_ID", referencedColumnName = "USER_ID", nullable = false) })
	@XmlTransient
	AdUsers adUsersByOriginalUserId;
	/**
	 */
	@ManyToOne//(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "CAT_LEVEL5_ID", referencedColumnName = "CATEGORY_ID") })
	@XmlTransient
	StCategoryMaster stCategoryMasterByCatLevel5Id;
	/**
	 */
	@ManyToOne//(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "CURRENT_USER_ID", referencedColumnName = "USER_ID", nullable = false) })
	@XmlTransient
	AdUsers adUsersByCurrentUserId;
	/**
	 */
	@ManyToOne//(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "PORTFOLIO_ID", referencedColumnName = "PORTFOLIO_ID", nullable = false) })
	@XmlTransient
	TrPortfolio trPortfolio;
	/**
	 */
	@OneToMany(mappedBy = "trBoard", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.f9g4.domain.TrSalesTransactionDetails> trSalesTransactionDetailses;
	/**
	 */
	@OneToMany(mappedBy = "trBoard", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.f9g4.domain.TrMessages> trMessageses;
	/**
	 */
	@OneToMany(mappedBy = "trBoard", cascade = { CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.f9g4.domain.TrBoardImages> trBoardImageses;
	/**
	 */
	@OneToMany(mappedBy = "trBoard", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.f9g4.domain.TrPaymentAuthSubmit> trPaymentAuthSubmits;
	/**
	 */
	@OneToMany(mappedBy = "trBoard", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.f9g4.domain.TrRatings> trRatingses;
	/**
	 */
	@OneToMany(mappedBy = "trBoard", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.f9g4.domain.TrRecentlyViewed> trRecentlyVieweds;

	
	/**
	 */
	public void setBoardId(Integer boardId) {
		this.boardId = boardId;
	}

	/**
	 */
	public Integer getBoardId() {
		return this.boardId;
	}

	/**
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 */
	public String getName() {
		return this.name;
	}

	/**
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Designers wants to get paid
	 * 
	 */
	public void setBoardPrice(BigDecimal boardPrice) {
		this.boardPrice = boardPrice;
	}

	/**
	 * Designers wants to get paid
	 * 
	 */
	public BigDecimal getBoardPrice() {
		return this.boardPrice;
	}

	public Calendar getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Calendar effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	/**
	 */
	public void setExpirationDate(Calendar expirationDate) {
		this.expirationDate = expirationDate;
	}

	/**
	 */
	public Calendar getExpirationDate() {
		return this.expirationDate;
	}

	/**
	 * Post to Market Place. 1= Post 0 = Do not Post
	 * 
	 */
	public void setPublishToMp(Integer publishToMp) {
		this.publishToMp = publishToMp;
	}

	/**
	 * Post to Market Place. 1= Post 0 = Do not Post
	 * 
	 */
	public Integer getPublishToMp() {
		return this.publishToMp;
	}

	/**
	 */
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	/**
	 */
	public String getKeyword() {
		return this.keyword;
	}

	/**
	 */
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	/**
	 */
	public BigDecimal getTotalPrice() {
		return this.totalPrice;
	}

	/**
	 */
	public void setCreationDate(Calendar creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 */
	public Calendar getCreationDate() {
		return this.creationDate;
	}

	/**
	 */
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 */
	public Integer getCreatedBy() {
		return this.createdBy;
	}

	/**
	 */
	public void setLastUpdateDate(Calendar lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	/**
	 */
	public Calendar getLastUpdateDate() {
		return this.lastUpdateDate;
	}

	/**
	 */
	public void setLastUpdatedBy(Integer lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	/**
	 */
	public Integer getLastUpdatedBy() {
		return this.lastUpdatedBy;
	}

	/**
	 */
	public void setLangCode(String langCode) {
		this.langCode = langCode;
	}

	/**
	 */
	public String getLangCode() {
		return this.langCode;
	}

	/**
	 */
	public void setAdLookupValues(AdLookupValues adLookupValues) {
		this.adLookupValues = adLookupValues;
	}

	/**
	 */
	@JsonIgnore
	public AdLookupValues getAdLookupValues() {
		return adLookupValues;
	}

	/**
	 */
	public void setStCategoryMasterByCatLevel3Id(StCategoryMaster stCategoryMasterByCatLevel3Id) {
		this.stCategoryMasterByCatLevel3Id = stCategoryMasterByCatLevel3Id;
	}

	/**
	 */
	@JsonIgnore
	public StCategoryMaster getStCategoryMasterByCatLevel3Id() {
		return stCategoryMasterByCatLevel3Id;
	}

	/**
	 */
	public void setStCategoryMasterByCatLevel4Id(StCategoryMaster stCategoryMasterByCatLevel4Id) {
		this.stCategoryMasterByCatLevel4Id = stCategoryMasterByCatLevel4Id;
	}

	/**
	 */
	@JsonIgnore
	public StCategoryMaster getStCategoryMasterByCatLevel4Id() {
		return stCategoryMasterByCatLevel4Id;
	}

	/**
	 */
	public void setAdUsersByOriginalUserId(AdUsers adUsersByOriginalUserId) {
		this.adUsersByOriginalUserId = adUsersByOriginalUserId;
	}

	/**
	 */
	@JsonIgnore
	public AdUsers getAdUsersByOriginalUserId() {
		return adUsersByOriginalUserId;
	}

	/**
	 */
	public void setStCategoryMasterByCatLevel5Id(StCategoryMaster stCategoryMasterByCatLevel5Id) {
		this.stCategoryMasterByCatLevel5Id = stCategoryMasterByCatLevel5Id;
	}

	/**
	 */
	@JsonIgnore
	public StCategoryMaster getStCategoryMasterByCatLevel5Id() {
		return stCategoryMasterByCatLevel5Id;
	}

	/**
	 */
	public void setAdUsersByCurrentUserId(AdUsers adUsersByCurrentUserId) {
		this.adUsersByCurrentUserId = adUsersByCurrentUserId;
	}

	/**
	 */
	@JsonIgnore
	public AdUsers getAdUsersByCurrentUserId() {
		return adUsersByCurrentUserId;
	}

	/**
	 */
	public void setTrPortfolio(TrPortfolio trPortfolio) {
		this.trPortfolio = trPortfolio;
	}

	/**
	 */
	@JsonIgnore
	public TrPortfolio getTrPortfolio() {
		return trPortfolio;
	}

	/**
	 */
	public void setTrSalesTransactionDetailses(Set<TrSalesTransactionDetails> trSalesTransactionDetailses) {
		this.trSalesTransactionDetailses = trSalesTransactionDetailses;
	}

	/**
	 */
	@JsonIgnore
	public Set<TrSalesTransactionDetails> getTrSalesTransactionDetailses() {
		if (trSalesTransactionDetailses == null) {
			trSalesTransactionDetailses = new java.util.LinkedHashSet<com.f9g4.domain.TrSalesTransactionDetails>();
		}
		return trSalesTransactionDetailses;
	}

	/**
	 */
	public void setTrMessageses(Set<TrMessages> trMessageses) {
		this.trMessageses = trMessageses;
	}

	/**
	 */
	@JsonIgnore
	public Set<TrMessages> getTrMessageses() {
		if (trMessageses == null) {
			trMessageses = new java.util.LinkedHashSet<com.f9g4.domain.TrMessages>();
		}
		return trMessageses;
	}

	/**
	 */
	public void setTrBoardImageses(Set<TrBoardImages> trBoardImageses) {
		this.trBoardImageses = trBoardImageses;
	}

	/**
	 */
	@JsonIgnore
	public Set<TrBoardImages> getTrBoardImageses() {
		if (trBoardImageses == null) {
			trBoardImageses = new java.util.LinkedHashSet<com.f9g4.domain.TrBoardImages>();
		}
		return trBoardImageses;
	}

	/**
	 */
	public void setTrPaymentAuthSubmits(Set<TrPaymentAuthSubmit> trPaymentAuthSubmits) {
		this.trPaymentAuthSubmits = trPaymentAuthSubmits;
	}

	/**
	 */
	@JsonIgnore
	public Set<TrPaymentAuthSubmit> getTrPaymentAuthSubmits() {
		if (trPaymentAuthSubmits == null) {
			trPaymentAuthSubmits = new java.util.LinkedHashSet<com.f9g4.domain.TrPaymentAuthSubmit>();
		}
		return trPaymentAuthSubmits;
	}

	/**
	 */
	public void setTrRatingses(Set<TrRatings> trRatingses) {
		this.trRatingses = trRatingses;
	}

	/**
	 */
	@JsonIgnore
	public Set<TrRatings> getTrRatingses() {
		if (trRatingses == null) {
			trRatingses = new java.util.LinkedHashSet<com.f9g4.domain.TrRatings>();
		}
		return trRatingses;
	}

	/**
	 */
	public void setTrRecentlyVieweds(Set<TrRecentlyViewed> trRecentlyVieweds) {
		this.trRecentlyVieweds = trRecentlyVieweds;
	}

	/**
	 */
	@JsonIgnore
	public Set<TrRecentlyViewed> getTrRecentlyVieweds() {
		if (trRecentlyVieweds == null) {
			trRecentlyVieweds = new java.util.LinkedHashSet<com.f9g4.domain.TrRecentlyViewed>();
		}
		return trRecentlyVieweds;
	}


	public AdLookupValues getAdLookupValuesStatusId() {
		return adLookupValuesStatusId;
	}

	public void setAdLookupValuesStatusId(AdLookupValues adLookupValuesStatusId) {
		this.adLookupValuesStatusId = adLookupValuesStatusId;
	}

	public Integer getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(Integer activeStatus) {
		this.activeStatus = activeStatus;
	}

	/**
	 */
	public TrBoard() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(TrBoard that) {
		setBoardId(that.getBoardId());
		setName(that.getName());
		setDescription(that.getDescription());
		setBoardPrice(that.getBoardPrice());
		setExpirationDate(that.getExpirationDate());
		setPublishToMp(that.getPublishToMp());
		setKeyword(that.getKeyword());
		setTotalPrice(that.getTotalPrice());
		setEffectiveDate(that.getEffectiveDate());
		setCreationDate(that.getCreationDate());
		setCreatedBy(that.getCreatedBy());
		setLastUpdateDate(that.getLastUpdateDate());
		setLastUpdatedBy(that.getLastUpdatedBy());
		setLangCode(that.getLangCode());
		setAdLookupValues(that.getAdLookupValues());
		setStCategoryMasterByCatLevel3Id(that.getStCategoryMasterByCatLevel3Id());
		setStCategoryMasterByCatLevel4Id(that.getStCategoryMasterByCatLevel4Id());
		setAdUsersByOriginalUserId(that.getAdUsersByOriginalUserId());
		setStCategoryMasterByCatLevel5Id(that.getStCategoryMasterByCatLevel5Id());
		setAdUsersByCurrentUserId(that.getAdUsersByCurrentUserId());
		setTrPortfolio(that.getTrPortfolio());
		setTrSalesTransactionDetailses(new java.util.LinkedHashSet<com.f9g4.domain.TrSalesTransactionDetails>(that.getTrSalesTransactionDetailses()));
		setTrMessageses(new java.util.LinkedHashSet<com.f9g4.domain.TrMessages>(that.getTrMessageses()));
		setTrBoardImageses(new java.util.LinkedHashSet<com.f9g4.domain.TrBoardImages>(that.getTrBoardImageses()));
		setTrPaymentAuthSubmits(new java.util.LinkedHashSet<com.f9g4.domain.TrPaymentAuthSubmit>(that.getTrPaymentAuthSubmits()));
		setTrRatingses(new java.util.LinkedHashSet<com.f9g4.domain.TrRatings>(that.getTrRatingses()));
		setTrRecentlyVieweds(new java.util.LinkedHashSet<com.f9g4.domain.TrRecentlyViewed>(that.getTrRecentlyVieweds()));
	}

	@Override
	public String toString() {
		return "TrBoard [boardId=" + boardId + ", name=" + name
				+ ", description=" + description + ", boardPrice=" + boardPrice
				+ ", effectiveDate=" + effectiveDate + ", expirationDate="
				+ expirationDate + ", publishToMp=" + publishToMp
				+ ", keyword=" + keyword + ", totalPrice=" + totalPrice
				+ ", creationDate=" + creationDate + ", createdBy=" + createdBy
				+ ", lastUpdateDate=" + lastUpdateDate + ", lastUpdatedBy="
				+ lastUpdatedBy + ", langCode=" + langCode + ", activeStatus="
				+ activeStatus + ", adLookupValues=" + adLookupValues
				+ ", stCategoryMasterByCatLevel3Id="
				+ stCategoryMasterByCatLevel3Id
				+ ", stCategoryMasterByCatLevel4Id="
				+ stCategoryMasterByCatLevel4Id + ", adUsersByOriginalUserId="
				+ adUsersByOriginalUserId + ", stCategoryMasterByCatLevel5Id="
				+ stCategoryMasterByCatLevel5Id + ", adUsersByCurrentUserId="
				+ adUsersByCurrentUserId + ", trPortfolio=" + trPortfolio
				+ ", trSalesTransactionDetailses="
				+ trSalesTransactionDetailses + ", trMessageses="
				+ trMessageses + ", trBoardImageses=" + trBoardImageses
				+ ", trPaymentAuthSubmits=" + trPaymentAuthSubmits
				+ ", trRatingses=" + trRatingses + ", trRecentlyVieweds="
				+ trRecentlyVieweds + "]";
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((boardId == null) ? 0 : boardId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof TrBoard))
			return false;
		TrBoard equalCheck = (TrBoard) obj;
		if ((boardId == null && equalCheck.boardId != null) || (boardId != null && equalCheck.boardId == null))
			return false;
		if (boardId != null && !boardId.equals(equalCheck.boardId))
			return false;
		return true;
	}
}
