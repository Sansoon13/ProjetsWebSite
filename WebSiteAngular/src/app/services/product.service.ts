import { Injectable } from '@angular/core';
import { urlApi } from '../env';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product } from '../model/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  url:string=urlApi+'/product';

  constructor(private httpClient:HttpClient) { }

  getById(id:number): Observable<Product>{
    return this.httpClient.get<Product>(this.url+`/${id}`);
  }

  getAllProducts(): Observable<Product[]>{
    return this.httpClient.get<Product[]>(this.url+'/all');
  }

  getByIdWithIngredients(id:number): Observable<Product>{
    return this.httpClient.get<Product>(this.url+`/ingredients/${id}`);
  }
  getByIdWithCategories(id:number): Observable<Product>{
    return this.httpClient.get<Product>(this.url+`/categories/${id}`);
  }
  getByIdWithEvaluations(id:number): Observable<Product>{
    return this.httpClient.get<Product>(this.url+`/evaluations/${id}`);
  }

  getAllFetchCat():Observable<Product[]>{
    return this.httpClient.get<Product[]>(this.url+`/all/cat`);
  }

  //Title
  getTitle(title:string): Observable<Product[]>{
    console.log("title = "+title);
    let newtitle=title.toUpperCase();
    return this.httpClient.get<Product[]>(this.url+`/title:${title}`);
  }

  //price 
  getPrice(priceLow:number, priceHigh:number): Observable<Product[]>{
    return this.httpClient.get<Product[]>(this.url+`/price/${priceLow}/${priceHigh}`);
  }
 
  //Rating : 
  public percentavgRating(rating:number):number{
    let a=Math.trunc(rating);
    let b=rating-a;
    let percent=a*20+this.percentOfDecimal(b);
    return percent;
  }

  public percentOfDecimal(decimal:number):number{
    let l=1/(1/3-0.5+0.5**2);
    return(20*((1/3)*decimal**3-(1/2)*decimal**2+l*0.5**2*decimal));
  }
}
