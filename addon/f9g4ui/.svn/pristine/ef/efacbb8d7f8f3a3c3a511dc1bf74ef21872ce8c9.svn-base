package com.f9g4.webapp.controllers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.f9g4.businessobjects.domain.AdLookupValuesDomain;
import com.f9g4.businessobjects.domain.AdUsersDomain;
import com.f9g4.businessobjects.domain.TrBoardDomain;
import com.f9g4.businessobjects.domain.TrPaymentAuthSubmitDomain;
import com.f9g4.businessobjects.domain.TrPaymentAuthSubmitHeaderDomain;
import com.f9g4.businessobjects.domain.TrSalesTransactionDetailsDomain;
import com.f9g4.businessobjects.domain.TrSalesTransactionHeaderDomain;
import com.f9g4.businessobjects.services.BoardSet;
import com.f9g4.businessobjects.services.CreatePaymentAuthSubmitRequest;
import com.f9g4.businessobjects.services.CreatePaymentAuthSubmitResponse;
import com.f9g4.businessobjects.services.CreateSalesTransactionRequest;
import com.f9g4.businessobjects.services.CreateSalesTransactionResponse;
import com.f9g4.businessobjects.services.GetBoardByIdResponse;
import com.f9g4.businessobjects.services.GetMembershipCommissionRequest;
import com.f9g4.businessobjects.services.GetMembershipCommissionResponse;
import com.f9g4.businessobjects.services.UpdateBoardStatusRequest;
import com.f9g4.businessobjects.services.ValidateBoardsRequest;
import com.f9g4.businessobjects.services.ValidateBoardsResponse;
import com.f9g4.common.errors.StatusCodesEnum;
import com.f9g4.common.util.LookupTypeEnum;
import com.f9g4.common.util.LookupTypeValueEnum;
import com.f9g4.common.util.PaypalConstants;
import com.f9g4.servicesdk.BoardServiceSDK;
import com.f9g4.servicesdk.MembershipServiceSDK;
import com.f9g4.servicesdk.RegistrationServiceSDK;
import com.f9g4.servicesdk.SalesTransactionServiceSDK;
import com.f9g4.web.forms.Cart;
import com.f9g4.web.forms.CartItem;
import com.f9g4.web.forms.DeleteCartItemsForm;
import com.f9g4.web.utils.ErrorsCodeEnum;
import com.f9g4.web.utils.ViewNames;
import com.f9g4.web.utils.ViewPaths;

@Controller
@SessionAttributes(value={"cart", "user", "payKey"})
public class CheckoutController 
{
	private static final Logger logger = LoggerFactory.getLogger(CheckoutController.class);
		
	@Autowired
	private SalesTransactionServiceSDK salesTransactionServiceSDK; 
	
	@Autowired
	private BoardServiceSDK boardServiceSDK;
	
	@Autowired
	RegistrationServiceSDK registrationServiceSDK=new RegistrationServiceSDK();
	
	@Autowired
	MembershipServiceSDK membershipServiceSDK;
	
	@Autowired @Value("${return_url}")
	private String returnUrlProp;
	
	@Autowired @Value("${cancel_url}")
	private String cancelUrlProp;
	
	@Autowired @Value("${payment_listener_url}")
	private String paymentListenerUrl;
	
	@Autowired @Value("${paypal_single_transaction_limit}")
	private String strpaypalSingleTransactionLimit;
	
	@Autowired @Value("${paypalredirecturl}")
	private String paypalredirecturl;
	
	private BigDecimal paypalSingleTransactionLimit;
	

	public BigDecimal getPaypalSingleTransactionLimit() {
		return new BigDecimal(strpaypalSingleTransactionLimit);
	}

	public void setPaypalSingleTransactionLimit(
			BigDecimal paypalSingleTransactionLimit) {
		this.paypalSingleTransactionLimit = paypalSingleTransactionLimit;
	}

	@ModelAttribute("saleTypeList")
	public List<AdLookupValuesDomain> getSaleTypeList() {
		return registrationServiceSDK.getLookupTypeValues(LookupTypeEnum.SALE_TYPE.getTypeName()).getLookupTypeValues();
	}

