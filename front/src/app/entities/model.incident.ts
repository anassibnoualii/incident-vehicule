import { Vehicule } from "./model.vehicule";

export class Incident {
        constructor(
                public id?:number,
                public date_incident?:any,
                public numero_fiche?:string,
                public incident_critique?:boolean,
                public lieu_incident?:string,
                public nombre_voyageur?:number,
                public description_incident?:string,
                public vehicule?:Vehicule
        ){
                this.incident_critique=false;
        }
        
   
}