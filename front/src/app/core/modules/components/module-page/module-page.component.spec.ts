import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModulePageComponent } from './module-page.component';

describe('ModulePageComponent', () => {
  let component: ModulePageComponent;
  let fixture: ComponentFixture<ModulePageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ModulePageComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ModulePageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