	@RequestMapping(value=ViewPaths.CHECKOUT, method=RequestMethod.GET)
	public String checkout(@ModelAttribute(value="cart") Cart cart,@ModelAttribute(value="user") AdUsersDomain user, ModelMap model)
	{
		ValidateBoardsRequest validateRequest = new ValidateBoardsRequest();
		List<BoardSet> board = validateRequest.getBoards();
		validateRequest.setUserId(user.getUserId());
		Collection<CartItem> cartitems = cart.getCart().values();
		for(CartItem cartitem : cartitems)
		{
			BoardSet set=new BoardSet();
			set.setBoardIds(cartitem.getBoardId());
			set.setLastUpdateDate(cartitem.getLastUpdateDate());
			board.add(set);
			cartitem.setHasAltered(false); //reset the hasAltered value
		}
		
		//check the boards are still available ? 		
		ValidateBoardsResponse validaetResponse = boardServiceSDK.validateBoards(validateRequest);
		if(null != validaetResponse.getInvalidBoardIds() && validaetResponse.getInvalidBoardIds().size() > 0){
			//TODO - remove items from cart and and dispaly message.
			List<Integer> invalidBoardIdList=validaetResponse.getInvalidBoardIds();
			model.addAttribute("existInvalidBoard",true);
			logger.trace("invalid BOARD=>"+invalidBoardIdList);
			ArrayList<CartItem> invalidBoardList=new ArrayList<CartItem>();
			for(Integer deleteId:invalidBoardIdList)
				invalidBoardList.add(cart.removeFromCart(deleteId));
			model.addAttribute("invalidBoardList",invalidBoardList);
		}
		//update the cart if there exists the items has altered after you add to the shopping cart
		List<Integer> inconsistentBoardList=validaetResponse.getInconsistentBoardIds();
		if(inconsistentBoardList.size()>0)
		{
			model.addAttribute("hasInconsistentItems", true);
			Map<Integer,CartItem> cartMap=cart.getCart(); //get cart items
			Set<Integer> keyset=cartMap.keySet(); //get the key set
			Iterator<Integer> iterator=keyset.iterator(); //get iterator
			while (iterator.hasNext()) 
			{  
				Integer i = (Integer)iterator.next();  
			    CartItem s = cartMap.get(i);
			    if(inconsistentBoardList.contains(s.getBoardId()))
			    {
			    	s.setHasAltered(true);
			    	//resync the boards
	            	GetBoardByIdResponse boardResponse=boardServiceSDK.getBoardbyId(s.getBoardId());
	            	TrBoardDomain b = boardResponse.getBoard();
	            	s.setBoardName(b.getName());
	            	//s.setBoardprice(b.getTotalPrice());
	            	//Compute the SALE_PRICE with company commission
	        		GetMembershipCommissionRequest getCommissionRequest = new GetMembershipCommissionRequest();
	        		getCommissionRequest.setUserId(user.getUserId());
	        		GetMembershipCommissionResponse getCommissionResponse =  membershipServiceSDK.getMembershipCommissiondetails(getCommissionRequest);
	        		BigDecimal commission = getCommissionResponse.getStPricingOptions().getCommission();
	        		BigDecimal salePrice = boardResponse.getBoard().getTotalPrice().multiply(commission.add(new BigDecimal(100))).divide(new BigDecimal(100));
	        		s.setBoardprice(salePrice.setScale(2));
	            	s.setFileType(b.getSaleTypeId());
	            	s.setImageUrl(b.getBoardImages().get(0).getThumbnailUrl());
	            	s.setLastUpdateDate(b.getLastUpdateDate());
			    }
			    else
			      	s.setHasAltered(false);
			}
		}
		else
			model.addAttribute("hasInconsistentItems", false);
		
		//check total amount. If the amount exceeds 10000, then reject the transaction.
		if(cart.recountTotal().compareTo(this.getPaypalSingleTransactionLimit())==1)
		{
			model.addAttribute("hasError", true);
			model.addAttribute("errorCode", ErrorsCodeEnum.SINGLE_TRANSACTION_LIMIT.getCode());
			model.addAttribute("errorId", ErrorsCodeEnum.SINGLE_TRANSACTION_LIMIT.getErrorId());
			model.addAttribute("errorDescription", "Over 10000 limit per single transaction.");
		}
				  
		model.addAttribute("deleteCartItemsForm", new DeleteCartItemsForm());
		//model.addAttribute("cartItems", cartitems);
		model=getCartDetail(cart,model);
		//model.addAttribute("total", cart.getTotalPrice());
		
		logger.trace("CHECKOUT TOTAL=>"+cart.getTotalPrice());
		return ViewNames.CHECKOUT;
	}
	
