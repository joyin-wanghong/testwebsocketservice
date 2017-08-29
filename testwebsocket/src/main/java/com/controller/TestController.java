package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entity.SocketClient;
import testwebsocket.MyWebSocket;

@Controller
@RequestMapping(value = "/test")
public class TestController {

	@RequestMapping(value = "/service")
	public void add(HttpServletRequest request, HttpServletResponse response) {
		CopyOnWriteArraySet<MyWebSocket> ss = MyWebSocket.getWebSocketSet();
		
		// 群发消息
		for (MyWebSocket item : ss) {
			//发送消息
			try {
				item.sendMessage("发送给客户端的消息：sssss");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			System.out.println(item.getSession().getId());
		}
	}
	
	/**
	 * 展示列表
	 *@param requeset
	 *@param response
	 *@return 
	 *@author 汪宏
	 *@date 2017年8月16日 下午4:12:50 
	 *@comment
	 */
	@RequestMapping(value="/listArray")
	public ModelAndView listArray(HttpServletRequest requeset,HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("listarray");
		List<MyWebSocket> clist = new ArrayList<MyWebSocket>();
		CopyOnWriteArraySet<MyWebSocket> cset = MyWebSocket.getWebSocketSet();
		
		for(MyWebSocket item:cset) {
			item.getSession().getId();
			clist.add(item);
		}
		
		mv.addObject("listArray",clist);
		return mv;
	}

	@RequestMapping(value = "/servicetest")
	public void list(HttpServletRequest request, HttpServletResponse response) {

	}

}
