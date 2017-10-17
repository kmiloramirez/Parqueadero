import { Component, OnInit,Output,Input,EventEmitter} from '@angular/core';
import {Router} from '@angular/router';
import {CarroService} from '../../services/carro.service';
@Component({
  selector: 'app-carro-form',
  templateUrl: './carro-form.component.html',
  styleUrls: ['./carro-form.component.css']
})
export class CarroFormComponent implements OnInit {

  @Output() onSubmit=new EventEmitter<any>();
  
  @Input() carro;
  constructor() { }

  ngOnInit() {
  }

  public submit(){
    this.onSubmit.emit({carro:this.carro});
  }
  

}
