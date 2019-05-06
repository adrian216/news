package newsbrowser.news;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/news")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class NewsResponseRestController
{
    ResponseFetcherService newsResponseFetcherService;

    @GetMapping(value = "/{country}/{category}")
    NewsResponse fetchNewsByCountryAndCategory(
            @PathVariable String country, @PathVariable String category)
    {
        return newsResponseFetcherService.fetchNewsByCountryAndCategory(country, category);
    }
}
