import { animate, state, style, transition, trigger } from '@angular/animations';
import { Component } from '@angular/core';
import { Router } from '@angular/router';

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



  
}
