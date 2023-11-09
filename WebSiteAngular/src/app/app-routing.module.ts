import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { ProductComponent } from './components/products/product/product.component';
import { InfoComponent } from './components/about/info/info.component';
import { ConnexionComponent } from './components/profil/connexion/connexion.component';
import { RegisterComponent } from './components/profil/register/register.component';

const routes: Routes = [
  {path:'home',component:HomeComponent},
  {path:'product',component:ProductComponent},
  {path:'about',component:InfoComponent},
  {path:'login',component:ConnexionComponent},
  {path:'register',component:RegisterComponent},
  {path: '', redirectTo: '/home', pathMatch: 'full'},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { 
  

}
