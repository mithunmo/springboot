package com.f9g4.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.f9g4.businessobjects.common.Status;
import com.f9g4.businessobjects.domain.TrPaymentAuthSubmitDomain;
import com.f9g4.businessobjects.domain.TrPaymentAuthSubmitHeaderDomain;
import com.f9g4.businessobjects.domain.TrSalesTransactionDetailsDomain;
import com.f9g4.businessobjects.domain.TrSalesTransactionHeaderDomain;
import com.f9g4.businessobjects.services.CreatePaymentAuthSubmitHeaderRequest;
import com.f9g4.businessobjects.services.CreatePaymentAuthSubmitHeaderResponse;
import com.f9g4.businessobjects.services.CreatePaymentAuthSubmitRequest;
import com.f9g4.businessobjects.services.CreatePaymentAuthSubmitResponse;
import com.f9g4.businessobjects.services.CreateSalesTransactionRequest;
import com.f9g4.businessobjects.services.CreateSalesTransactionResponse;
import com.f9g4.businessobjects.services.CreateTrSalesTransactionRequest;
import com.f9g4.businessobjects.services.CreateTrSalesTransactionResponse;
import com.f9g4.businessobjects.services.GetGrossbyTransactionIdRequest;
import com.f9g4.businessobjects.services.GetGrossbyTransactionIdResponse;
import com.f9g4.businessobjects.services.GetPaymentInfoResponse;
import com.f9g4.businessobjects.services.GetReceiverEmail;
import com.f9g4.businessobjects.services.GetReceiverEmailVerificationRequest;
import com.f9g4.businessobjects.services.GetReceiverEmailVerificationResponse;
import com.f9g4.businessobjects.services.GetTrSalesTransactionHeaderExistsRequest;
import com.f9g4.businessobjects.services.GetTrSalesTransactionHeaderExistsResponse;
import com.f9g4.businessobjects.services.OrderItem;
import com.f9g4.businessobjects.services.SetupPaymentRequest;
import com.f9g4.businessobjects.services.SetupPaymentResponse;
import com.f9g4.common.errors.StatusCodesEnum;
import com.f9g4.common.util.Constants;
import com.f9g4.common.util.LookupTypeValueEnum;
import com.f9g4.common.util.PaypalConstants;
import com.f9g4.dao.AdLookupValuesDAO;
import com.f9g4.dao.AdUsersDAO;
import com.f9g4.dao.TrBoardDAO;
import com.f9g4.dao.TrPaymentAuthSubmitDAO;
import com.f9g4.dao.TrPaymentAuthSubmitHeaderDAO;
import com.f9g4.dao.TrSalesTransactionDetailsDAO;
import com.f9g4.dao.TrSalesTransactionHeaderDAO;
import com.f9g4.domain.AdLookupValues;
import com.f9g4.domain.AdUsers;
import com.f9g4.domain.TrBoard;
import com.f9g4.domain.TrPaymentAuthSubmit;
import com.f9g4.domain.TrPaymentAuthSubmitHeader;
import com.f9g4.domain.TrSalesTransactionDetails;
import com.f9g4.domain.TrSalesTransactionHeader;
import com.f9g4.services.rest.IPaypalPaymentService;
import com.f9g4.services.rest.ISalesTransactionService;

@Service("salesTransactionService")
@Transactional(propagation=Propagation.REQUIRED, rollbackFor=RuntimeException.class)
public class SalesTransactionServiceImpl implements ISalesTransactionService{

	private static final Logger logger = LoggerFactory.getLogger(SalesTransactionServiceImpl.class);
	
	@Autowired
	private AdUsersDAO adUsersDAO;
	
	@Autowired
	private AdLookupValuesDAO adLookupValuesDAO;
	
	@Autowired
	private TrPaymentAuthSubmitHeaderDAO trPaymentAuthSubmitHeaderDAO;

	@Autowired
	private TrPaymentAuthSubmitDAO trPaymentAuthSubmitDAO;

	@Autowired
	private TrSalesTransactionHeaderDAO trSalesTransactionHeaderDAO;

	@Autowired
	private TrSalesTransactionDetailsDAO trSalesTransactionDetailsDAO;

	@Autowired
	private TrBoardDAO trBoardDAO;
	
	@Autowired
    @Qualifier(value="paypalAdaptivePayService")
	private IPaypalPaymentService paypalPaymentService;
	
