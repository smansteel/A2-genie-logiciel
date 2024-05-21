import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CompetenciesPageComponent } from './competencies-page.component';

describe('CompetenciesPageComponent', () => {
  let component: CompetenciesPageComponent;
  let fixture: ComponentFixture<CompetenciesPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CompetenciesPageComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CompetenciesPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
