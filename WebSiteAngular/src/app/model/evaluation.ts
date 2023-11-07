import { Product } from "./product";
import { User } from "./user";

export class Evaluation {
    constructor(
        public id: number,
        public rating: number,
        public comment: string,
        public author:User,
        public product: Product
    ){}
}
