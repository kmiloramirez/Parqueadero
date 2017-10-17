import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SalidaVehiculosComponent } from './salida-vehiculos.component';

describe('SalidaVehiculosComponent', () => {
  let component: SalidaVehiculosComponent;
  let fixture: ComponentFixture<SalidaVehiculosComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SalidaVehiculosComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SalidaVehiculosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
