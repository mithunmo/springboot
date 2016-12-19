package com.f9g4.web.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.f9g4.businessobjects.domain.AdAddressDomain;
import com.f9g4.businessobjects.domain.AdUsersDomain;
import com.f9g4.common.util.LookupTypeValueEnum;

public class UserProfileChecker {
	
	private Integer score;
	private List<String> toDoList;
	
	public UserProfileChecker()
	{
		score=0;
		toDoList = new ArrayList<String>();
	}
	
	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	//get spring message codes
	public List<String> getToDoList() {
		return toDoList;
	}

	public void setToDoList(List<String> toDoList) {
		this.toDoList = toDoList;
	}
	
	public List<String> getFullToDoList() {
		List<String> list = new ArrayList<String>();
		list.add("profile.progress.todo.languages"); //profile.progress.todo.languages
		list.add("profile.progress.todo.skills"); //profile.progress.todo.skills
		list.add("profile.progress.todo.aboutyou"); //profile.progress.todo.aboutyou
		list.add("profile.progress.todo.address.incompleted"); //profile.progress.todo.address.incompleted
		list.add("profile.progress.todo.schools_awards"); //profile.progress.todo.schools_awards
		list.add("profile.progress.todo.contacts.mobile"); //profile.progress.todo.contacts.mobile
		list.add("profile.progress.todo.profile_photo"); //profile.progress.contacts
		return list;
	}

	//retrun score and toDoList will have steps that user has to complete.
	public boolean getProfileProgressInfo(AdUsersDomain user)
	{
		try
		{
			Integer score = 40; //base score is 40 for now
			// check languages
			if(user.getUserLangs()!=null && user.getUserLangs().size()>0)
				score += 10;
			else
				toDoList.add("profile.progress.todo.languages"); //profile.progress.todo.languages
			// check skills 
			if(user.getUseSkills()!=null && user.getUseSkills().size()>0)
				score += 10;
			else
				toDoList.add("profile.progress.todo.skills"); //profile.progress.todo.skills
			// check about you
			if(!StringUtils.isBlank(user.getAboutYou()))
				score += 10;
			else
				toDoList.add("profile.progress.todo.aboutyou"); //profile.progress.todo.aboutyou
			// check address
			if(user.getAddress()!=null && user.getAddress().size()>0)
			{
				//make sure all required fields.
				AdAddressDomain address = user.getAddress().get(0);
				if(!StringUtils.isBlank(address.getAddressLine1())
					&& !StringUtils.isBlank(address.getCity())
					&& (!StringUtils.isBlank(address.getState()) || address.getCountryId()!=LookupTypeValueEnum.COUNTRY_US.getTypeId())
					&& !StringUtils.isBlank(address.getPostalcode())
					&& address.getCountryId()!=0 )
					score += 10;
				else
					toDoList.add("profile.progress.todo.address.incompleted"); //profile.progress.todo.address.incompleted
			}
			else
				toDoList.add("profile.progress.todo.address.required"); //profile.progress.todo.address.required
			// check schools...
			if(!StringUtils.isBlank(user.getSchoolawards()))
				score += 10;
			else
				toDoList.add("profile.progress.todo.schools_awards"); //profile.progress.todo.schools_awards
			// check contact information
			if(user.getContacts()!=null && user.getContacts().size()>0)
			{
				if(!StringUtils.isBlank(user.getContacts().get(0).getCellphone()))
					score += 10;
				else
					toDoList.add("profile.progress.todo.contacts.mobile"); //profile.progress.todo.contacts.mobile
			}
			else
				toDoList.add("profile.progress.todo.contacts"); //profile.progress.todo.contacts
			
			//check profile photo but do not include in score policy
			if(StringUtils.isBlank(user.getLogoimageurl()) || user.getLogoimageurl().equals("/images/avatar_default.jpg"))
				toDoList.add("profile.progress.todo.profile_photo"); //profile.progress.contacts
			
			this.score = score;
		}
		catch(Exception e)
		{
			this.score = 0;
			return false;
		}
		return true;
	}
}
