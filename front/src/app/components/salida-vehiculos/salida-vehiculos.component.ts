import { Component, OnInit,Output,Input,EventEmitter } from '@angular/core';
import {Router} from '@angular/router';
import {SalidaService} from '../../services/salida.service';

@Component({
  selector: 'app-salida-vehiculos',
  templateUrl: './salida-vehiculos.component.html',
  styleUrls: ['./salida-vehiculos.component.css']
})
export class SalidaVehiculosComponent implements OnInit {

  public vehiculo={
    placa:''
  };
  constructor(private _router:Router,
  private _service:SalidaService) { }

  ngOnInit() {
  }
  
  salidaVehiculo(obj){
    this._service.salir(obj.vehiculo).subscribe(res=>{
      this._router.navigate(['/listar/vehiculos']);
    });
  }


}
