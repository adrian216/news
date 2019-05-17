package app.newsbrowser.news;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
class NewsResponse
{
    String country;
    String category;
    List<Article> articles;
}
