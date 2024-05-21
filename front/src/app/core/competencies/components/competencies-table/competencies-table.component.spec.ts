import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CompetenciesTableComponent } from './competencies-table.component';

describe('CompetenciesTableComponent', () => {
  let component: CompetenciesTableComponent;
  let fixture: ComponentFixture<CompetenciesTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CompetenciesTableComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CompetenciesTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
