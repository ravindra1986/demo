/**
 * 
 */
package com.genpact.demo.service;

import java.util.List;
import java.util.Optional;

import com.genpact.demo.exception.RecordNotFoundException;
import com.genpact.demo.model.BookEntity;

/**
 * @author ravindra
 *
 */
public interface BookService {

	public List<BookEntity> getAll();

	public Optional<BookEntity> getfindById(Long id) throws RecordNotFoundException;

	public BookEntity updateBook(BookEntity entity) throws RecordNotFoundException;
	
	public BookEntity save(BookEntity entity) throws RecordNotFoundException;

	public void deleteBookById(Long id) throws RecordNotFoundException;

}
