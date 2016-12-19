package com.f9g4.web.Helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.springframework.ui.ModelMap;

public class KeywordXmlHelper {

	private KeywordXmlHelper() {}
	
	public static ModelMap retrieveSubkeywordContentAsHashMap(String source)
	{
		ModelMap model=new ModelMap();
		try
		{
			/*DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
        	DocumentBuilder b = f.newDocumentBuilder();
        	InputSource is = new InputSource(new StringReader(source));
        	Document doc = b.parse(is);*/
        	//check the keywords is xml
        	org.jsoup.nodes.Document doc = Jsoup.parse(source);
        	Elements root=doc.getElementsByTag("kw");
        	if(root.size()>0)
        	{
	        	Elements skw1=doc.getElementsByTag("skw1");
	        	String skw1Value=skw1.text();
	        	Elements skw2=doc.getElementsByTag("skw2");
	        	String skw2Value=skw2.text();
	        	Elements skw3=doc.getElementsByTag("skw3");
	        	String skw3Value=skw3.text();
	        	Elements skw4=doc.getElementsByTag("skw4");
	        	model.addAttribute("skw1", skw1.text());
	        	model.addAttribute("skw2", skw2.text());
	        	model.addAttribute("skw3", skw3.text());
	        	model.addAttribute("skw4", skw4.text());
        	}
        	else
        	{
        		model.addAttribute("skw1", source);
        	}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return model;
	}
	
	public static ModelMap retrieveProductTypeContentAsHashMap(String source)
	{
		ModelMap model=new ModelMap();
		//retrieve product type list
    	String productTypeList=KeywordXmlHelper.retrieveProductTypeContent(source);
    	String[] productTypeContainer=null;
    	HashMap<String, String> productTypeHM=new HashMap<String, String>();
    	if(productTypeList!=null)
    	{
    		 //Get content of the node
    		productTypeContainer=StringUtils.split(productTypeList, ","); //Split the content into array
    		//Convert string array to hashmap
    		for(String item:productTypeContainer)
    			productTypeHM.put(item, "true");
    	}
    	model.addAttribute("productTypeHM", productTypeHM);
		return model;
	}
	
	public static List<String> retrieveProductTypeContentAsList(String source)
	{
		//retrieve product type list
    	String productTypeList=KeywordXmlHelper.retrieveProductTypeContent(source);
    	String[] container=null;
    	List<String> result=new ArrayList<String>();
    	if(productTypeList!=null)
    	{
    		 //Get content of the node
    		container=StringUtils.split(productTypeList, ","); //Split the content into array
    		result.addAll(Arrays.asList(container));
    	}
		return result;
	}
	
	public static ModelMap retrieveBoardCategoryLevelAsHashMap(int level, String source)
	{
		ModelMap model=new ModelMap();
		//retrieve product type list
    	String boardCategoryLevelList=KeywordXmlHelper.retrieveBoardCategoryLevelContent(level,source);
    	String[] container=null;
    	HashMap<String, String> containerHM=new HashMap<String, String>();
    	if(boardCategoryLevelList!=null)
    	{
    		 //Get content of the node
    		container=StringUtils.split(boardCategoryLevelList, ","); //Split the content into array
    		//Convert string array to hashmap
    		for(String item:container)
    			containerHM.put(item, "true");
    	}
    	model.addAttribute("boardCategoryLevel"+level+"HM", containerHM);
		return model;
	}
	
	public static List<String> retrieveBoardCategoryLevelAslist(int level, String source)
	{
		//retrieve product type list
    	String boardCategoryLevelList=KeywordXmlHelper.retrieveBoardCategoryLevelContent(level,source);
    	String[] container=null;
    	List<String> result = new ArrayList<String>();
    	if(boardCategoryLevelList!=null)
    	{
    		 //Get content of the node
    		container=StringUtils.split(boardCategoryLevelList, ","); //Split the content into array
    		result.addAll(Arrays.asList(container));
    	}
		return result;
	}
	
	public static String retrieveProductTypeContent(String source)
	{
		String result=null;
		try
		{
			/*DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
        	DocumentBuilder b = f.newDocumentBuilder();
        	InputSource is = new InputSource(new StringReader(source));
        	Document doc = b.parse(is);*/
        	org.jsoup.nodes.Document doc = Jsoup.parse(source);
        	//check the keywords is xml
        	Elements root=doc.getElementsByTag("kw");
        	if(root.size()>0)
        	{
        		//retrieve product type list
	        	Elements productTypeNode=doc.getElementsByTag("ptl"); //Retrieve product type node from XML
	        	if(productTypeNode.size()>0)
	        	{
	        		result=productTypeNode.text(); //Get content of the node
	        	}
        	}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
	
	public static String retrieveBoardCategoryLevelContent(int level, String source)
	{
		String result=null;
		try
		{
        	org.jsoup.nodes.Document doc = Jsoup.parse(source);
        	//check the keywords is xml structure
        	Elements root=doc.getElementsByTag("kw");
        	if(root.size()>0)
        	{
        		//retrieve Board Category list by level
	        	Elements boardCategoryLevelNode=doc.getElementsByTag("bcl"+level); //Retrieve product type node from XML
	        	if(boardCategoryLevelNode.size()>0)
	        	{
	        		result=boardCategoryLevelNode.text(); //Get content of the node
	        	}
        	}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
	
	public static String setupKeywords(String subKeyword1,String subKeyword2,String subKeyword3,String subKeyword4, String level1, String level2, String[] level3, String[] level4)
	{
		//prepare keywords from subKeywords in xml format
		String subKeywords_1="<skw1></skw1>";
		String subKeywords_2="<skw2></skw2>";
		String subKeywords_3="<skw3></skw3>";
		String subKeywords_4="<skw4></skw4>";
		if(subKeyword1!=null)
			subKeywords_1="<skw1>"+StringEscapeUtils.escapeXml(subKeyword1)+"</skw1>";
		if(subKeyword2!=null)
			subKeywords_2="<skw2>"+StringEscapeUtils.escapeXml(subKeyword2)+"</skw2>";
		if(subKeyword3!=null)
			subKeywords_3="<skw3>"+StringEscapeUtils.escapeXml(subKeyword3)+"</skw3>";
		if(subKeyword4!=null)
			subKeywords_4="<skw4>"+StringEscapeUtils.escapeXml(subKeyword4)+"</skw4>";
		//
		String divisionList="<bcl1>"+level1+"</bcl1>"; //Insert 1st level to keywords fields
		String categoryList="<bcl2>"+level2+"</bcl2>"; //Insert 2nd level to keywords fields
		String productList="<bcl3></bcl3>"; //Insert 3rd level to keywords fields
		if(level3!=null)
			productList="<bcl3>"+StringUtils.join(level3, ",")+"</bcl3>";
		String productTypeList="<ptl></ptl>"; //Insert 4th level to keywords fields
		if(level4!=null)
			productTypeList="<ptl>"+StringUtils.join(level4, ",")+"</ptl>";
		String keywords="<kw>"+subKeywords_1+subKeywords_2+subKeywords_3+subKeywords_4+productTypeList+productList+categoryList+divisionList+"</kw>";
		return keywords;
	}
}
