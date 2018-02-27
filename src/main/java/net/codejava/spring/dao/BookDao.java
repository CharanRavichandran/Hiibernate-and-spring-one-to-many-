package net.codejava.spring.dao;

import java.util.List;
import net.codejava.spring.model.Book;

public interface BookDao {
	public List<Book> list();
	
	public Book get(int id);
	
	public void saveOrUpdate(Book book);
	
	public void delete(int id);
}