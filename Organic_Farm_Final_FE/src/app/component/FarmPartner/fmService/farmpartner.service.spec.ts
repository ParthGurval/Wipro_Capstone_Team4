import { TestBed } from '@angular/core/testing';

import { FarmpartnerService } from './farmpartner.service';

describe('FarmpartnerService', () => {
  let service: FarmpartnerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FarmpartnerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
