package app.newsbrowser.news;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Locale;

@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class NewsResponseFetcherService implements ResponseFetcherService
{
    String API_KEY;
    String TOP_HEADLINES_URL;
    RestTemplate restTemplate;

    NewsResponseFetcherService( @Value("${news.api-key}") String apiKey,
                                @Value("${news.api-url}") String topHeadlinesUrl,
                                RestTemplate theRestTemplate)
    {
        API_KEY = apiKey;
        TOP_HEADLINES_URL = topHeadlinesUrl;
        restTemplate = theRestTemplate;
    }

    @Override
    public NewsResponse fetchNewsByCountryAndCategory(String countryCode, String category)
    {
        News news = restTemplate.getForObject(createUri(countryCode, category), News.class);
        return NewsResponse.builder()
                .category(category)
                .country(isoCountryCodeToCountryName(countryCode))
                .articles(news.getArticles())
                .build();
    }

    private URI createUri(String country, String category)
    {
        return UriComponentsBuilder
                .fromUriString(TOP_HEADLINES_URL + API_KEY)
                .build(country, category);
    }

    private String isoCountryCodeToCountryName(String countryCode)
    {
        Locale locale = new Locale("", countryCode);
        return locale.getDisplayCountry(Locale.US).toLowerCase();
    }
}
