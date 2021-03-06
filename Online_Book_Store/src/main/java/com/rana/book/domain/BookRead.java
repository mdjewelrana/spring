package com.rana.book.domain;
// Generated Aug 1, 2018 1:12:53 AM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * BookRead generated by hbm2java
 */
@Entity
@Table(name="book_read"
    ,catalog="book_store"
)
public class BookRead  implements java.io.Serializable {


     private Integer bookReadId;
     private String bookNam;
     private String bookPdf;

    public BookRead() {
    }

    public BookRead(String bookNam, String bookPdf) {
       this.bookNam = bookNam;
       this.bookPdf = bookPdf;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="book_read_id", unique=true, nullable=false)
    public Integer getBookReadId() {
        return this.bookReadId;
    }
    
    public void setBookReadId(Integer bookReadId) {
        this.bookReadId = bookReadId;
    }

    
    @Column(name="book_nam", nullable=false, length=45)
    public String getBookNam() {
        return this.bookNam;
    }
    
    public void setBookNam(String bookNam) {
        this.bookNam = bookNam;
    }

    
    @Column(name="book_pdf", nullable=false, length=45)
    public String getBookPdf() {
        return this.bookPdf;
    }
    
    public void setBookPdf(String bookPdf) {
        this.bookPdf = bookPdf;
    }




}


