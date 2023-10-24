import { animate, state, style, transition, trigger } from '@angular/animations';
import { Component } from '@angular/core';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css'],
  
})
export class MenuComponent {
  status= false;
  openMenu(){
    this.status =!this.status;
  }
  closeMenu(){
    this.status =false;
  }




  
}
