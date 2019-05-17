import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NewsComponent } from './news.component';
import {NgxPaginationModule} from 'ngx-pagination';
import {HttpClientTestingModule} from '@angular/common/http/testing';
import {NewsService} from './news.service';

describe('NewsComponent', () => {
  let component: NewsComponent;
  let fixture: ComponentFixture<NewsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [NgxPaginationModule, HttpClientTestingModule],
      declarations: [ NewsComponent],
      providers: [NewsService]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
  it('should have fetchNews function', () => {
    const service: NewsService = TestBed.get(NewsService);
    expect(service.fetchNews).toBeTruthy();
  });

});
