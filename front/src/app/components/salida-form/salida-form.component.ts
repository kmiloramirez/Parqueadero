import {Component, OnInit,Output,Input,EventEmitter} from '@angular/core';
import {Router} from '@angular/router';
@Component({
  selector: 'app-salida-form',
  templateUrl: './salida-form.component.html',
  styleUrls: ['./salida-form.component.css']
})
export class SalidaFormComponent implements OnInit {
  @Output() onSubmit=new EventEmitter<any>();

  @Input() vehiculo;
  constructor() { }

  ngOnInit() {
  }

  public submit(){
    this.onSubmit.emit({vehiculo:this.vehiculo});
  }

}
