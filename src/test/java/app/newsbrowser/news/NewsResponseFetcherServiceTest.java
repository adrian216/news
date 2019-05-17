package app.newsbrowser.news;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class NewsResponseFetcherServiceTest
{
    @Autowired
    private NewsResponseFetcherService newsResponseFetcherService;

    @Test
    public void shouldReturnNotNullObjectWithCorrectCountryAndCategory()
    {
        NewsResponse news = newsResponseFetcherService.fetchNewsByCountryAndCategory("pl", "technology");
        Assertions.assertNotNull(news);
        Assertions.assertEquals(news.getCategory(), "technology");
        Assertions.assertEquals(news.getCountry(), "poland");
    }
}
