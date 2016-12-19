package com.f9g4.webapp.controllers;

import java.awt.TrayIcon.MessageType;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.f9g4.businessobjects.domain.AdLookupValuesDomain;
import com.f9g4.businessobjects.domain.AdUsersDomain;
import com.f9g4.businessobjects.domain.TrBoardDomain;
import com.f9g4.businessobjects.domain.TrMessagesDomain;
import com.f9g4.businessobjects.domain.TrRatingsDomain;
import com.f9g4.businessobjects.services.AddRatingRequest;
import com.f9g4.businessobjects.services.AddRatingResponse;
import com.f9g4.businessobjects.services.DeleteMessageByIdResponse;
import com.f9g4.businessobjects.services.GetBoardByIdResponse;
import com.f9g4.businessobjects.services.GetBoardRatingsResponse;
import com.f9g4.businessobjects.services.GetLookupTypeValuesForTypeResponse;
import com.f9g4.businessobjects.services.GetMessageByIdResponse;
import com.f9g4.businessobjects.services.ViewUserResponse;
import com.f9g4.common.errors.StatusCodesEnum;
import com.f9g4.common.util.LookupTypeEnum;
import com.f9g4.common.util.LookupTypeValueEnum;
import com.f9g4.common.util.MessageTypes;
import com.f9g4.servicesdk.BoardServiceSDK;
import com.f9g4.servicesdk.MessageServiceSDK;
import com.f9g4.servicesdk.RatingServiceSDK;
import com.f9g4.servicesdk.RegistrationServiceSDK;
import com.f9g4.web.forms.RatingForm;
import com.f9g4.web.utils.ErrorsCodeEnum;
import com.f9g4.web.utils.ViewNames;
import com.f9g4.web.utils.ViewPaths;

@Controller
@SessionAttributes({"user"})
public class RatingController 
{
	private static final Logger logger = LoggerFactory.getLogger(RatingController.class);
	
	@Autowired
	BoardServiceSDK boardServiceSDK=new BoardServiceSDK();
	
	@Autowired
	RatingServiceSDK ratingServiceSDK=new RatingServiceSDK();
	
	@Autowired
	RegistrationServiceSDK registrationServiceSDK = new RegistrationServiceSDK();
	
	@Autowired
	MessageServiceSDK messageServiceSDK = new MessageServiceSDK();
	
