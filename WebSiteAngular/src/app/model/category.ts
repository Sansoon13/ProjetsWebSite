import { Product } from "./product";

export class Category {
    constructor(
        public id: number, 
        public title: string,
        public vignette:string,
        public produits:Product[]
        
        
        
        
        ) { }

}
