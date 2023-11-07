import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Ingredient } from '../model/ingredient';
import { Observable } from 'rxjs';
import { urlApi } from '../env';

@Injectable({
  providedIn: 'root'
})
export class IngredientService {
  url=urlApi+'/ingredient';
  constructor(private httpClient:HttpClient) { }

  getById(id:number): Observable<Ingredient>{
    return this.httpClient.get<Ingredient>(this.url+`/${id}`);
  }

  getByName(name:string): Observable<Ingredient>{
    return this.httpClient.get<Ingredient>(this.url+`/base/${name}`);
  }

}
