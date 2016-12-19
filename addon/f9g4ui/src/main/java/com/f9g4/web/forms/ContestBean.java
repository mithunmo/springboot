package com.f9g4.web.forms;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.ui.ModelMap;

import com.f9g4.businessobjects.domain.AdLookupValuesDomain;
import com.f9g4.businessobjects.domain.StSeasonYearDomain;
import com.f9g4.businessobjects.domain.TrPortfolioContestDomain;
import com.f9g4.common.util.ContestStatusEnum;
import com.f9g4.common.util.ContestTypeEnum;
import com.f9g4.common.util.XMLGregorianCalendarConverter;
import com.f9g4.web.Helper.KeywordXmlHelper;
import com.f9g4.web.Helper.ProjectHelper;


public class ContestBean {

	private TrPortfolioContestDomain originalData;
	private Date startDate;
	private Date endDate;
	private StSeasonYearDomain seasonYear;
	private List<AdLookupValuesDomain> boardDimension;
	private List<AdLookupValuesDomain> boardFormat;
	
	public ContestBean()
	{
		this.boardDimension = new ArrayList();
		this.boardFormat = new ArrayList();
	}
	
	//get project unique number
	public String getProjectId()
	{
		return ProjectHelper.projectIdFormatter(originalData);
	}
	
	//get value from originalData
	public String getTitle() {
		return originalData.getContestPortfolioDomain().getName().replace("{{DEFAULT}}", "");
	}
	
	public StSeasonYearDomain getSeasonYear() {
		return seasonYear;
	};

	public void setSeasonYear(StSeasonYearDomain searsonYear) {
		this.seasonYear = searsonYear;
	}

	public ModelMap getContestTypeMap()
	{
		ModelMap map = new ModelMap();
		map.addAttribute(Integer.toString(this.originalData.getProjectType()), true);
		return map;
	}
	public ModelMap getContestStatusMap()
	{
		ModelMap map = new ModelMap();
		map.addAttribute(Integer.toString(this.originalData.getProjectStatus()), true);
		return map;
	}
	public ModelMap getSeasonYearMap()
	{
		ModelMap map = new ModelMap();
		if(this.getSeasonYear().getSeason().toUpperCase().contains("WINTER"))
			map.addAttribute("isWinter", true);
		else if(this.getSeasonYear().getSeason().toUpperCase().contains("SPRING"))
			map.addAttribute("isSpring", true);
		else if(this.getSeasonYear().getSeason().toUpperCase().contains("FALL"))
			map.addAttribute("isFall", true);
		else if(this.getSeasonYear().getSeason().toUpperCase().contains("SUMMER"))
			map.addAttribute("isSummer", true);
		else
			map.addAttribute("isOther", true);
		return map;
	}
	public String getContestType()
	{
		String type="UNKNOWN";
		for(ContestTypeEnum item : ContestTypeEnum.values())
		{
			if(this.originalData.getProjectType()==item.getId())
				type=item.getCode();
		}
		return type;
	}
	public String getContestStatus()
	{
		String status="UNKNOWN";
		for(ContestStatusEnum item : ContestStatusEnum.values())
		{
			if(this.originalData.getProjectStatus()==item.getId())
				status=item.getCode();
		}
		return status;
	}
	
	//check today pass the due date or not
	public boolean getPassDue()
	{
		Date now = new Date(); //UTC time
		Calendar endDate = XMLGregorianCalendarConverter.convertXMLGregorianCalendarToCalendar(this.originalData.getEndDate()); //UTC time
		if(now.after(endDate.getTime()))
			return true;
		return false;
	}
	public int getRemainingDays()
	{
		Date now = new Date(); //UTC time
		Calendar endDate = XMLGregorianCalendarConverter.convertXMLGregorianCalendarToCalendar(this.originalData.getEndDate()); //UTC time
		Long remaingDays = (endDate.getTime().getTime() - now.getTime())/(1000*60*60*24);
		if(remaingDays<0)
			remaingDays=new Long(0);
		return remaingDays.intValue();
	}
	public int getRunningDays()
	{
		Date now = new Date(); //UTC time
		Calendar startDate = XMLGregorianCalendarConverter.convertXMLGregorianCalendarToCalendar(this.originalData.getStartDate()); //UTC time
		Long runningDays = (now.getTime() - startDate.getTime().getTime())/(1000*60*60*24);
		return runningDays.intValue();
	}
	public String getEndDateInMonth() {
		return new SimpleDateFormat("MMM").format(endDate.getTime());
	}
	public String getEndDateInDay() {
		return new SimpleDateFormat("dd").format(endDate.getTime());
	}
	public String getStartDateInDay() {
		return new SimpleDateFormat("dd").format(startDate.getTime());
	}
	public String getStartDateInMonth() {
		return new SimpleDateFormat("MMM").format(startDate.getTime());
	}
	public TrPortfolioContestDomain getOriginalData() {
		return originalData;
	}
	public void setOriginalData(TrPortfolioContestDomain originalData) {
		this.originalData = originalData;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public ModelMap getSubKeywords() {
		ModelMap keywordsHM = KeywordXmlHelper.retrieveSubkeywordContentAsHashMap(originalData.getCategory());
		return keywordsHM;
	}
	public List<String> getProductType() {
		List<String> productType = KeywordXmlHelper.retrieveProductTypeContentAsList(originalData.getCategory());
		return productType;
	}
	public List<String> getProduct() {
		List<String> product = KeywordXmlHelper.retrieveBoardCategoryLevelAslist(3, originalData.getCategory());
		return product;
	}

	
	public List<AdLookupValuesDomain> getBoardDimension() {
		return boardDimension;
	}

	public void setBoardDimension(List<AdLookupValuesDomain> boardDimension) {
		this.boardDimension.addAll(boardDimension);
	}

	public List<AdLookupValuesDomain> getBoardFormat() {
		return boardFormat;
	}

	public void setBoardFormat(List<AdLookupValuesDomain> boardFormat) {
		this.boardFormat.addAll(boardFormat);
	}

	public String getProjectBoardDimension(){
		String dimension = new String();
		for (AdLookupValuesDomain  item : this.getBoardDimension() ) {
			if (item.getLookupValueId() == this.originalData.getBoardDimension() ){
				dimension =  item.getDescription();
				break;
			}
		}
		return dimension;		
	}

	public String getProjectBoardFormat(){
		String format = new String();
		for (AdLookupValuesDomain  item : this.getBoardFormat() ) {			
			if (item.getLookupValueId() == this.originalData.getBoardFormat() ){
				format = item.getDescription();
				break;
			}
		}
		return format;		
	}
	
	public String getSeason(){
		return this.getSeasonYear().getSeason();
	}
	
	@Override
	public String toString() {
		return "ContestBean [originalData=" + originalData + ", startDate="
				+ startDate + ", endDate=" + endDate + ", searsonYear="
				+ seasonYear + "]";
	}
}
