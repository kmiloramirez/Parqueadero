import { Component, OnInit,Input,Output,EventEmitter } from '@angular/core';

@Component({
  selector: 'app-moto-form',
  templateUrl: './moto-form.component.html',
  styleUrls: ['./moto-form.component.css']
})
export class MotoFormComponent implements OnInit {

  @Output() onSubmit=new EventEmitter<any>();
  
  @Input() moto;
  constructor() { }

  ngOnInit() {
  }

  public submit(){
    this.onSubmit.emit({moto:this.moto});
  }
}
