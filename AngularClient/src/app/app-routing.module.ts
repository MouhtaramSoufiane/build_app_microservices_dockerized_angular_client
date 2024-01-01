import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ReservationsComponent } from './components/reservations/reservations.component';
import { RessourcesComponent } from './components/ressources/ressources.component';
import { PersonnesComponent } from './components/personnes/personnes.component';
import {HomeComponent} from "./components/home/home.component";
import { AuthGuard } from './guards/authentication.guard';

const routes: Routes = [
  // {
  //   path:"/",component:HomeComponent
  // },
  {
    path:"reservations",component:ReservationsComponent,canActivate:[AuthGuard]
  },
  {
    path:"ressources/:id",component:RessourcesComponent,canActivate:[AuthGuard]
  },
  {
    path:"ressources",component:RessourcesComponent,data:{roles:["ADMIN"]},canActivate:[AuthGuard]
  },
  {
    path:"personnes",component:PersonnesComponent,data:{roles:["ADMIN"]},canActivate:[AuthGuard]
  },
  {
    path:"reservations/personnes/:id",component:ReservationsComponent,canActivate:[AuthGuard]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
