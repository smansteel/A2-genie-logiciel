import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchUserPopupComponent } from './search-user-popup.component';

describe('SearchUserPopupComponent', () => {
  let component: SearchUserPopupComponent;
  let fixture: ComponentFixture<SearchUserPopupComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SearchUserPopupComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SearchUserPopupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
