import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ShoppingItemComponent } from './shopping-item/shopping-item.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { ProductListComponent } from './product-list/product-list.component';

const routes: Routes = [
  {path: 'home',component:HomeComponent},
  {path: 'login',component:LoginComponent},
  {path: 'item',component:ShoppingItemComponent},
  {path: 'products',component:ProductListComponent},
  {path: 'logout',component:LogoutComponent}
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
