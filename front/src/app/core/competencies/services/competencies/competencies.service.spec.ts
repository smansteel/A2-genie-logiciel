import { TestBed } from '@angular/core/testing';

import { CompetenciesService } from './competencies.service';

describe('CompetenciesService', () => {
  let service: CompetenciesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CompetenciesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
