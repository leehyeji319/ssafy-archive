package com.ssafy.sample.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.sample.model.dto.PageInfo;
import com.ssafy.sample.model.dto.Product;
import com.ssafy.sample.model.service.ProductService;

public class ProductController implements Controller {

	private ProductService productService = new ProductService();
	
	@Override
	public Object handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = request.getServletPath();
		
		if (url.equals("/product/register.do")) {
			return insertProduct(request, response);
		} else if (url.equals("/product/list.do")) {
			return getProductList(request, response);
		} else if (url.equals("/product/detail.do")) {
			return getProduct(request, response);
		} else if (url.equals("/product/delete.do")) {
			return removeProduct(request, response);
		}
		
		return null;
	}
	
	protected PageInfo insertProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String code = request.getParameter("code");
		String model = request.getParameter("model");
		int price = Integer.parseInt(request.getParameter("price"));
		
		System.out.println(code);
		System.out.println(model);
		System.out.println(price);
		
		boolean res = productService.insertProduct(new Product(code, model, price));
		
		if (res) {
			return new PageInfo(false, "/product/list.do");
		} else {
			request.setAttribute("errorMsg", "상품 등록에 실패하였습니다.");
			return new PageInfo(true, "/product/register.jsp");
		}
	}
	
	protected PageInfo getProductList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<Product> productList = productService.getProductList();
		request.setAttribute("productList", productList);
		return new PageInfo(true, "/product/list.jsp");
		
	}
	
	protected PageInfo getProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String code = request.getParameter("code");
		
		Product product = productService.getProduct(code);
		
		request.setAttribute("product", product);
		return new PageInfo(true, "/product/detail.jsp");
	}
	
	protected PageInfo removeProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String code = request.getParameter("code");
		
		productService.removeProduct(code);
		return new PageInfo(false, "/product/list.do");
	}
	

}
