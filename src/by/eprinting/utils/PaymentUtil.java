package by.eprinting.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.stripe.Stripe;
import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.model.Charge;

import by.eprinting.beans.Order;
import by.eprinting.beans.Payment;
import by.eprinting.services.db.OrderDBService;

public class PaymentUtil {
	private static final long CENTS = 100;
	
	public static Payment createPayment(String token, String orderId, String totalPrice) {
		Stripe.apiKey = "";
		
		Charge charge = null;
		Payment payment = null;
		
		Order order = OrderDBService.findOrderById(Long.valueOf(orderId));
		long amountInCents = (long) (CENTS * Double.valueOf(totalPrice));
		
		Map<String, Object> chargeParams = new HashMap<String, Object>();
		chargeParams.put("amount", amountInCents);
		chargeParams.put("currency", "usd");
		chargeParams.put("receipt_email", order.getEmail());
		chargeParams.put("source", token); // obtained with Stripe.js
		chargeParams.put("description", "Charge for test@eprinting.com");

		try {
			charge = Charge.create(chargeParams);
			
			payment = new Payment();
			payment.setOrder(order);
			payment.setAmountInCents(amountInCents);
			payment.setToken(token);
			payment.setChargeId(charge.getId());
			payment.setStatus(charge.getStatus());
			payment.setPaid(charge.getPaid());
			payment.setDate(new Date().getTime());
			
		} catch (AuthenticationException | InvalidRequestException | APIConnectionException | CardException
				| APIException e) {
			e.printStackTrace();
		}
		
		return payment;
	}

}
