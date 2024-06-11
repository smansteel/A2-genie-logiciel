import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeWalletsComponent } from './home-wallets.component';

describe('HomeWalletsComponent', () => {
  let component: HomeWalletsComponent;
  let fixture: ComponentFixture<HomeWalletsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HomeWalletsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(HomeWalletsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
