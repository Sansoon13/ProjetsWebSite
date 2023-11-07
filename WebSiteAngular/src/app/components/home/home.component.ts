import { Component } from '@angular/core';
import { Category } from 'src/app/model/category';
import { Ingredient } from 'src/app/model/ingredient';
import { Product } from 'src/app/model/product';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  products: Product[]=[];
  index:number[]=[1,19,14,4];
  productActif!:any;
  categories!:Category[];
  categoriesProduct:any;
  rating:any;
  ingredients!:any;

  constructor(private pSrv: ProductService) { }

  ngOnInit(): void {

    this.getProductHome();
    
  }




getProductHome(){
  for(let i=0;i<this.index.length;i++){
    this.pSrv.getById(this.index[i]).subscribe({
      next:(p)=>{
      this.products.push(p);
      console.log("produit "+this.products);
    },error:(err)=>{
      console.log("erreur recupération des produits");
    }
  });
  }
}

afficherInfo(product:Product){
  if(this.productActif===product){
    this.productActif=null;
  }else{
    this.productActif=null
    this.productActif=product;
    this.pSrv.getByIdWithIngredients(product.id!).subscribe({
        next:(products)=>{
          this.ingredients=products.ingredients;
        }
    });
    this.pSrv.getByIdWithCategories(product.id!).subscribe({
      next:(products)=>{
        this.categoriesProduct=products.categories;
        console.log("categories"+this.categories);
      },
      error:(err)=>{
        console.log("erreur recupération des categories"+err);
      }
    });
    this.pSrv.getByIdWithEvaluations(product.id!).subscribe((p)=>{
      this.rating=this.pSrv.percentavgRating(p.avgRating!);
    });
    
      
    
  }
  
      
}


}
