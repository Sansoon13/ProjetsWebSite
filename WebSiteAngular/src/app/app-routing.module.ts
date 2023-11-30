import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { ProductComponent } from './components/products/product/product.component';
import { InfoComponent } from './components/about/info/info.component';
import { ConnexionComponent } from './components/profil/connexion/connexion.component';
import { RegisterComponent } from './components/profil/register/register.component';
import { ProfilComponent } from './components/profil/profil/profil.component';
import { connect } from 'rxjs';
import { ConnectGuardServiceService } from './services/connect-guard-service.service';

const routes: Routes = [
  {path:'home',component:HomeComponent},
  {path:'product',component:ProductComponent},
  {path:'about',component:InfoComponent},
  {path:'login',component:ConnexionComponent},
  {path:'register',component:RegisterComponent},
  {path:'profil',component:ProfilComponent,canActivate:[ConnectGuardServiceService]},
  {path: '', redirectTo: '/home', pathMatch: 'full'},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { 
  

}