	@RequestMapping(value=ViewPaths.CHECKOUT,method=RequestMethod.POST)
	public ModelAndView processCheckout(@ModelAttribute(value="cart") Cart cart, @ModelAttribute(value="user") AdUsersDomain user, HttpServletRequest httpRequest, ModelMap model) {
		
		ModelAndView view;
		ValidateBoardsRequest validateRequest = new ValidateBoardsRequest();

		List<BoardSet> boards = validateRequest.getBoards();
		validateRequest.setUserId(user.getUserId());
		Collection<CartItem> cartitems = cart.getCart().values();
		for(CartItem cartitem : cartitems){
			BoardSet set=new BoardSet();
			set.setBoardIds(cartitem.getBoardId());
			set.setLastUpdateDate(cartitem.getLastUpdateDate());
			boards.add(set);
		}
		
		String payKey ="";
		//check the boards are still available and the consistency with the shopping cart item 		
		ValidateBoardsResponse validaetResponse = boardServiceSDK.validateBoards(validateRequest);
		
		if((null == validaetResponse.getInvalidBoardIds() || validaetResponse.getInvalidBoardIds().size() == 0) && ( null == validaetResponse.getInconsistentBoardIds() || validaetResponse.getInconsistentBoardIds().size()==0)){
			
//			String url = "http://" + httpRequest.getServerName() + ":" + 
//						httpRequest.getServerPort() + httpRequest.getContextPath();//TODO more research on getServerPort
			String url = "http://" + httpRequest.getServerName() + httpRequest.getContextPath();//TODO - convert into https
			String cancelUrl = cancelUrlProp;//url + ViewPaths.PAYPAL_CANCEL; 
			String returnUrl = returnUrlProp;// url + ViewPaths.PAYPAL_RETURN;
			String ipnUrl = paymentListenerUrl; //url + ViewPaths.PAYMENT_LISTENER;
			//create AuthSubmit
			CreatePaymentAuthSubmitRequest authSubmitRequest = new CreatePaymentAuthSubmitRequest();
			
			//set data			
			authSubmitRequest.setReturnUrl(returnUrl);
			authSubmitRequest.setCancelUrl(cancelUrl);
			authSubmitRequest.setIpnUrl(ipnUrl);
			
			List<TrPaymentAuthSubmitDomain> trPaymentAuthSubmitDomainList = authSubmitRequest.getPaymentAuthSubmit();
			
			BigDecimal orderTotal = new BigDecimal("0.0");			
			for(CartItem cartitem : cartitems){
				TrPaymentAuthSubmitDomain authSubmit = new TrPaymentAuthSubmitDomain();
				authSubmit.setBoardId(cartitem.getBoardId());
				authSubmit.setLastupdateby(user.getUserId());
				authSubmit.setCreatedby(user.getUserId());
				authSubmit.setPrice(cartitem.getBoardprice());
				authSubmit.setUserId(user.getUserId());
				trPaymentAuthSubmitDomainList.add(authSubmit);
				orderTotal = orderTotal.add(cartitem.getBoardprice());
			}
	
			//TODO check total amount. If the amount exceeds 10000, then reject the transaction.
			if(orderTotal.compareTo(this.getPaypalSingleTransactionLimit())==1)
			{
				RedirectView rv=new RedirectView(ViewPaths.CONSOLE_CHECKOUT_TAB+"/"+ErrorsCodeEnum.SINGLE_TRANSACTION_LIMIT.getErrorId(),true,true,false);
				view = new ModelAndView(rv);
				return view;
			}
			//prepare header...
			TrPaymentAuthSubmitHeaderDomain authSubmitHeader = new TrPaymentAuthSubmitHeaderDomain();
			authSubmitHeader.setUserId(user.getUserId());
			authSubmitHeader.setCreatedby(user.getUserId());
			authSubmitHeader.setLastupdateby(user.getUserId());
//			authSubmitHeader.setSecureToken(); -- don't need to pass here would be created in service..
			authSubmitHeader.setTotal(orderTotal);
			authSubmitRequest.setPaymentAuthSubmitHeader(authSubmitHeader);			
			CreatePaymentAuthSubmitResponse authResponse = salesTransactionServiceSDK.createPaymentAuthSubmit(authSubmitRequest);
			if(StatusCodesEnum.STATUS_SUCCESS.getCode().equals(authResponse.getStatus().getStatuscode())){
				payKey =  authResponse.getPaymentToken();
				httpRequest.getSession().setAttribute("payKey", payKey);
//				session.setAttribute("payKey", payKey);
			}
			view = new ModelAndView("redirect:" + paypalredirecturl + "&paykey=" + payKey);
		}else{
			//TODO - remove items from cart and and dispaly message.
			/*List<Integer> invalidBoardIdList=validaetResponse.getInvalidBoardIds();
			model.addAttribute("existInvalidBoard",true);
			logger.trace("invalid BOARD=>"+invalidBoardIdList);
			ArrayList<CartItem> invalidBoardList=new ArrayList<CartItem>();
			for(Integer deleteId:invalidBoardIdList)
				invalidBoardList.add(cart.removeFromCart(deleteId));
			model.addAttribute("invalidBoardList",invalidBoardList);*/
			//if there exists invalid baord, redirect the user to the checkout tab.
			RedirectView rv=new RedirectView(ViewPaths.CONSOLE_CHECKOUT_TAB,true,true,false);
			view = new ModelAndView(rv);
		}
		//view = new ModelAndView("redirect:" + ViewPaths.PAYPAL_SANDBOX_AP_URL + "&paykey=" + payKey);
		return  view;
	}
	

