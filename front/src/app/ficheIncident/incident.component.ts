import { Component, OnInit } from '@angular/core';
import { Incident } from '../entities/model.incident';
import { Route, ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { Service } from '../service';


@Component({
  selector: 'app-incident',
  templateUrl: './incident.component.html',
  styleUrls: ['./incident.component.css']
})
export class IncidentComponent implements OnInit {
  routeSub: any;
  incident:Incident[];
  incident1:Incident;

  constructor(private route:ActivatedRoute,
    private service:Service,private location:Location) { }

  ngOnInit() {
    this.getFiches();
    
  }

  getFiches(): void{
    this.service.getAllFiches().subscribe(res=>{
      this.incident=res;
    });
  }

  
  }
