package com.itwillbs.myweb;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 * 
 * @Controller => �ּҸ����� jsp �̵�, java�޼��� ȣ�� ó��
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * 
	 *  @RequestMapping => �����ּҿ��� �ּ� �ڵ����� �̾ƿ���
	 *  ���۹�� method = RequestMethod.GET  GET������� ��û�� ������
	 *  => �̾ƿ� �ּ� value = "/" ����
	 *  => �ּ� ���ؼ� ��ġ�ϸ� �޼��� ����
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
//		logger.info("Welcome home! The client locale is {}.", locale);
		
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
//		String formattedDate = dateFormat.format(date);
		
		// �޼��忡�� Model model ������ ��ü ������ model �����͸� ��Ƽ�
		// model �����͸� ���(�۸��, ������ ���� => request�� ����)
//		model.addAttribute("serverTime", formattedDate );
		// ${serverTime} => model�� ��ư� ������ �̸� => ���(�� ���) 
		
		// �����ּ� http://localhost:8080/myweb/
		// �ּҺ��� ���� �̵�
		// RequestDispatcher dis
		// = request.getRequestiDispatcher(forward.getPath());
		// dis.forward(request, response);
		
		// ȭ�鿡 ���̴� ���� /WEB-INF/views/�����̸�.jsp
		// �⺻ �̵���� : �ּҺ��� ���� �̵�
//		return "home";
		return "redirect:/member/main";
//		return "redirect:/member/insert";
//		return "redirect:/member/login";
	} // home �޼���
	
}
