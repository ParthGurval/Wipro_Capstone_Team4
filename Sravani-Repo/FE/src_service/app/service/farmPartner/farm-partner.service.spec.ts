import { TestBed } from '@angular/core/testing';

import { FarmPartnerService } from './farm-partner.service';

describe('FarmPartnerService', () => {
  let service: FarmPartnerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FarmPartnerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
