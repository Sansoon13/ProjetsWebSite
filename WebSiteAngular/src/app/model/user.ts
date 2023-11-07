import { Adresse } from "./adresse";
import { Evaluation } from "./evaluation";

export class User {
    constructor(
       private id:number,
       private firstName:string,
       private lastName:string,
       private username:string,
       private password:string,
       private email:string,
       
       private addresse:Adresse,
       private evaluations:Evaluation[],
        

        
        ){}
}
