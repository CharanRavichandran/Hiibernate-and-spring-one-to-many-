package net.codejava.spring.dao;

import java.util.List;
import javax.transaction.Transactional;
import net.codejava.spring.model.Book;


import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {
	@Autowired
	private SessionFactory sessionFactory;

	public BookDaoImpl () {
		
	}
	
	public BookDaoImpl (SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	@Transactional
	public List<Book> list() {
		@SuppressWarnings("unchecked")
		List<Book> listUser = (List<Book>) sessionFactory.getCurrentSession()
				.createCriteria(Book.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listUser;
	}

	
	@Transactional
	public void saveOrUpdate(Book book) {
		sessionFactory.getCurrentSession().saveOrUpdate(book);
	}

	
	@Transactional
	public void delete(int id) {
		Book userToDelete = new Book();
		userToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(userToDelete);
	}

	
	@Transactional
	public Book get(int id) {
		String hql = "from Book where id=" + id;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Book> listUser = (List<Book>) query.list();
		
		if (listUser != null && !listUser.isEmpty()) {
			return listUser.get(0);
		}
		
		return null;
	}
}