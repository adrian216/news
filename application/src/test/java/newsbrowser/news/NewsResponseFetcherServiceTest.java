package newsbrowser.news;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(MockitoJUnitRunner.class)
public class NewsResponseFetcherServiceTest
{
    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private NewsResponseFetcherService newsResponseFetcherService;

    @Test
    public void testFetchNewsByCountryAndCategoryOnce()
    {
       Mockito.when(restTemplate.getForObject("http://localhost:8080/news/pl/technology", NewsResponse.class))
               .thenReturn(new NewsResponse());
    }

}