	public CreateSalesTransactionResponse createSalesTransaction(CreateSalesTransactionRequest request) {
		
		CreateSalesTransactionResponse response = new CreateSalesTransactionResponse();
		Status status = new Status();
		status.setStatuscode(StatusCodesEnum.STATUS_SUCCESS.getCode());
		Calendar today = Calendar.getInstance();
		
		try {
			
			TrSalesTransactionHeaderDomain trSalesTransactionHeaderDomain = request.getSalesTransactionHeaderDomain();
			TrSalesTransactionHeader trSalesTransactionHeaderEntity = new TrSalesTransactionHeader();
			String paymentErrorMsg = "";
			AdLookupValues adLookupValuesStatusId = null;
			AdLookupValues adLookupValuesPaymentStatus = null;
			AdLookupValues adLookupValuesDesingerPaymentStatus = adLookupValuesDAO.findAdLookupValuesByLookupCodeSingleResult(LookupTypeValueEnum.MEM_PAYMENT_STATUS_PROCESSING.getTypeCode());;
			GetPaymentInfoResponse getPayResponse = paypalPaymentService.getPaymentInfo(trSalesTransactionHeaderDomain.getSecureToken());

			if(PaypalConstants.COMMAND_RETURN.equals(request.getPayActoin())){
				if(StatusCodesEnum.STATUS_SUCCESS.getCode().equals(getPayResponse.getStatus().getStatuscode())){
					if(PaypalConstants.STATUS_COMPLETED.equals(getPayResponse.getPayStatus())){
						adLookupValuesPaymentStatus = adLookupValuesDAO.findAdLookupValuesByLookupCodeSingleResult(LookupTypeValueEnum.MEM_PAYMENT_STATUS_PAID.getTypeCode());
						adLookupValuesStatusId = adLookupValuesDAO.findAdLookupValuesByLookupCodeSingleResult(LookupTypeValueEnum.BOARD_SALE_STATUS_SOLD.getTypeCode());
					}else if(PaypalConstants.STATUS_PROCESSING.equals(getPayResponse.getPayStatus()) || PaypalConstants.STATUS_PENDING.equals(getPayResponse.getPayStatus())){
						adLookupValuesPaymentStatus = adLookupValuesDAO.findAdLookupValuesByLookupCodeSingleResult(LookupTypeValueEnum.MEM_PAYMENT_STATUS_PAYMENT_PENDING.getTypeCode());
						adLookupValuesStatusId = adLookupValuesDAO.findAdLookupValuesByLookupCodeSingleResult(LookupTypeValueEnum.BOARD_SALE_STATUS_PAYMENT_PENDING.getTypeCode());
					}else{
						adLookupValuesPaymentStatus = adLookupValuesDAO.findAdLookupValuesByLookupCodeSingleResult(LookupTypeValueEnum.MEM_PAYMENT_STATUS_REJECTED.getTypeCode());
						adLookupValuesStatusId = adLookupValuesDAO.findAdLookupValuesByLookupCodeSingleResult(LookupTypeValueEnum.BOARD_SALE_STATUS_AVAILABLE.getTypeCode());
					}					
				}else{
					//Paypal transactions is errored..
					paymentErrorMsg = getPayResponse.getStatus().getDescription();
					adLookupValuesPaymentStatus = adLookupValuesDAO.findAdLookupValuesByLookupCodeSingleResult(LookupTypeValueEnum.MEM_PAYMENT_STATUS_REJECTED.getTypeCode());
					adLookupValuesStatusId = adLookupValuesDAO.findAdLookupValuesByLookupCodeSingleResult(LookupTypeValueEnum.BOARD_SALE_STATUS_AVAILABLE.getTypeCode());					
				}
			}else{
				//cancelled transaction..
				paymentErrorMsg = "Canceled Paypal transcatiion";
				adLookupValuesPaymentStatus = adLookupValuesDAO.findAdLookupValuesByLookupCodeSingleResult(LookupTypeValueEnum.MEM_PAYMENT_STATUS_REJECTED.getTypeCode());
				adLookupValuesStatusId = adLookupValuesDAO.findAdLookupValuesByLookupCodeSingleResult(LookupTypeValueEnum.BOARD_SALE_STATUS_AVAILABLE.getTypeCode());					
			}
			
			if(!StatusCodesEnum.STATUS_SUCCESS.getCode().equals(getPayResponse.getStatus().getStatuscode())){
			TrPaymentAuthSubmitHeader trPaymentAuthSubmitHeader = trPaymentAuthSubmitHeaderDAO.findTrPaymentAuthSubmitHeaderBySecureToken(trSalesTransactionHeaderDomain.getSecureToken());
			trSalesTransactionHeaderEntity.setCreatedBy(trSalesTransactionHeaderDomain.getCreatedby());
			trSalesTransactionHeaderEntity.setCreationDate(today);
			trSalesTransactionHeaderEntity.setLastUpdateDate(today);
			trSalesTransactionHeaderEntity.setLastUpdatedBy(trSalesTransactionHeaderDomain.getLastupdateby());
			trSalesTransactionHeaderEntity.setPaymentAuthCode(trSalesTransactionHeaderDomain.getSecureToken());
			trSalesTransactionHeaderEntity.setSecureToken(trSalesTransactionHeaderDomain.getSecureToken());
			trSalesTransactionHeaderEntity.setAdLookupValuesByPaymentStatusId(adLookupValuesPaymentStatus);
			trSalesTransactionHeaderEntity.setTrPaymentAuthSubmitHeader(trPaymentAuthSubmitHeader);
			trSalesTransactionHeaderEntity.setPaymentErrorMsg(paymentErrorMsg);
			TrSalesTransactionHeader trSalesTransactionHeaderProxy = trSalesTransactionHeaderDAO.merge(trSalesTransactionHeaderEntity);

			List<TrSalesTransactionDetailsDomain> trSalesTransactionDetailsDomainsList = trSalesTransactionHeaderDomain.getSalesTransactionsDetails();
			for(TrSalesTransactionDetailsDomain trSalesTransactionDetailsDomain : trSalesTransactionDetailsDomainsList){
				TrSalesTransactionDetails trSalesTransactionDetailsEnitty = new TrSalesTransactionDetails();
				AdUsers adUsers = adUsersDAO.findAdUsersByPrimaryKey(trSalesTransactionDetailsDomain.getUserId());
				TrBoard trBoard = trBoardDAO.findTrBoardByPrimaryKey(trSalesTransactionDetailsDomain.getBoardId());
				
				//commission...
				BigDecimal commission = trBoard.getTotalPrice().subtract(trBoard.getBoardPrice());
				
				trSalesTransactionDetailsEnitty.setAdUsers(adUsers);
				trSalesTransactionDetailsEnitty.setCommission(commission);
				trSalesTransactionDetailsEnitty.setCreatedBy(trSalesTransactionDetailsDomain.getCreatedby());
				trSalesTransactionDetailsEnitty.setCreationDate(today);
				trSalesTransactionDetailsEnitty.setLastUpdateDate(today);
				trSalesTransactionDetailsEnitty.setLastUpdatedBy(trSalesTransactionDetailsDomain.getLastupdateby());
				trSalesTransactionDetailsEnitty.setDesignerPaymentStatusId(adLookupValuesDesingerPaymentStatus); 
				trSalesTransactionDetailsEnitty.setSellerShare(trBoard.getBoardPrice());
				trSalesTransactionDetailsEnitty.setTrBoard(trBoard);
				trSalesTransactionDetailsEnitty.setTrSalesTransactionHeader(trSalesTransactionHeaderProxy);
				trSalesTransactionDetailsDAO.merge(trSalesTransactionDetailsEnitty);
				if(LookupTypeValueEnum.MEM_PAYMENT_STATUS_PAID.getTypeCode().equals(adLookupValuesPaymentStatus.getLookupCode())){
					trBoard.setPublishToMp(Constants.PUBLISH_TO_MARKET_NO);
					trBoard.setAdUsersByCurrentUserId(adUsers);						
				}
				trBoard.setAdLookupValuesStatusId(adLookupValuesStatusId);
				trBoardDAO.merge(trBoard);
			}
			}
		}catch(Throwable th){
			logger.error("Exception Occurred", th);
			status.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
			status.setDescription("Error occured");
		}		
		return response;
	}
	
