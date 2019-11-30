import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { SessionService } from 'src/app/services/session.service';
import { Router } from '@angular/router';
import { User } from 'src/app/models/User';
import { SettingsService } from 'src/app/services/settings.service';

@Component({
  selector: 'app-settings',
  templateUrl: './settings.component.html',
  styleUrls: ['./settings.component.css']
})
export class SettingsComponent implements OnInit {

  password: string;
  alias: string;
  email: string;
  delete: boolean;
  confirmedPassword: string;
  constructor(private userService: UserService, private sessionService: SessionService, private router: Router, private settingsService: SettingsService) { }

  ngOnInit() {
    console.log(this.userService.getCurrentUser());
  }

  showDelete() {
    this.delete = true;
    // this.userService.deleteUser(this.userService.getCurrentUser()).subscribe((data: any) => {
    //   console.log(data);
    //   this.setSessionInfo()
    // })
  }

  verifyAccount() {
    var user: User = this.userService.getCurrentUser();
    user.setPassword(this.confirmedPassword);
    this.userService.verifyUser(user).subscribe((data: any) => {
      this.deleteAccount();
    },
    error => {
      console.log(error.status)
      if (error.status == '401') {
        //this will happen if the user inputted the wrong password
      }
      else {
        //this will happen if the server failed
      }
    })

  }

  deleteAccount() {
    this.settingsService.deleteUser(this.userService.getCurrentUser()).subscribe((data: any) => {
      console.log("user deleted");
      this.setSessionInfo();
    })
  }
  setSessionInfo() {
    this.userService.setCurrentUser(null);
    this.sessionService.setLoggedIn(false);
    this.router.navigate(['home']);
  }

  // updateEmail() {

  // }

  // updatePassword() {

  // }

  // updateAlias() {

  // }
}
