import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './header/login/login.component';
import { RegisterComponent } from './header/register/register.component';
import { ProfileComponent } from './profile/profile/profile.component';
import { SettingsComponent } from './header/settings/settings.component';
import { EditEmailComponent } from './header/settings/edit-email/edit-email.component';
import { EditAliasComponent } from './header/settings/edit-alias/edit-alias.component';
import { EditPasswordComponent } from './header/settings/edit-password/edit-password.component';

const routes: Routes = [
  {
    path: 'home',
    component: HomeComponent
  },
  { path: '',
    redirectTo: 'home',
    pathMatch: 'full',
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'register',
    component: RegisterComponent
   },
   {
     path: 'settings',
     component: SettingsComponent
   },
  {
    path: 'profile',
    component: ProfileComponent
  },
  {
    path: 'EditEmail',
    component: EditEmailComponent
  },
  {
    path: 'EditAlias',
    component: EditAliasComponent
  },
  {
    path: 'EditPassword',
    component: EditPasswordComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
