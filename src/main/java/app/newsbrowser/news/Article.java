package app.newsbrowser.news;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
class Article
{
    String author;
    String title;
    String description;
    @JsonProperty("date")
    LocalDate publishedAt;
    String sourceName;
    @JsonProperty("articleUrl")
    String url;
    @JsonProperty("imageUrl")
    String urlToImage;

    @JsonProperty("source")
    private void getSourceName(Source source)
    {
        this.sourceName = source.getName();
    }
}
