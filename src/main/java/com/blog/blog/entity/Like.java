package com.blog.blog.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "p_like")
@Getter
@Setter
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //GeneratedValue'da bir değer yaratılıyor ve bu değere bir strateji atanıyor bu stratejide identity yani benzersiz ve birbir artan,gibi.
    @Column(name = "id")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id",nullable = false)
    private User user;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL) //Fetchtype'ta ben isteyene kadar bunu getirme diyoruz yani tembelleş
    //Cascade all birbirine bağlı olan değerlerin birbirine olan etkisidir yani örnek vermek gerekirse çağlayan etkisi eğer post silinirse beraberinde like'larıda silinecek,vb.
    @JoinColumn(name = "post_id",nullable = false) //nullable =false id si boş geçilemez.
    private Post post;
}
