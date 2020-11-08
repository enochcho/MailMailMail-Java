package com.m3.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.m3.model.Like;
import com.m3.model.LikeBuilt;
import com.m3.service.LikeService;

@Controller
@CrossOrigin
@RequestMapping
public class LikeController {

	private LikeService ls;
	
	public LikeService getLs() {
		return ls;
	}
	
	@Autowired
	public void setLs(LikeService ls) {
		this.ls = ls;
	}
	
	@GetMapping("/likeAll.app")
	public @ResponseBody List<LikeBuilt> getAll(){
		List<Like> likes = ls.getAllLikes();
		List<LikeBuilt> builtLikes = new LinkedList<>();
		for(Like l : likes) {
			builtLikes.add(new LikeBuilt(l));
		}
		return builtLikes;
	}
	
	@GetMapping("/likeAUser.app")
	public @ResponseBody List<LikeBuilt> getAllLikesByUser(@RequestParam Integer id){
		List<Like> likes = ls.getAllUserLikes(id);
		List<LikeBuilt> builtLikes = new LinkedList<>();
		for(Like l : likes) {
			builtLikes.add(new LikeBuilt(l));
		}
		return builtLikes;
	}
	
	@GetMapping("/likeAPost.app")
	public @ResponseBody List<LikeBuilt> getAllLikesByPost(@RequestParam Integer id){
		List<Like> likes = ls.getAllPostLikes(id);
		List<LikeBuilt> builtLikes = new LinkedList<>();
		for(Like l : likes) {
			builtLikes.add(new LikeBuilt(l));
		}
		return builtLikes;
	}
	
	@GetMapping("/likeAComment.app")
	public @ResponseBody List<LikeBuilt> getAllLikesByComment(@RequestParam Integer id){
		List<Like> likes = ls.getAllCommentLikes(id);
		List<LikeBuilt> builtLikes = new LinkedList<>();
		for(Like l : likes) {
			builtLikes.add(new LikeBuilt(l));
		}
		return builtLikes;
	}
	
	
}