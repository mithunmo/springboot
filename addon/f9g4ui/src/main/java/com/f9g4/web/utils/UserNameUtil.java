package com.f9g4.web.utils;

import com.f9g4.businessobjects.domain.AdUsersDomain;
import com.f9g4.businessobjects.domain.TrMessagesDomain;
import com.f9g4.businessobjects.services.DesignWallBoardInfoDomain;
import com.f9g4.businessobjects.services.TrActivityDomain;
import com.f9g4.common.util.ActiveStatusEnum;
import com.f9g4.common.util.LookupTypeValueEnum;
import com.f9g4.web.forms.ActivityGrid;
import com.f9g4.web.forms.MessageEntity;

public class UserNameUtil {

	public static String getDesignerName(AdUsersDomain user)
	{
		String name = user.getFirstname()+" "+user.getLastname();
		if(user.getUseProfilename()==ActiveStatusEnum.ACTIVE.value())
		{
			name=user.getProfilename();
		}
		return name;
	}
	
	public static String getDesignerName(DesignWallBoardInfoDomain user)
	{
		String name = user.getFirstname()+" "+user.getLastname();
		if(user.getUseProfilename()==ActiveStatusEnum.ACTIVE.value())
		{
			name=user.getProfilename();
		}
		return name;
	}
	
	public static void getDesignerName(ActivityGrid target, TrActivityDomain source)
	{
		String name = source.getDesignerName();
		if(source.getUseProfilename()==ActiveStatusEnum.ACTIVE.value())
		{
			name=source.getProfilename();
		}
		target.setDesignerName(name);
	}
	
	public static void getDesignerName(MessageEntity target, TrMessagesDomain source)
	{
		if(source.getFromUserType().getLookupCode().equals(LookupTypeValueEnum.USER_TYPE_DESIGNER.getTypeCode()))
		{
			if(source.getFromUserUseProfilename()==ActiveStatusEnum.ACTIVE.value())
			{
				target.setFromFinalName(source.getFromUserProfilename());
			}
		}
		
		if(source.getToUserType().getLookupCode().equals(LookupTypeValueEnum.USER_TYPE_DESIGNER.getTypeCode()))
		{
			if(source.getToUserUseProfilename()==ActiveStatusEnum.ACTIVE.value())
			{
				target.setToFinalName(source.getToUserProfilename());
			}
		}
	}
}
