package newsbrowser.news;

public interface ResponseFetcherService
{
    NewsResponse fetchNewsByCountryAndCategory(String country, String category);
}
