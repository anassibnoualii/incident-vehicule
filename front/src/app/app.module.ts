import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from"@angular/forms";
import {HttpModule} from"@angular/http";

import { AppComponent } from './app.component';
import { IncidentComponent } from './ficheIncident/incident.component';
import { NewIncidentComponent } from './inserer/new-incident.component';
import { RouteModule } from './route';
import { Service } from './service';


@NgModule({
  declarations: [
    AppComponent,
    IncidentComponent,
    
    NewIncidentComponent,
    
    
      ],
  imports: [
    FormsModule,
    HttpModule,
    BrowserModule,
    RouteModule
  ],
  providers: [Service],
  bootstrap: [AppComponent]
})
export class AppModule { }
