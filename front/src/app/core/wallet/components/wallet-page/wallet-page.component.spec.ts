import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WalletPageComponent } from './wallet-page.component';

describe('WalletPageComponent', () => {
  let component: WalletPageComponent;
  let fixture: ComponentFixture<WalletPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [WalletPageComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(WalletPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
