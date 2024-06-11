import { TestBed } from '@angular/core/testing';

import { WalletPreviewService } from './wallet-preview.service';

describe('WalletPreviewService', () => {
  let service: WalletPreviewService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(WalletPreviewService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
