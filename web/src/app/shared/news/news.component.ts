import {Component, Injectable, OnInit} from '@angular/core';
import {News} from './news.model';
import {NewsService} from './news.service';

@Component({
  selector: 'app-news',
  templateUrl: './news.component.html',
  styleUrls: ['./news.component.css']
})
@Injectable()
export class NewsComponent implements OnInit {
  news: News;
  p: 1;

  constructor(public newsService: NewsService) { }

  ngOnInit() {
    this.newsService.fetchNews('technology').subscribe((data: News) => this.news = { ...data});
  }
  fetchNews(category) {
    this.newsService.fetchNews(category).subscribe((data: News) => this.news = { ...data});
  }
}
