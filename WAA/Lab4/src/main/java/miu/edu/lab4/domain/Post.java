package miu.edu.lab4.domain;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Post {
    @Id
    long id;
    String title;
    String content;
    String author;
    public Post(){}

    public Post(long id, String title, String content, String author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

}
