import {Article} from '../article/article.model';

export class News {
  country: string;
  category: string;
  articles: Array<Article>;
}
