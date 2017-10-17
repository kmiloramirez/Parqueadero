import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import{FormsModule} from '@angular/forms';
import{HttpModule} from '@angular/http';
import { AppComponent } from './app.component';
import { IngresoMotoComponent } from './components/ingreso-moto/ingreso-moto.component';
import { IngresoCarroComponent } from './components/ingreso-carro/ingreso-carro.component';
import {MotoService} from './services/moto.service';
import {appRoutes} from './app.routing';
import { RouterModule } from '@angular/router';
import { MotoFormComponent } from './components/moto-form/moto-form.component';
import { CarroFormComponent } from './components/carro-form/carro-form.component';
import { CarroService } from './services/carro.service';
import { ListarVehiculosComponent } from './components/listar-vehiculos/listar-vehiculos.component';
import { ListarVehiculosService } from './services/listar-vehiculos.service';
import { SalidaVehiculosComponent } from './components/salida-vehiculos/salida-vehiculos.component';
import { SalidaFormComponent } from './components/salida-form/salida-form.component';
import { SalidaService } from './services/salida.service';
import { ReciboComponent } from './components/recibo/recibo.component';
@NgModule({
  declarations: [
    AppComponent,
    IngresoMotoComponent,
    IngresoCarroComponent,
    MotoFormComponent,
    CarroFormComponent,
    ListarVehiculosComponent,
    SalidaVehiculosComponent,
    SalidaFormComponent,
    ReciboComponent
  ],
  imports: [
    RouterModule.forRoot(appRoutes),
    BrowserModule,
    FormsModule,
    HttpModule
  ],
  providers: [MotoService,CarroService,ListarVehiculosService,SalidaService],
  bootstrap: [AppComponent]
})
export class AppModule { }
