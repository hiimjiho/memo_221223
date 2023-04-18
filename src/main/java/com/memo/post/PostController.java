package com.memo.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.memo.post.bo.PostBO;
import com.memo.post.model.Post;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/post")
@Controller
public class PostController {
	@Autowired
	private PostBO postBO;
	
	@GetMapping("/post_list_view")
	public String postLietView(Model model, HttpSession session) {

		Integer userId = (Integer) session.getAttribute("userId"); // (null이거나 아니거나 이기 때문에 Integer로 해줘야한다
		if (userId == null) {
			// 비로그인이면 로그인 페이지로 이동.
			return "redirect:/user/sign_in_view";
		}
		List<Post> postList = postBO.PostList();
		model.addAttribute("postList", postList);
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
	
	@GetMapping("/post_detail_view")
	public String postDetailView(
			@RequestParam("postId") int postId,
			HttpSession session,
			Model model) {
		
		// db select by postId, (userId)
		int userId = (int)session.getAttribute("userId");
		Post post = postBO.getPostBypostIdUserId(postId, userId);
		
		
		model.addAttribute("post", post);
		model.addAttribute("view", "post/postDetail");
		return "template/layout";
	}
}
