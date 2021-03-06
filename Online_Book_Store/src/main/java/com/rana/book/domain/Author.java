package com.rana.book.domain;
// Generated Aug 1, 2018 1:12:53 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Author generated by hbm2java
 */
@Entity
@Table(name="author"
    ,catalog="book_store"
)
public class Author  implements java.io.Serializable {


     private Integer authId;
     private String authName;
     private Set<BookList> bookLists = new HashSet<BookList>(0);

    public Author() {
    }

	
    public Author(String authName) {
        this.authName = authName;
    }
    public Author(String authName, Set<BookList> bookLists) {
       this.authName = authName;
       this.bookLists = bookLists;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="auth_id", unique=true, nullable=false)
    public Integer getAuthId() {
        return this.authId;
    }
    
    public void setAuthId(Integer authId) {
        this.authId = authId;
    }

    
    @Column(name="auth_name", nullable=false, length=45)
    public String getAuthName() {
        return this.authName;
    }
    
    public void setAuthName(String authName) {
        this.authName = authName;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="author")
    public Set<BookList> getBookLists() {
        return this.bookLists;
    }
    
    public void setBookLists(Set<BookList> bookLists) {
        this.bookLists = bookLists;
    }




}


