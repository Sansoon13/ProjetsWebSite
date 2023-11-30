import { Adresse } from "./adresse";
import { Evaluation } from "./evaluation";
import { Role } from "./role";

export class User {
    constructor(
       public id:number,
       public firstName:string,
       public lastName:string,
       public username:string,
       public password:string,
       public email:string,
       public dateEntry:Date,
       public role:Role,
       public addresse:Adresse,
       public evaluations:Evaluation[],
        

        
        ){}
}
