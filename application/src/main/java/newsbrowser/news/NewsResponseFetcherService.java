package newsbrowser.news;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Locale;
import java.util.Optional;

@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class NewsResponseFetcherService implements ResponseFetcherService<NewsResponse>
{
    static String BASE_URL = "https://newsapi.org/v2/top-headlines?country={country}&category={category}&apiKey=93c9f3a8624c4327a6565e8fd71ea8a2";

    RestTemplate restTemplate;

    @Override
    public NewsResponse fetch(String country, String category)
    {
        Locale locale = new Locale("", country);
        NewsResponse newsResponse = restTemplate.getForObject(createUri(country, category), NewsResponse.class);
        newsResponse.setCountry(locale.getDisplayCountry(Locale.US).toLowerCase());
        newsResponse.setCategory(category);

        return Optional.ofNullable(newsResponse)
                .orElse(new NewsResponse());
    }

    private URI createUri(String country, String category)
    {
        return UriComponentsBuilder
                .fromUriString(BASE_URL)
                .build(country, category);
    }
}