/**
 * 
 */
package com.genpact.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.genpact.demo.model.BookEntity;

/**
 * @author ravindra
 *
 */
public interface BookRepository extends JpaRepository<BookEntity, Long>{

}
