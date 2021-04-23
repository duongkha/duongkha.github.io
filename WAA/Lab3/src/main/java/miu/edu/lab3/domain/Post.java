package miu.edu.lab3.domain;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

public class Post {
    long id;
    String title;
    String content;
    String author;

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
