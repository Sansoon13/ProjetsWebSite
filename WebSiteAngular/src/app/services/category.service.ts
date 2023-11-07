import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { urlApi } from '../env';
import { Observable } from 'rxjs';
import { Category } from '../model/category';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  url=urlApi+'/categories';
  constructor(private httpClient:HttpClient) { }


  getAllCategories():Observable<Category[]>{
    return this.httpClient.get<Category[]>(this.url+"/all");
  }
  
  getByTitle(title:string):Observable<Category>{
    return this.httpClient.get<Category>(this.url+`/title/${title}`);
  }

  getByIdWithProduct(id:number):Observable<Category>{
    return this.httpClient.get<Category>(this.url+`/id/${id}`);
  }


}
