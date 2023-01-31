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
 * @Controller => 주소매핑을 jsp 이동, java메서드 호출 처리
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * 
	 *  @RequestMapping => 가상주소에서 주소 자동으로 뽑아오기
	 *  전송방식 method = RequestMethod.GET  GET방식으로 요청이 들어오고
	 *  => 뽑아온 주소 value = "/" 비교함
	 *  => 주소 비교해서 일치하면 메서드 동작
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
//		logger.info("Welcome home! The client locale is {}.", locale);
		
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
//		String formattedDate = dateFormat.format(date);
		
		// 메서드에서 Model model 변수에 객체 생성한 model 데이터를 담아서
		// model 데이터를 담기(글목록, 페이지 정보 => request에 저장)
//		model.addAttribute("serverTime", formattedDate );
		// ${serverTime} => model에 담아간 데이터 이름 => 출력(값 출력) 
		
		// 가상주소 http://localhost:8080/myweb/
		// 주소변경 없이 이동
		// RequestDispatcher dis
		// = request.getRequestiDispatcher(forward.getPath());
		// dis.forward(request, response);
		
		// 화면에 보이는 내용 /WEB-INF/views/파일이름.jsp
		// 기본 이동방식 : 주소변경 없이 이동
//		return "home";
		return "redirect:/member/main";
//		return "redirect:/member/insert";
//		return "redirect:/member/login";
	} // home 메서드
	
}
