/**
 * 
 */
package com.genpact.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genpact.demo.exception.RecordNotFoundException;
import com.genpact.demo.model.BookEntity;
import com.genpact.demo.repository.BookRepository;

/**
 * @author ravindra
 *
 */
@Service
public class BookServiceImpl implements BookService {

	@Autowired

	private BookRepository bookRepository;

	@Override
	public List<BookEntity> getAll() {

		List<BookEntity> bookList = bookRepository.findAll();

		if (bookList.size() > 0) {
			return bookList;
		} else {
			return new ArrayList<BookEntity>();
		}
	}

	/**
	 * Gets the find by id.
	 *
	 * @param id the id
	 * @return the find by id
	 * @throws RecordNotFoundException the record not found exception
	 */
	@Override
	public Optional<BookEntity> getfindById(Long id) throws RecordNotFoundException {
		return bookRepository.findById(id);
	}

	@Override
	public BookEntity updateBook(BookEntity entity) throws RecordNotFoundException {
		Optional<BookEntity> employee = bookRepository.findById(entity.getId());

		if (employee.isPresent()) {
			BookEntity newEntity = employee.get();
			newEntity.setBookName(entity.getBookName());
			newEntity.setIsbnNo(entity.getIsbnNo());

			newEntity = bookRepository.save(newEntity);

			return newEntity;
		} else {
			entity = bookRepository.save(entity);

			return entity;
		}
	}

	@Override
	public void deleteBookById(Long id) throws RecordNotFoundException {

	}

	@Override
	public BookEntity save(BookEntity entity) throws RecordNotFoundException {
		bookRepository.save(entity);
		return entity;
	}

}
