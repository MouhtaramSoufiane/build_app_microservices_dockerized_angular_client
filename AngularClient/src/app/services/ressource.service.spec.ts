import { TestBed } from '@angular/core/testing';

import { RessourceService } from './ressource.service';

describe('RessourceService', () => {
  let service: RessourceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RessourceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
