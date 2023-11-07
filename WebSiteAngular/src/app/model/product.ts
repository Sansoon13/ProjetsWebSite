import { Category } from "./category"
import { Evaluation } from "./evaluation"
import { Ingredient } from "./ingredient"

export class Product {
    constructor(
        public id?:number,
        public title?:string,
        public price?:number,
        public description?:string,
        public image?:string,
        public avgRating?:number,

        public evaluations?:Evaluation[],
        public ingredients?:Ingredient[],
        public categories?:Category[]
    ){}
    
}
