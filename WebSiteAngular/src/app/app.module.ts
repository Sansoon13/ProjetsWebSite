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
    ConnexionComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule  
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
