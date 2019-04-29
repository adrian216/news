package newsbrowser.news;

public interface ResponseFetcherService<T>
{
    T fetch(String country, String category);
}
