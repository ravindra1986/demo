/**
 * 
 */
package com.genpact.demo.web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.genpact.demo.exception.RecordNotFoundException;
import com.genpact.demo.model.BookEntity;
import com.genpact.demo.service.BookService;

/**
 * @author ravindra
 *
 */
@RestController
@RequestMapping("/book")
public class BookController {
	@Autowired
	private BookService bookService;

	@GetMapping
	public ResponseEntity<List<BookEntity>> getAllBooks() {
		List<BookEntity> list = bookService.getAll();
		return new ResponseEntity<List<BookEntity>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@PutMapping("/{bookId}")
	public ResponseEntity<BookEntity> updatePost(@PathVariable Long bookId, @Valid @RequestBody BookEntity bookEntity)
			throws RecordNotFoundException {

		Optional<BookEntity> entity = bookService.getfindById(bookId);
		if (entity.isPresent()) {
			return new ResponseEntity<>(bookService.updateBook(bookEntity), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping
	public ResponseEntity<BookEntity> createOrUpdateEmployee(BookEntity bookEntity) throws RecordNotFoundException {
		BookEntity newEntity = bookService.save(bookEntity);
		return new ResponseEntity<BookEntity>(newEntity, new HttpHeaders(), HttpStatus.OK);
	}
}
