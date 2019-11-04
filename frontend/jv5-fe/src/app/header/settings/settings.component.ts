import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { SessionService } from 'src/app/services/session.service';
import { Router } from '@angular/router';
import { User } from 'src/app/models/User';

@Component({
  selector: 'app-settings',
  templateUrl: './settings.component.html',
  styleUrls: ['./settings.component.css']
})
export class SettingsComponent implements OnInit {
  
  password: string;
  alias: string;
  email: string;
  constructor(private userService: UserService, private sessionService: SessionService, private router: Router) { }

  ngOnInit() {
   console.log(this.userService.getCurrentUser());
  }

  deleteAccount() {
    this.userService.deleteUser(this.userService.getCurrentUser()).subscribe((data: any) => {
      console.log(data);
      this.setSessionInfo()
    })
  }

  setSessionInfo() {
    this.userService.setCurrentUser(null);
    this.sessionService.setLoggedIn(false);
    this.router.navigate(['home']);
  }

  updateEmail() {

  }

  updatePassword() {

  }

  updateAlias() {
    
  }
}
