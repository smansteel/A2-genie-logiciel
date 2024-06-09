import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CompetenceLevelChipComponent } from './competence-level-chip.component';

describe('CompetenceLevelChipComponent', () => {
  let component: CompetenceLevelChipComponent;
  let fixture: ComponentFixture<CompetenceLevelChipComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CompetenceLevelChipComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CompetenceLevelChipComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
