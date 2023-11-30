import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormControlName, FormGroup } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { Observable, map, startWith, switchMap } from 'rxjs';
import { AnyCatcher } from 'rxjs/internal/AnyCatcher';
import { Category } from 'src/app/model/category';
import { Ingredient } from 'src/app/model/ingredient';
import { Product } from 'src/app/model/product';
import { Role } from 'src/app/model/role';
import { User } from 'src/app/model/user';
import { CategoryService } from 'src/app/services/category.service';
import { IngredientService } from 'src/app/services/ingredient.service';
import { ProductService } from 'src/app/services/product.service';
import { DeleteProductModalComponent } from '../../modal/delete-product-modal/delete-product-modal.component';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit{
  showFilter:boolean=false;
  ingredients!:any;
  categories!:Category[];
  categoriesProduct:any;
  listproducts!:Product[];
  productActif!:any;
  rating:number=0;
  noteMoy:any;
  value!:number;
  productFiltered!:Product[];
  title!:string;
  tagId:number[]=[];
  allproducts!:Product[];
  role!:string;
  

  constructor(private pSrv:ProductService, private cSrv:CategoryService,private ingSrv:IngredientService,private fb:FormBuilder,
                private dialog:MatDialog) { }
  
  ngOnInit(): void {
    this.pSrv.getAllProducts().subscribe({
      next:(products)=>{
        this.listproducts=products;
        console.log("produits"+this.listproducts);
      },
      error:(err)=>{
        console.log("erreur recupération des produits");
      }
    });
    this.cSrv.getAllCategories().subscribe((categories)=>{
      this.categories=categories;
    });

    
    this.pSrv.getAllFetchCat().subscribe((p)=>{
      this.allproducts=p;
    });


    //ROLE
    const userConnected=sessionStorage.getItem('user');
    if(userConnected){
      const user:User=JSON.parse(userConnected);
      this.role=""+user.role;
      console.log("role = "+user.role);
    }
    

  }

  

  showFilterMenu(){
    this.showFilter=!this.showFilter;
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
  
  loadAllProduct(){
    this.pSrv.getAllProducts().subscribe({
      next:(products)=>{
        this.listproducts=products;
        console.log("produits"+this.listproducts);
      },
      error:(err)=>{
        console.log("erreur recupération des produits");
      }
    });
  }

  loadProduct(){
    this.pSrv.getTitle(this.title).subscribe((products:Product[])=>{
      this.listproducts=products;
    })
    
  }
  loadProductFilter(){
    if(this.value===1){
      this.pSrv.getPrice(5,10).subscribe((products)=>{
        this.listproducts=products;
      });

    }
    if(this.value===2){
      this.pSrv.getPrice(10,15).subscribe((products)=>{
        this.listproducts=products;
      });
  }
  if(this.value===3){
    this.pSrv.getPrice(15,50).subscribe((products)=>{
      this.listproducts=products;
    });
  }

}

loadProductBase(event:any){
  
  if(event.target.value=='tomate'){
    let name='tomates';
    this.ingSrv.getByName(name).subscribe((ingredient)=>{
      this.listproducts=ingredient.produits;
     
    });
  }
  if(event.target.value=='creme'){
    let name='Creme Fraiche';
    this.ingSrv.getByName(name).subscribe((ingredient)=>{
      this.listproducts=ingredient.produits;
    });
  }
}


loadProductTag(categoryId:number,event:any){
  console.log(categoryId);
  if(event.target.checked){
    if(!this.tagId.includes(categoryId)){
    this.tagId.push(categoryId);
    console.log(this.tagId);
    }
  }else{
    this.tagId=this.tagId.filter(id=>id!==categoryId);
    console.log(this.tagId);
    }
    this.filteredProducts();
}

filteredProducts(){
  if(this.tagId.length>0){
    this.productFiltered=this.allproducts.filter(p=>this.tagId.every(selectedId=>p.categories?.map(c=>c.id).includes(selectedId)));
    console.log(this.listproducts);
    this.listproducts=this.productFiltered;
  }else 
  {
    this.listproducts=this.allproducts;
  }

}

//supprimer un produit 
deleteProduct(event:any){
  let id=event.target.value;
  this.openDialog
  if(id){
    // this.pSrv.deleteById(id).subscribe(result=>{
    //   console.log("Product deleted");
    // })
    console.log("removing product "+id);
  }
  
}

openDialog(enterAnimationDuration:string,exitAnimationDuration:string){
  const dialogRef=this.dialog.open(DeleteProductModalComponent,{
    width:'400px',
    enterAnimationDuration,
    exitAnimationDuration,
  });
  
  dialogRef.afterClosed().subscribe(result=>{
    console.log("fermeture du dialog");
  });

}

}