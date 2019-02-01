import { Component, OnInit } from '@angular/core';
import { Incident } from '../entities/model.incident';
import { Vehicule } from '../entities/model.vehicule';
import { Service } from '../service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-new-incident',
  templateUrl: './new-incident.component.html',
  styleUrls: ['./new-incident.component.css']
})
export class NewIncidentComponent implements OnInit {
  vehicules: Vehicule[];
  incident=new Incident();
  vehicule=new Vehicule();
  
  inc:any;

  constructor(private service: Service, private location:Location) { }

  ngOnInit() { 
    this.incident=new Incident();
    this.vehicule=new Vehicule();
  }
  
    
  saveFiche(){
    this.incident.vehicule=this.vehicule;
    this.service.ajout(this.incident).subscribe(res=>{
      this.inc=res;
    });
  }
  back() {
    this.location.back();
}
}
