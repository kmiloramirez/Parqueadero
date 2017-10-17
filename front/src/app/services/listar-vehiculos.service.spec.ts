import { TestBed, inject } from '@angular/core/testing';

import { ListarVehiculosService } from './listar-vehiculos.service';

describe('ListarVehiculosService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ListarVehiculosService]
    });
  });

  it('should be created', inject([ListarVehiculosService], (service: ListarVehiculosService) => {
    expect(service).toBeTruthy();
  }));
});
