package com.spring.admin.springboot.domain.posts;

import com.spring.admin.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//lombok
@Getter //기본 Getter 메소드 자동 생성
@NoArgsConstructor //기본 생성자
@Entity //테이블과 링크될 클래스임을 나타냄
public class Posts extends BaseTimeEntity {

    @Id //pk임을 나타냄.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //pk 생성규칙. (auto_increment)
    private Long id;

    @Column(length = 500, nullable = false) //선언을 안하더라도 컬럼으로 되지만, 옵션을 변경할 떄 쓰임.
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

}
