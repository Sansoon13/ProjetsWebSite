import { Injectable } from '@angular/core';
import { Router, UrlTree } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class ConnectGuardServiceService {

  constructor(private router:Router) { }

  canActivate():boolean | UrlTree {
    if(sessionStorage.getItem('token')){
      return true;
    }
    return this.router.createUrlTree(['/login']);
  }
}
