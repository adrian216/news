import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { FooterComponent } from './core/footer/footer.component';
import { NavbarComponent } from './core/navbar/navbar.component';
import { ErrorComponent } from './core/error/error.component';
import { AboutComponent } from './about/about.component';
import { NewsComponent } from './shared/news/news.component';
import {AppRoutingModule} from './app-routing.module';
import {HttpClientModule} from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    NavbarComponent,
    ErrorComponent,
    AboutComponent,
    NewsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
