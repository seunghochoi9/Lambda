package article;

import lombok.*;

import java.util.Date;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = {"id"})

public class Article {
    private Long id;
    private String title;
    private String content;
    private String writer;
    private String register_date;

    @Builder(builderMethodName = "builder")
    public Article(Long id, String title, String content, String writer, String register_date) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.register_date = register_date;
    }
}
