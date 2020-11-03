/**
 * 
 */
package com.genpact.demo.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * @author ravindra
 *
 */
@Entity
@Table(name = "LIBRARY")
public class LibraryEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1727600033284538035L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", nullable = false, length = 255)
	private String name;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "library", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<BookEntity> books = new HashSet<>();


	

	/**
	 * 
	 */
	public LibraryEntity() {
		super();
	}
	

	/**
	 * @param id
	 * @param name
	 */
	public LibraryEntity(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}



	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the books
	 */
	public Set<BookEntity> getBooks() {
		return books;
	}



	/**
	 * @param books the books to set
	 */
	public void setBooks(Set<BookEntity> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "LibraryEntity [id=" + id + ", name=" + name + ", books=" + books + "]";
	}

}
