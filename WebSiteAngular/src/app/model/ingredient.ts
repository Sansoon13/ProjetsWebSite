import { Product } from "./product";

export class Ingredient {
    constructor(
        public id:number,
        public name:string,
        public produits:Product[]
    ){}
}
