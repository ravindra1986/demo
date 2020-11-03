/**
 * 
 */
package com.genpact.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author ravindra
 *
 */
@Entity
@Table(name = "BOOK")
public class BookEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8966061967834147478L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "book_name", nullable = false, length = 255)
	private String bookName;
	
	@Column(name = "isbn_no", nullable = false, length = 255)
	private String isbnNo;
	
	@Column(name = "lib_id", nullable = false, length = 10)
	
	private Long libId;
	@JsonBackReference
	 @ManyToOne(fetch = FetchType.LAZY, optional = false)
	 @JoinColumn(name = "lib_id", nullable = false,insertable = false, updatable = false)
    private LibraryEntity library;

	 
	/**
	 * 
	 */
	public BookEntity() {
		super();
	}
	

	/**
	 * @param id
	 * @param bookKame
	 * @param isbnNo
	 * @param libId
	 */
	public BookEntity(Long id, String bookName, String isbnNo, Long libId) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.isbnNo = isbnNo;
		this.libId = libId;
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
	 * @return the bookKame
	 */
	public String getBookName() {
		return bookName;
	}

	/**
	 * @param bookKame the bookKame to set
	 */
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	/**
	 * @return the isbnNo
	 */
	public String getIsbnNo() {
		return isbnNo;
	}

	/**
	 * @param isbnNo the isbnNo to set
	 */
	public void setIsbnNo(String isbnNo) {
		this.isbnNo = isbnNo;
	}

	/**
	 * @return the library
	 */
	public LibraryEntity getLibrary() {
		return library;
	}

	/**
	 * @param library the library to set
	 */
	public void setLibrary(LibraryEntity library) {
		this.library = library;
	}

	@Override
	public String toString() {
		return "BookEntity [id=" + id + ", bookKame=" + bookName + ", isbnNo=" + isbnNo + ", library=" + library + "]";
	}
	
	
}
