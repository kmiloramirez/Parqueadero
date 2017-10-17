import { Component, OnInit } from '@angular/core';
import { ListarVehiculosService } from '../../services/listar-vehiculos.service';


@Component({
  selector: 'app-listar-vehiculos',
  templateUrl: './listar-vehiculos.component.html',
  styleUrls: ['./listar-vehiculos.component.css']
})
export class ListarVehiculosComponent implements OnInit {

  public vehiculos;
  constructor(private _service:ListarVehiculosService) {

  _service.all().subscribe(vehiculos=>{this.vehiculos=vehiculos;});
  
  }

  ngOnInit() {
  }

}