	@RequestMapping(value=ViewPaths.PAYPAL_RETURN, method=RequestMethod.GET)
	public ModelAndView paymentReturn(@ModelAttribute(value="cart") Cart cart, @ModelAttribute(value="user") AdUsersDomain user, HttpSession session) {		
	
		/*String payKey = null;
		if((payKey = getPayKey(session)) != null){
			//create Sale
			TrSalesTransactionHeaderDomain trSalesTransactionHeaderDomain = new TrSalesTransactionHeaderDomain();
			trSalesTransactionHeaderDomain.setCreatedby(user.getUserId());
			trSalesTransactionHeaderDomain.setLastupdateby(user.getUserId());
			trSalesTransactionHeaderDomain.setSecureToken(payKey);
			trSalesTransactionHeaderDomain.setUserId(user.getUserId());
		
			CreateSalesTransactionRequest request = new CreateSalesTransactionRequest();
			request.setSalesTransactionHeaderDomain(trSalesTransactionHeaderDomain);
			request.setPayActoin(PaypalConstants.COMMAND_RETURN);
			
			List<TrSalesTransactionDetailsDomain> trSalesTransactionDetailsDomainsList = trSalesTransactionHeaderDomain.getSalesTransactionsDetails();
			Collection<CartItem> cartItems = cart.getCart().values();
			for(CartItem cartItem :  cartItems){
				TrSalesTransactionDetailsDomain trSalesDetailsdomain = new TrSalesTransactionDetailsDomain();
				trSalesDetailsdomain.setBoardId(cartItem.getBoardId());
				trSalesDetailsdomain.setCreatedby(user.getUserId());
				trSalesDetailsdomain.setLastupdateby(user.getUserId());
				trSalesDetailsdomain.setUserId(user.getUserId());
				trSalesTransactionDetailsDomainsList.add(trSalesDetailsdomain);
			}
			CreateSalesTransactionResponse response = salesTransactionServiceSDK.createSalesTransaction(request);
		}*/
		cart.clearCart();
		ModelAndView view = new ModelAndView("redirect:" + ViewPaths.CONSOLE_HOME);
		return view;
	}
	
	private synchronized String getPayKey(HttpSession httpSession){
		String payKey = null;
		payKey = (String) httpSession.getAttribute("payKey");
		httpSession.removeAttribute("payKey");
		return payKey;
	}
	
