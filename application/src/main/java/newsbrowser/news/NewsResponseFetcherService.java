package newsbrowser.news;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Locale;

@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class NewsResponseFetcherService implements ResponseFetcherService
{
    static final String API_KEY = "93c9f3a8624c4327a6565e8fd71ea8a2";
    static final String TOP_HEADLINES_URL = "https://newsapi.org/v2/top-headlines?country={country}&category={category}&apiKey="+API_KEY;

    RestTemplate restTemplate;

    @Override
    public NewsResponse fetchNewsByCountryAndCategory(String country, String category)
    {
        News news = restTemplate.getForObject(createUri(country, category), News.class);
        return NewsResponse.builder()
                .category(category)
                .country(isoCountryCodeToCountryName(country))
                .articles(news.getArticles())
                .build();
    }

    private URI createUri(String country, String category)
    {
        return UriComponentsBuilder
                .fromUriString(TOP_HEADLINES_URL)
                .build(country, category);
    }

    private String isoCountryCodeToCountryName(String countryCode)
    {
        Locale locale = new Locale("", countryCode);
        return locale.getDisplayCountry(Locale.US).toLowerCase();
    }
}