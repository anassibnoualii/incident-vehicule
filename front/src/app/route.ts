import {Routes, RouterModule} from"@angular/router";
import {NgModule} from"@angular/core";
import { IncidentComponent } from "./ficheIncident/incident.component";
import { NewIncidentComponent } from "./inserer/new-incident.component";
const appRoutes: Routes = [
    { path: 'incident', component: IncidentComponent}, 
    { path: 'new-incident', component: NewIncidentComponent},
    { path: '',redirectTo: 'incident',pathMatch: 'full'},
    
];
@NgModule({
    imports:
    [
        RouterModule.forRoot(appRoutes)
    ],
    exports:
    [RouterModule]})
    export class RouteModule{

    }