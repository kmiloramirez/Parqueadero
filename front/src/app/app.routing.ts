import {Routes} from '@angular/router';
import{IngresoMotoComponent} from './components/ingreso-moto/ingreso-moto.component';
import{IngresoCarroComponent} from './components/ingreso-carro/ingreso-carro.component';
import{ListarVehiculosComponent} from './components/listar-vehiculos/listar-vehiculos.component';
import{SalidaVehiculosComponent} from './components/salida-vehiculos/salida-vehiculos.component';
export const appRoutes:Routes = [
    {path: 'moto/ingreso', component: IngresoMotoComponent},
    {path: 'listar/vehiculos', component: ListarVehiculosComponent},
    {path: 'carro/ingreso', component: IngresoCarroComponent},
    {path: 'vehiculo/salida', component:SalidaVehiculosComponent },
    {path: '', redirectTo :'/listar/vehiculos',pathMatch : 'full'}
    
];