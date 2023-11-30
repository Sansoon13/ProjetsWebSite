import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-connexion',
  templateUrl: './connexion.component.html',
  styleUrls: ['./connexion.component.css']
})
export class ConnexionComponent implements OnInit{
  formulaireCo!:FormGroup;


  constructor(private router:Router, private userSrv:UserService){}

  ngOnInit(): void {
    this.formulaireCo=new FormGroup({
        username:new FormControl("",Validators.required),
        password:new FormControl("",Validators.required),
    });
  }
 
  register(){
    this.router.navigateByUrl('/register');
  }

  connect(){
    if(this.formulaireCo.valid){
      const usernameVal=this.formulaireCo.value.username;
      const passwordVal=this.formulaireCo.value.password;
      if(usernameVal && passwordVal){
        this.userSrv.connect(usernameVal,passwordVal).subscribe((data)=>{
          console.log("connexion reussi");
          
          let id=data.id;
          let token=data.accessToken
          sessionStorage.setItem('token',token);
          this.userSrv.getById(id).subscribe((user)=>{
            
            sessionStorage.setItem('user',JSON.stringify(user));
          })

          this.router.navigateByUrl('/profil');
          
        })
      }
    }
  }

}
