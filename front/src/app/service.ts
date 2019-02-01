import {Injectable} from"@angular/core";
import {Http, Response, RequestOptions,Headers} from"@angular/http";
import "rxjs/add/operator/map";
import "rxjs/add/operator/catch";
import {Observable} from"rxjs";
import { Incident } from "./entities/model.incident";
import { Vehicule } from "./entities/model.vehicule";
@Injectable()
export class Service{
    constructor(private http:Http){}


getAllFiches():Observable<Incident[]>{
        return this.http.get('api/fiches/').map(resp=>{
            return resp.json();
        });
}



ajout(incident:Incident){
    let headers = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: headers });
    return this.http.post("api/fiches/",incident,options).map(resp=>{
        return resp.json();
    });
}

}