	@RequestMapping(value=ViewPaths.RATING+"/{boardId}/{messageId}",method=RequestMethod.GET)
	public String showRating(@ModelAttribute(value="user") AdUsersDomain adUser,@PathVariable(value="boardId") int boardId,@PathVariable(value="messageId") int messageId, ModelMap model)
	{
		model.addAttribute("ratingForm", new RatingForm());
		//get the board detail
		GetBoardByIdResponse boardResponse=boardServiceSDK.getBoardbyId(boardId);

		//check the board is existed or not
		if(boardResponse.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()))
		{
			TrBoardDomain boardDomain=boardResponse.getBoard();
			//check the board status, it should be under SOLD or READY
			if(boardDomain.getStatusId()==LookupTypeValueEnum.BOARD_SALE_STATUS_SOLD.getTypeId() || boardDomain.getStatusId()==LookupTypeValueEnum.BOARD_SALE_STATUS_READY.getTypeId())
			{
				//check the user is the designer or the company or not of each
				if(boardDomain.getCurrentUerId()==adUser.getUserId() || boardDomain.getOriginalUserId()==adUser.getUserId()) //company or designer
				{
					GetBoardRatingsResponse boardRatingsResponse = ratingServiceSDK.getRatingforBoardbyUser(adUser.getUserId(), boardId);
					if(boardRatingsResponse.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()))
					{
						//already have the record in the database. Disallow user to do the rating again.
						model.addAttribute("hasError", true);
						model.addAttribute("error", ErrorsCodeEnum.RATING_EXISTED);
					}
					else
					{
						model.addAttribute("hasError", false);
						//Put board detail
						model.addAttribute("board", boardDomain);
						model.addAttribute("boardImage", boardDomain.getBoardImages().get(0).getThumbnailUrl());
						//put messageId
						model.addAttribute("messageId", messageId);
						//select greeting message
						if(adUser.getUserType().equals(LookupTypeValueEnum.USER_TYPE_CUSTOMER.getTypeCode()))
							model.addAttribute("greetingMessageCode", "console.tab.rating.greeting.company");
						else
							model.addAttribute("greetingMessageCode", "console.tab.rating.greeting.designer");
						//get rating user detail
						ViewUserResponse ratingUserResponse;
						AdUsersDomain ratingUser;
						if(adUser.getUserId()!=boardDomain.getCurrentUerId())
						{
							ratingUserResponse=registrationServiceSDK.viewUser(boardDomain.getCurrentUerId());
							ratingUser=ratingUserResponse.getUser();
							model.addAttribute("ratingUser", ratingUser);
						}
						else
						{
							ratingUserResponse=registrationServiceSDK.viewUser(boardDomain.getOriginalUserId());
							ratingUser=ratingUserResponse.getUser();
							model.addAttribute("ratingUser", ratingUser);
						}
						
						if(ratingUser.getUserType().equals(LookupTypeValueEnum.USER_TYPE_CUSTOMER.getTypeCode()))
						{
							model.addAttribute("question1Type",LookupTypeValueEnum.RATING_QUALITY_OF_COMMUNICATION.getTypeCode());
							model.addAttribute("question2Type",LookupTypeValueEnum.RATING_DENPENDABILITY.getTypeCode());
							model.addAttribute("question3Type",LookupTypeValueEnum.RATING_EXPECTATIONS_FROM_YOU.getTypeCode());
							model.addAttribute("question4Type",LookupTypeValueEnum.RATING_PAYMENT_TERMS.getTypeCode());
						}
						else
						{
							model.addAttribute("question1Type",LookupTypeValueEnum.RATING_QUALITY_OF_WORK.getTypeCode());
							model.addAttribute("question2Type",LookupTypeValueEnum.RATING_PRICING.getTypeCode());
							model.addAttribute("question3Type",LookupTypeValueEnum.RATING_RELIABILITY.getTypeCode());
							model.addAttribute("question4Type",LookupTypeValueEnum.RATING_CUSTOMIZATION.getTypeCode());
						}
						//model.addAttribute("purchasedDate", boardDomain.getSalesTransactionDetails().get(0).getSellerPayDate());
						//set the question id and description
						GetLookupTypeValuesForTypeResponse rate1 = registrationServiceSDK.getLookupTypeValues(LookupTypeEnum.RATING_QUESTION1.getTypeName());
						GetLookupTypeValuesForTypeResponse rate2 = registrationServiceSDK.getLookupTypeValues(LookupTypeEnum.RATING_QUESTION2.getTypeName());
						GetLookupTypeValuesForTypeResponse rate3 = registrationServiceSDK.getLookupTypeValues(LookupTypeEnum.RATING_QUESTION3.getTypeName());
						GetLookupTypeValuesForTypeResponse rate4 = registrationServiceSDK.getLookupTypeValues(LookupTypeEnum.RATING_QUESTION4.getTypeName());
						List<AdLookupValuesDomain> rate1Set = rate1.getLookupTypeValues();
						List<AdLookupValuesDomain> rate2Set = rate2.getLookupTypeValues();
						List<AdLookupValuesDomain> rate3Set = rate3.getLookupTypeValues();
						List<AdLookupValuesDomain> rate4Set = rate4.getLookupTypeValues();
						model.addAttribute("rate1", rate1Set);
						model.addAttribute("rate2", rate2Set);
						model.addAttribute("rate3", rate3Set);
						model.addAttribute("rate4", rate4Set);
					}
				}
				else // not the designer or company
				{
					model.addAttribute("hasError", true);
					model.addAttribute("error", ErrorsCodeEnum.USER_NOT_RELATED);
				}
			}
			else
			{
				model.addAttribute("hasError", true);
				model.addAttribute("error", ErrorsCodeEnum.BOARD_AVAILABLE);
			}
		}
		else
		{
			model.addAttribute("hasError", true);
			model.addAttribute("error", ErrorsCodeEnum.BOARD_NOT_EXISTED);
		}
		//Check the user is designer or company
		return ViewNames.RATING;
	}
	
	@RequestMapping(value=ViewPaths.RATING,method=RequestMethod.POST)
	public @ResponseBody ModelMap submitRating(@ModelAttribute(value="user") AdUsersDomain adUser, RatingForm formbean,ModelMap model)
	{
		ModelMap map = new ModelMap();
		//Check the record existence
		GetBoardRatingsResponse boardRatingsResponse = ratingServiceSDK.getRatingforBoardbyUser(adUser.getUserId(), formbean.getBoardId());
		if(boardRatingsResponse.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()))
		{
			//already have the record in the database. Disallow user to do the rating again.
			map.addAttribute("hasError", true);
			map.addAttribute("error", ErrorsCodeEnum.RATING_EXISTED.getDefaultMessage());
		}
		else
		{
			AddRatingRequest request=new AddRatingRequest();
			TrRatingsDomain ratingsDomain=new TrRatingsDomain();
			request.setBoardrating(ratingsDomain);
			ratingsDomain.setBoardId(formbean.getBoardId());
			ratingsDomain.setUserId(adUser.getUserId());
			ratingsDomain.setRatingUserId(formbean.getRatingUserId());
			if(formbean.getComment()!=null)
				ratingsDomain.setComment(formbean.getComment());
			else
				ratingsDomain.setComment("");
			ratingsDomain.setRateTransactionId(458); //TODO what is the purpose of this ID?
			//set rating detail
			if(formbean.getRate_1()==null)
				ratingsDomain.setAvarageRating(0);
			else
				ratingsDomain.setAvarageRating(formbean.getRate_1());
			
			ratingsDomain.setRatingQuestion1Id(formbean.getRate_1_questionId());
			if(formbean.getRate_1_1_p()==null)
				ratingsDomain.setRating1(0);
			else
				ratingsDomain.setRating1(formbean.getRate_1_1_p());
			
			ratingsDomain.setRatingQuestion2Id(formbean.getRate_2_questionId());
			if(formbean.getRate_1_1_q()==null)
				ratingsDomain.setRating2(0);
			else
				ratingsDomain.setRating2(formbean.getRate_1_1_q());
			
			ratingsDomain.setRatingQuestion3Id(formbean.getRate_3_questionId());
			if(formbean.getRate_1_1_r()==null)
				ratingsDomain.setRating3(0);
			else
				ratingsDomain.setRating3(formbean.getRate_1_1_r());
			
			ratingsDomain.setRatingQuestion4Id(formbean.getRate_4_questionId());
			if(formbean.getRate_1_1_c()==null)
				ratingsDomain.setRating4(0);
			else
				ratingsDomain.setRating4(formbean.getRate_1_1_c());
			
			GetMessageByIdResponse messageResponse = messageServiceSDK.getMessageById(formbean.getMessageId());
			TrMessagesDomain messageDomain = messageResponse.getMessage();
			if(messageDomain.getToUserId() == adUser.getUserId() && messageDomain.getMessageType().equals(MessageTypes.ALERT) && messageDomain.getBoardId() == formbean.getBoardId())
			{
				AddRatingResponse response = ratingServiceSDK.addRating(request);
				if(response.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()))
				{
					//delete the alert message
					//check the message is related to this board, user, and the message type is alert
					try
					{
						DeleteMessageByIdResponse deleteMessageResponse = messageServiceSDK.deleteMessageById(formbean.getMessageId());
						if(deleteMessageResponse.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()))
						{
							map.addAttribute("hasError", false);
						}
						else
						{
							map.addAttribute("hasError", true);
							map.addAttribute("error", ErrorsCodeEnum.RATING_DELETE_ALERT_ERROR.getDefaultMessage());
						}
					}
					catch(Exception e)
					{
						logger.error(e.toString());
					}
				}
				else
				{
					map.addAttribute("hasError", true);
					map.addAttribute("error", ErrorsCodeEnum.RATING_SUBMIT_FAILED.getDefaultMessage());
				}
			}
			else
			{
				map.addAttribute("hasError", true);
				map.addAttribute("error", ErrorsCodeEnum.RATING_UNRELATED_MESSAGE.getDefaultMessage());
			}
		}
		return map;
	}
}
