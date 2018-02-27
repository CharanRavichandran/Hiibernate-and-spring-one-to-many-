package net.codejava.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.codejava.spring.dao.BookDao;
import net.codejava.spring.dao.UserDAO;
import net.codejava.spring.model.Book;
import net.codejava.spring.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Bookcontroller {
	
	@Autowired
	private BookDao bookdao;

	@RequestMapping("/book")
	public ModelAndView handleRequest() throws Exception {
		List<Book> listUsers = bookdao.list();
		ModelAndView model = new ModelAndView("BookList");
		model.addObject("bookList", listUsers);
		return model;
	}
	
	@RequestMapping(value = "/new1", method = RequestMethod.GET)
	public ModelAndView newUser() {
		ModelAndView model = new ModelAndView("BookForm");
		model.addObject("book", new Book());
		return model;		
	}
	
	@RequestMapping(value = "/edit1", method = RequestMethod.GET)
	public ModelAndView editUser(HttpServletRequest request) {
		int userId = Integer.parseInt(request.getParameter("id"));
		Book book = bookdao.get(userId);
		ModelAndView model = new ModelAndView("BookForm");
		model.addObject("book", book);
		return model;		
	}
	
	@RequestMapping(value = "/delete1", method = RequestMethod.GET)
	public ModelAndView deleteUser(HttpServletRequest request) {
		int bookId = Integer.parseInt(request.getParameter("id"));
		bookdao.delete(bookId);
		return new ModelAndView("redirect:/");		
	}
	
	@RequestMapping(value = "/save1", method = RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute Book book) {
		bookdao.saveOrUpdate(book);
		return new ModelAndView("redirect:/book");
	}
	
}
