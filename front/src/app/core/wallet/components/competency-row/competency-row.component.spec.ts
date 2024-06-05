import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CompetencyRowComponent } from './competency-row.component';

describe('CompetencyRowComponent', () => {
  let component: CompetencyRowComponent;
  let fixture: ComponentFixture<CompetencyRowComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CompetencyRowComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CompetencyRowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
