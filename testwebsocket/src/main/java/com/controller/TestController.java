package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/test")
public class TestController {

	@RequestMapping(value = "/service")
	public void add(HttpServletRequest request, HttpServletResponse response) {

	}

	@RequestMapping(value = "/servicetest")
	public void list(HttpServletRequest request, HttpServletResponse response) {

	}

}
