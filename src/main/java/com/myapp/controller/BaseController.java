package com.myapp.controller;

import com.myapp.cache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Locale;

@ImportResource("classpath:spring-db.xml")
//@DependsOn("dbPopulator")
public abstract class BaseController {
	//private Locale locale;
	public static List<Locale.Category> categoryList;

/*	@Autowired
	CacheManager cacheManager;*/
/*
	@Autowired
	CategoryService productTypeService;
	
	@PostConstruct
	public void init() {
		categoryList = productTypeService.getProductTypes();
	}*/
	
	public HttpSession getSession() {
	    ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
	    return attr.getRequest().getSession(true); // true == allow create
	}
	
	public Object getAttribute(String name, String defaultValue) {
		Object attribute = getSession().getAttribute(name);
		return (attribute != null) ? attribute : defaultValue ;  
	}
	
	
	public void setAttribute(String name, Object value) {
		getSession().setAttribute(name, value);
	}
/*
	public Order getOrder() {
		Order order = (Order) getSession().getAttribute("order");
		if (order == null) {
			order = new Order();
			getSession().setAttribute("order", order);
		}
		return order;
	}
	
	public Locale getLocale() {
		if (locale == null) {
			locale = new Locale("en", "us");
		}
		return locale;
	}

	public static List<ProductType> getCategoryList() {
		return categoryList;
	}*/
}
