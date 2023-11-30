import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../model/user';
import { urlApi } from '../env';
import { Authentication } from '../model/authentication';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  url=urlApi+'/user'
  constructor(private httpClient:HttpClient) { }

  connect(username:string,password:string){
    return this.httpClient.post<Authentication>(urlApi+'/v1/auth'+'/login',{username,password});
  }

  register(user:User,password:string):Observable<any>{
    let body=this.userToJson(user);
    return this.httpClient.post<Authentication>(urlApi+'/v1/auth'+'/register',{user});
  }

  getById(id:number):Observable<User>{
    return this.httpClient.get<User>(this.url+`/${id}`);
  }
  
  userToJson(user:User){
    return{
      username:user.username,
      email:user.email,
      firstName:user.firstName,
      lastName:user.lastName,
      dateEntry:user.dateEntry,
      role:user.role,
      adresse:user.addresse,


    }
  }

}
