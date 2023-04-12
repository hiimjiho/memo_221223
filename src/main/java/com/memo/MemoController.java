package com.memo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/memo")
public class MemoController {
	
	@RequestMapping("/sign_in")
	public String loginView() {
		return "test/memoLogin";
	}
}
