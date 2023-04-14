package com.memo.post;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/post")
@Controller
public class PostController {
	@GetMapping("/post_list_view")
	public String postLietView(Model model, HttpSession session) {

		Integer userId = (Integer) session.getAttribute("userId"); // (null이거나 아니거나 이기 때문에 Integer로 해줘야한다
		if (userId == null) {
			// 비로그인이면 로그인 페이지로 이동.
			return "redirect:/user/sign_in_view";
		}

		model.addAttribute("view", "post/postList");
		return "template/layout";
	}
	
	/**
	 * * 글쓰기 화면
	 * @param model
	 * @return
	 */
	@GetMapping("/post_create_view")
	public String postCreateView(Model model) {
		model.addAttribute("view", "post/postCreate");
		return "template/layout";
	}
}
