import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { AgendaFormComponent } from './agenda-form/agenda-form.component';
import { LoginComponent } from './login/login.component';



const routes: Routes = [


  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'agenda/form', component: AgendaFormComponent},
  { path: 'agenda/form/:id', component: AgendaFormComponent},
  { path: 'login', component: LoginComponent},

];


@NgModule({
  imports: [
    CommonModule,
    RouterModule.forRoot(routes),

  ],
  exports: [ RouterModule ],
  declarations: []
})
export class AppRoutingModule { }
