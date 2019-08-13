package com.ssm.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.config.DefaultAlipayClientFactory;


@WebServlet("/test.do")
public class TestServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final String CHARSET="UTF-8";
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AlipayClient alipayClient = DefaultAlipayClientFactory.getAlipayClient();
		AlipayTradePagePayRequest aliRequest = new AlipayTradePagePayRequest();
		aliRequest.setReturnUrl("http://domain.com/CallBack/return_url.jsp");
		aliRequest.setNotifyUrl("http://domain.com/CallBack/notify_url.jsp");//在公共参数中设置回跳和通知地址
		aliRequest.setBizContent("{" +
	        "    \"out_trade_no\":\"20190101010101001\"," +
	        "    \"product_code\":\"FAST_INSTANT_TRADE_PAY\"," +
	        "    \"total_amount\":1," +
	        "    \"subject\":\"Iphone6 16G\"," +
	        "    \"body\":\"Iphone6 16G\"," +
	        "    \"passback_params\":\"merchantBizType%3d3C%26merchantBizNo%3d2016010101111\"," +
	        "    \"extend_params\":{" +
	        "    \"sys_service_provider_id\":\"2088511833207846\"" +
	        "    }"+
	        "  }");//填充业务参数
		String form = "";
		try {
			form = alipayClient.pageExecute(aliRequest).getBody(); // 调用SDK生成表单
			System.out.println(form);
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}
		System.out.println("沙盒结束。。");
		response.setContentType("text/html;charset=" + CHARSET);
	    response.getWriter().write(form);//直接将完整的表单html输出到页面
	    response.getWriter().flush();
	    response.getWriter().close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
