/**
 * 
 */
package com.ibm.vicky.login.service.filter;

import org.springframework.stereotype.Component;

import com.ibm.vicky.login.service.model.UserRequest;

@Component
public class OrderFeignFallback  implements OrderFeignProxy {

		
		@Override
		public String saveOrder(String orderDetails, String authToken, String transToken, String userName) {
			return "No order detail available";
		}

		@Override
		public String saveOrderData(UserRequest user) {
			return "No order detail available";
		}

}



