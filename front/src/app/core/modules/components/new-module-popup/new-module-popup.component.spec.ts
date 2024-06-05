import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewModulePopupComponent } from './new-module-popup.component';

describe('NewModulePopupComponent', () => {
  let component: NewModulePopupComponent;
  let fixture: ComponentFixture<NewModulePopupComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [NewModulePopupComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(NewModulePopupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
