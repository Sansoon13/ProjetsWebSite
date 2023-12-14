import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MenuComponent } from './components/menu/menu.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HomeComponent } from './components/home/home.component';
import { ProductComponent } from './components/products/product/product.component';
import {HttpClientModule} from '@angular/common/http';
import { ProductInfoComponent } from './components/products/product-info/product-info.component';
import { InfoComponent } from './components/about/info/info.component';
import { IngredientComponent } from './components/ingredients/ingredient/ingredient.component';
import { CarouselComponent } from './components/home/carousel/carousel.component';
import { ConnexionComponent } from './components/profil/connexion/connexion.component';
import { RegisterComponent } from './components/profil/register/register.component';
import { ProfilComponent } from './components/profil/profil/profil.component';
import { DeleteProductModalComponent } from './components/modal/delete-product-modal/delete-product-modal.component';
import {MatDialogModule} from '@angular/material/dialog';
import { ConfirmationSuppressionModalComponent } from './modal/confirmation-suppression-modal/confirmation-suppression-modal.component';
import { EditProductModalComponent } from './components/modal/edit-product-modal/edit-product-modal.component';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    HomeComponent,
    ProductComponent,
    ProductInfoComponent,
    InfoComponent,
    IngredientComponent,
    CarouselComponent,
    ConnexionComponent,
    RegisterComponent,
    ProfilComponent,
    DeleteProductModalComponent,
    ConfirmationSuppressionModalComponent,
    EditProductModalComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    MatDialogModule,
    MatFormFieldModule, 
    MatInputModule, 
   
    
    

    
    
      
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