	public CreatePaymentAuthSubmitResponse createPaymentAuthSubmit(CreatePaymentAuthSubmitRequest request) {
		
		CreatePaymentAuthSubmitResponse response = new CreatePaymentAuthSubmitResponse();
		Status status = new Status();
		status.setStatuscode(StatusCodesEnum.STATUS_SUCCESS.getCode());
		Calendar today = Calendar.getInstance();
		response.setStatus(status);
		
		try {			
			//Request
			List<TrPaymentAuthSubmitDomain> trPaymentAuthSubmitDomainList = request.getPaymentAuthSubmit();
			
			SetupPaymentRequest setupPayrequest = new SetupPaymentRequest();
			List<OrderItem> orderItemsList = setupPayrequest.getOrderItem();
			BigDecimal orderTotal = new BigDecimal(0.0);
			for(TrPaymentAuthSubmitDomain trAuthSubmitDomain : trPaymentAuthSubmitDomainList){
				OrderItem item = new OrderItem();
				item.setPrice(trAuthSubmitDomain.getPrice().setScale(2, RoundingMode.UNNECESSARY));
				orderTotal.add(trAuthSubmitDomain.getPrice());
				//item.setQuantity(1); 
				orderItemsList.add(item);				
			}
			setupPayrequest.setCancelUrl(request.getCancelUrl());
			setupPayrequest.setReturnUrl(request.getReturnUrl());
			setupPayrequest.setIpnUrl(request.getIpnUrl());
			//setup a payment request with Paypal..
			SetupPaymentResponse setupPayResponse = paypalPaymentService.setupPayment(setupPayrequest);
			if(StatusCodesEnum.STATUS_SUCCESS.getCode().equals(setupPayResponse.getStatus().getStatuscode())){
				
				TrPaymentAuthSubmitHeaderDomain headerDomain = request.getPaymentAuthSubmitHeader();

				AdLookupValues adLookupValuesStatusId = adLookupValuesDAO.findAdLookupValuesByLookupCodeSingleResult(LookupTypeValueEnum.BOARD_SALE_STATUS_PROCESSING.getTypeCode());
				AdUsers adUser = adUsersDAO.findAdUsersByPrimaryKey(headerDomain.getUserId());
				
				//prepare Auth Submit.
				TrPaymentAuthSubmitHeader headerEnitty = new TrPaymentAuthSubmitHeader();
				//trPaymentAuthSubmitHeaderEntity.setBatchTrxId(batchTrxId); NEW record 
				headerEnitty.setCreatedBy(headerDomain.getCreatedby());
				headerEnitty.setCreationDate(today);
				headerEnitty.setLastUpdateDate(today);
				headerEnitty.setLastUpdatedBy(headerDomain.getLastupdateby());
				headerEnitty.setShipping(new BigDecimal(0));//For now pass zero, would have to handle in Phase 2
				headerEnitty.setTax(new BigDecimal(0));//For now pass zero, would have to handle in Phase 2
				headerEnitty.setSubtotal(headerDomain.getTotal());
				headerEnitty.setTotal(headerDomain.getTotal());
				headerEnitty.setSecureToken(setupPayResponse.getPaymentToken());
				headerEnitty.setAdUsers(adUser);
				
				response.setPaymentToken(setupPayResponse.getPaymentToken());
				//
				TrPaymentAuthSubmitHeader newHeaderEnitty = trPaymentAuthSubmitHeaderDAO.merge(headerEnitty);
				for(TrPaymentAuthSubmitDomain trAuthSubmitDomain : trPaymentAuthSubmitDomainList){
					TrBoard trBoard = trBoardDAO.findTrBoardByPrimaryKey(trAuthSubmitDomain.getBoardId());
					TrPaymentAuthSubmit trPaymentAuthSubmitEntity = new TrPaymentAuthSubmit();
					trPaymentAuthSubmitEntity.setAdUsers(adUser);
					//trPaymentAuthSubmitEntity.setAuthSubmitId(authSubmitId); PK new record 
					trPaymentAuthSubmitEntity.setCreatedBy(trAuthSubmitDomain.getCreatedby());
					trPaymentAuthSubmitEntity.setCreationDate(today);
					trPaymentAuthSubmitEntity.setLastUpdateDate(today);
					trPaymentAuthSubmitEntity.setLastUpdatedBy(trAuthSubmitDomain.getLastupdateby());
					//trPaymentAuthSubmitEntity.setPrice(orderTotal); //should be the board price with company commission.
					trPaymentAuthSubmitEntity.setPrice(trAuthSubmitDomain.getPrice()); //total_price + company commission
					trPaymentAuthSubmitEntity.setSecureToken(setupPayResponse.getPaymentToken());
					trPaymentAuthSubmitEntity.setTrBoard(trBoard);
					trPaymentAuthSubmitEntity.setTrPaymentAuthSubmitHeader(newHeaderEnitty);
					trBoard.setAdLookupValuesStatusId(adLookupValuesStatusId);
					trBoard.setLastUpdatedBy(adUser.getUserId());
					trBoardDAO.merge(trBoard);
					trPaymentAuthSubmitDAO.merge(trPaymentAuthSubmitEntity);
				}				
			}else{
				status.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode()); //TODO add error codes...
				status.setDescription("Error occured");				
			}
		}catch(Throwable th){
			logger.error("Exception Occurred", th);
			status.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
			status.setDescription("Error occured");
		}
		return response;
	}
	
		//	This is a dead code not used anywhere have to remove this !!!
		public CreatePaymentAuthSubmitHeaderResponse createPaymentAuthSubmitHeader(CreatePaymentAuthSubmitHeaderRequest request) {
			CreatePaymentAuthSubmitHeaderResponse response = new CreatePaymentAuthSubmitHeaderResponse();
			Status status = new Status();
			status.setStatuscode(StatusCodesEnum.STATUS_SUCCESS.getCode());
			Calendar today = Calendar.getInstance();
			try {	
				TrPaymentAuthSubmitHeaderDomain trAuthSubmitHeaderDomain = request.getPaymentAuthSubmitHeader();
				TrPaymentAuthSubmitHeader trPaymentAuthSubmitHeaderEntity = new TrPaymentAuthSubmitHeader();
//				trPaymentAuthSubmitHeaderEntity.setBatchTrxId(batchTrxId); NEW record 
				trPaymentAuthSubmitHeaderEntity.setCreatedBy(trAuthSubmitHeaderDomain.getCreatedby());
				trPaymentAuthSubmitHeaderEntity.setCreationDate(today);
				trPaymentAuthSubmitHeaderEntity.setLastUpdateDate(today);
				trPaymentAuthSubmitHeaderEntity.setLastUpdatedBy(trAuthSubmitHeaderDomain.getLastupdateby());
				trPaymentAuthSubmitHeaderEntity.setShipping(trAuthSubmitHeaderDomain.getShipping());
				trPaymentAuthSubmitHeaderEntity.setSubtotal(trAuthSubmitHeaderDomain.getSubtotal());
				trPaymentAuthSubmitHeaderEntity.setTax(trAuthSubmitHeaderDomain.getTax());
				trPaymentAuthSubmitHeaderEntity.setTotal(trAuthSubmitHeaderDomain.getTotal());
				trPaymentAuthSubmitHeaderEntity.setSecureToken(trAuthSubmitHeaderDomain.getSecureToken());
				trPaymentAuthSubmitHeaderDAO.merge(trPaymentAuthSubmitHeaderEntity);
			}catch(Throwable th){
				logger.error("Exception Occurred", th);
				status.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
				status.setDescription("Error occured");
			}
			return response;	
		}

		public GetGrossbyTransactionIdResponse getGrossbyTransactionId(
				GetGrossbyTransactionIdRequest request) {
			TrPaymentAuthSubmitHeader header = trPaymentAuthSubmitHeaderDAO.findTrPaymentAuthSubmitHeaderBySecureToken(request.getTransactionId());
			GetGrossbyTransactionIdResponse response = new GetGrossbyTransactionIdResponse();
			response.setPrice(header.getTotal());
			return response;
		}

		public GetTrSalesTransactionHeaderExistsResponse getTrSalesTransactionHeaderExists(
				GetTrSalesTransactionHeaderExistsRequest request) {
			GetTrSalesTransactionHeaderExistsResponse response = new GetTrSalesTransactionHeaderExistsResponse();
			Set<TrSalesTransactionHeader> header = trSalesTransactionHeaderDAO.findTrSalesTransactionHeaderByPaymentAuthCode(request.getTransactionId());
			
			if(header.size()>0)
				response.setTrSalesTransactionHeaderExists(true);
			else
				response.setTrSalesTransactionHeaderExists(false);
			
			return response;
		}

		public GetReceiverEmailVerificationResponse GetReceiverEmailVerification(
				GetReceiverEmailVerificationRequest request) {
			GetReceiverEmailVerificationResponse response = new GetReceiverEmailVerificationResponse();
			response.setIsReceiverEmailVerified(false);
			GetReceiverEmail ourReceiverEmail = paypalPaymentService.getReceiverEmail();
			if(request.getReceiverEmail().equals(ourReceiverEmail.getReceiverEmail()))
				response.setIsReceiverEmailVerified(true);
			return response;
		}

		public CreateTrSalesTransactionResponse CreateTrSalesTransaction(
				CreateTrSalesTransactionRequest request) {
			
			Status status = new Status();		
			CreateTrSalesTransactionResponse response = new CreateTrSalesTransactionResponse(status);	
			status.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
			try{
				String payKey = request.getPayKey();
				TrPaymentAuthSubmitHeader header = trPaymentAuthSubmitHeaderDAO.findTrPaymentAuthSubmitHeaderBySecureToken(payKey);
				TrSalesTransactionHeader saleHeader = CreateTrSalesTransactionHeaderFromTrPaymentAuthSubmitHeader(header);
				Set<TrPaymentAuthSubmit> details = trPaymentAuthSubmitDAO.findTrPaymentAuthSubmitBySecureToken(payKey);
				CreateTrSalesTrnsactionDetailsFromTrPaymentAuthSubmit(header,details,saleHeader);
				status.setStatuscode(StatusCodesEnum.STATUS_SUCCESS.getCode());
			}catch(Exception ex){
				status.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
			}
			return response;
		}

		private void CreateTrSalesTrnsactionDetailsFromTrPaymentAuthSubmit(
				TrPaymentAuthSubmitHeader header,
				Set<TrPaymentAuthSubmit> details, TrSalesTransactionHeader saleHeader) {
				for (TrPaymentAuthSubmit trPaymentAuthSubmit : details) {
					TrSalesTransactionDetails salesDetail = new TrSalesTransactionDetails();
					AdUsers user = trPaymentAuthSubmit.getAdUsers();
					salesDetail.setAdUsers(user);
					TrBoard board = trBoardDAO.findTrBoardByBoardId(trPaymentAuthSubmit.getTrBoard().getBoardId());//trPaymentAuthSubmit.getTrBoard();
					//BigDecimal commission = board.getTotalPrice().subtract(board.getBoardPrice());
					BigDecimal commission = trPaymentAuthSubmit.getPrice().subtract(board.getBoardPrice()); //sale price - board price = commission
					salesDetail.setCommission(commission.setScale(2));
					salesDetail.setSellerShare(board.getBoardPrice());
					board.setAdUsersByCurrentUserId(user);
					board.setAdLookupValuesStatusId(GetAdLookUpValues(LookupTypeValueEnum.BOARD_SALE_STATUS_SOLD.getTypeCode()));
					board.setPublishToMp(Constants.PUBLISH_TO_MARKET_NO);
					//TODO do we need to change the last updated by to system user?
					//board.setLastUpdatedBy(2); //Change to system user
					TrBoard newboard = trBoardDAO.merge(board);
					salesDetail.setTrBoard(newboard);
					Calendar today = Calendar.getInstance();
					salesDetail.setCreatedBy(user.getUserId());
					salesDetail.setCreationDate(today);
					salesDetail.setLastUpdatedBy(user.getUserId());
					salesDetail.setLastUpdateDate(today);
					salesDetail.setTrSalesTransactionHeader(saleHeader);
					salesDetail.setDesignerPaymentStatusId(GetAdLookUpValues(LookupTypeValueEnum.MEM_PAYMENT_STATUS_PROCESSING.getTypeCode()));
					trSalesTransactionDetailsDAO.merge(salesDetail);
				}
				trBoardDAO.flush();
				trSalesTransactionDetailsDAO.flush();
		}

		private TrSalesTransactionHeader CreateTrSalesTransactionHeaderFromTrPaymentAuthSubmitHeader(
				TrPaymentAuthSubmitHeader header) {
		
			Calendar today = Calendar.getInstance();
			TrSalesTransactionHeader salesHeader = new TrSalesTransactionHeader();
			salesHeader.setCreatedBy(header.getCreatedBy());
			salesHeader.setCreationDate(today);
			salesHeader.setLastUpdateDate(today);
			salesHeader.setLastUpdatedBy(header.getLastUpdatedBy());
			//could be replaced with transaction Id
			salesHeader.setPaymentAuthCode(header.getSecureToken());
			salesHeader.setSecureToken(header.getSecureToken());
			salesHeader.setTrPaymentAuthSubmitHeader(header);
			salesHeader.setAdLookupValuesByPaymentStatusId(GetAdLookUpValues(LookupTypeValueEnum.MEM_PAYMENT_STATUS_PAID.getTypeCode()));
			return trSalesTransactionHeaderDAO.merge(salesHeader);
			
		}

		private AdLookupValues GetAdLookUpValues(String typeCode) {
			return adLookupValuesDAO.findAdLookupValuesByLookupCodeSingleResult(typeCode);
		}
		
		
}