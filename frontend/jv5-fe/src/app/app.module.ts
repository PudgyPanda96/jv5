import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { HeaderComponent } from './header/header.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

//form stuff
import { FormsModule, ReactiveFormsModule }   from '@angular/forms';

//shared module imports
import { SharedModule } from './shared/shared-module';
import { LoginComponent } from './header/login/login.component';
import { RegisterComponent } from './header/register/register.component';
import { FooterComponent } from './footer/footer.component';
import { ProfileComponent } from './profile/profile/profile.component';
import { SettingsComponent } from './header/settings/settings.component';
import { EditEmailComponent } from './header/settings/edit-email/edit-email.component';
import { EditAliasComponent } from './header/settings/edit-alias/edit-alias.component';
import { EditPasswordComponent } from './header/settings/edit-password/edit-password.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HeaderComponent,
    LoginComponent,
    RegisterComponent,
    FooterComponent,
    ProfileComponent,
    SettingsComponent,
    EditEmailComponent,
    EditAliasComponent,
    EditPasswordComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    SharedModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
