import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ErrorComponent} from './core/error/error.component';
import {AboutComponent} from './about/about.component';
import {NgxPaginationModule} from 'ngx-pagination';
import {NewsComponent} from './shared/news/news.component';

const routes: Routes = [
  {
    path: 'pl', component: NewsComponent
  },
  {
    path: 'pl/:categoryName', component: NewsComponent
  },
  {
    path: '', component: NewsComponent
  },
  {
    path: 'about', component: AboutComponent
  },
  {
    path: '**', component: ErrorComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule, NgxPaginationModule]
})
export class AppRoutingModule { }
