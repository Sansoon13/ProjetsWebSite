import { animate, state, style, transition, trigger } from '@angular/animations';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/model/user';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css'],
  
})
export class MenuComponent {
  activeFilter: string = 'home';
  status= false;

  constructor(private router: Router) { }

  openMenu(){
    this.status =!this.status;
  }
  closeMenu(){
    this.status =false;
  }

  setActiveFilter(routerName: string):boolean {
    return this.router.url.includes(routerName)
    
}

loginOrProfil(){
  const userConnected=sessionStorage.getItem('user');
  if(userConnected){
    const user:User=JSON.parse(userConnected);
    console.log("user connecté "+user.username);
    this.router.navigateByUrl('/profil');
  }else{
    console.log("user non connecté");
    this.router.navigateByUrl('/login');
  }
  
}


  
}
