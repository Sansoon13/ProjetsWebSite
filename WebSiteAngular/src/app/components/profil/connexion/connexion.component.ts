import { Component } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-connexion',
  templateUrl: './connexion.component.html',
  styleUrls: ['./connexion.component.css']
})
export class ConnexionComponent {
  formulaireCo!:FormGroup;

  constructor(private router:Router){}

  register(){
    this.router.navigateByUrl('/register');
  }

}
