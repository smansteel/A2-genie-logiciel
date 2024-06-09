import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewWalletPopupComponent } from './new-wallet-popup.component';

describe('NewWalletPopupComponent', () => {
  let component: NewWalletPopupComponent;
  let fixture: ComponentFixture<NewWalletPopupComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [NewWalletPopupComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(NewWalletPopupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
