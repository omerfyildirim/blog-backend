package com.blog.blog.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Type;

@Entity
@Table(name = "posts")
@Getter
@Setter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Lob
    @Column(name = "description",columnDefinition = "text")
    private String description;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


}
