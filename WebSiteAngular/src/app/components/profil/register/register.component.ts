import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/model/user';
import { UserService } from 'src/app/services/user.service';
import { InscriptionValidator } from 'src/app/validations/inscriptionValidator';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  formulaireReg!:FormGroup;
  user!:User;
  constructor(private router:Router, private userSrv:UserService){

  }
  ngOnInit(): void {
    this.formulaireReg=new FormGroup({
      firstName:new FormControl("",Validators.required),
      lastName:new FormControl("",Validators.required),
      username:new FormControl("",Validators.required),
      email:new FormControl("",Validators.required),
      groupPassword:new FormGroup({
        password:new FormControl("",Validators.required),
        password2:new FormControl("",Validators.required)
      },InscriptionValidator.passwordConfirmer)
      

    })
    

  }

  signUp(){
    this.router.navigateByUrl('/login');
  }

  register(){
    if(this.formulaireReg){
      this.user.username=this.formulaireReg.get('username')?.value;
      this.user.firstName=this.formulaireReg.get('firstName')?.value;
      this.user.lastName=this.formulaireReg.get('lastName')?.value;
      this.user.email=this.formulaireReg.get('email')?.value;

      this.userSrv.register(this.user,this.formulaireReg.get('password')?.value).subscribe((data)=>{
        console.log("inscription réussi");
        this.router.navigateByUrl('/login');
      })
    }
  }
}