	@RequestMapping(value=ViewPaths.PAYPAL_CANCEL,method=RequestMethod.GET)
	public ModelAndView paymentCancel(@ModelAttribute(value="cart") Cart cart, @ModelAttribute(value="user") AdUsersDomain user, @ModelAttribute(value="payKey") String payKey,ModelMap map){
		UpdateBoardStatusRequest boardrequest = new UpdateBoardStatusRequest();
		List<TrBoardDomain> trBoardDomains =  boardrequest.getBoards();
		for(CartItem cartitem : cart.getCart().values()){
			TrBoardDomain trBoardDomain = new TrBoardDomain();
			trBoardDomain.setBoardId(cartitem.getBoardId());
			trBoardDomain.setStatusId(LookupTypeValueEnum.BOARD_SALE_STATUS_AVAILABLE.getTypeId());
			trBoardDomains.add(trBoardDomain);
		}
		boardServiceSDK.updateBoardStatus(boardrequest);
	
		//create Sale
		TrSalesTransactionHeaderDomain trSalesTransactionHeaderDomain = new TrSalesTransactionHeaderDomain();
		trSalesTransactionHeaderDomain.setCreatedby(user.getUserId());
		trSalesTransactionHeaderDomain.setLastupdateby(user.getUserId());
		trSalesTransactionHeaderDomain.setSecureToken(payKey);
		trSalesTransactionHeaderDomain.setUserId(user.getUserId());
		
	
		CreateSalesTransactionRequest request = new CreateSalesTransactionRequest();
		request.setSalesTransactionHeaderDomain(trSalesTransactionHeaderDomain);
		request.setPayActoin(PaypalConstants.COMMAND_CANCEL);
	
		
		List<TrSalesTransactionDetailsDomain> trSalesTransactionDetailsDomainsList = trSalesTransactionHeaderDomain.getSalesTransactionsDetails();
		Collection<CartItem> cartItems = cart.getCart().values();
		for(CartItem cartItem :  cartItems){
			TrSalesTransactionDetailsDomain trSalesDetailsdomain = new TrSalesTransactionDetailsDomain();
			trSalesDetailsdomain.setBoardId(cartItem.getBoardId());
			trSalesDetailsdomain.setCreatedby(user.getUserId());
			trSalesDetailsdomain.setLastupdateby(user.getUserId());
			trSalesDetailsdomain.setUserId(user.getUserId());
			trSalesTransactionDetailsDomainsList.add(trSalesDetailsdomain);
		}
		CreateSalesTransactionResponse response = salesTransactionServiceSDK.createSalesTransaction(request);
		cart.clearCart();

		return new ModelAndView("redirect:" +ViewPaths.CONSOLE_HOME);
	}
	@RequestMapping(value=ViewPaths.DELETE_CART_MULTIPLE, method=RequestMethod.POST)
	public @ResponseBody ModelMap deleteMultiCartItems(@ModelAttribute(value="deleteCartItemsForm") DeleteCartItemsForm formBean, @ModelAttribute(value="cart") Cart cart)
	{
		
		logger.trace("DELETE FORM BEAN=>"+formBean.toString());
		//delete cart item
		if(formBean.getSelect_item()!=null){
			for(Integer id:formBean.getSelect_item()){
				cart.removeFromCart(id);
			}
		}
		ModelMap map = new ModelMap();
		map=getCartDetail(cart, map);
		map.addAttribute("hasError", false);
		return map;
	}
	
	private ModelMap getCartDetail(Cart cart,ModelMap model)
	{
		ArrayList<CartItem> cartitems=new ArrayList<CartItem>();
		ArrayList<Integer> boardIdList=new ArrayList<Integer>();
		
		Map<Integer,CartItem> cartMap=cart.getCart(); //get cart items
		Set<Integer> keyset=cartMap.keySet(); //get the key set
		Iterator<Integer> iterator=keyset.iterator(); //get iterator
		
		while (iterator.hasNext()) 
		{  
            Integer i = (Integer)iterator.next();  
            CartItem s = cartMap.get(i);  
            cartitems.add(s);
            boardIdList.add(s.getBoardId());
        }  
		
		model.addAttribute("cartItems", cartitems); //array of shopping cart detail
		model.addAttribute("boardIdList", boardIdList); //array of boardId list of 
		model.put("count", cart.getNumberOfItems());
		model.put("total", cart.recountTotal());
		return model;
	}
}
