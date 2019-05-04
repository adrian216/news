import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {News} from './news.model';

@Injectable({
  providedIn: 'root'
})
export class NewsService {
  apiUrl = 'http://localhost:8080/news/pl/';

  constructor(private httpClient: HttpClient) { }
  fetchNews(category) {
    return this.httpClient.get<News>( this.apiUrl + category);
  }
}
