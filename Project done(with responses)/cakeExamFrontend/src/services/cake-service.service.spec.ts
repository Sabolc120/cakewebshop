import { TestBed } from '@angular/core/testing';

import { CakeServiceService } from './cake-service.service';

describe('CakeServiceService', () => {
  let service: CakeServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CakeServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
