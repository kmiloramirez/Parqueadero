import { TestBed, inject } from '@angular/core/testing';

import { SalidaService } from './salida.service';

describe('SalidaService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [SalidaService]
    });
  });

  it('should be created', inject([SalidaService], (service: SalidaService) => {
    expect(service).toBeTruthy();
  }));
});
