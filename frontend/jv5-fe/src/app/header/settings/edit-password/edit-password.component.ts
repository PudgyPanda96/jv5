import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { SettingsService } from 'src/app/services/settings.service';
import { User } from 'src/app/models/User';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-edit-password',
  templateUrl: './edit-password.component.html',
  styleUrls: ['./edit-password.component.css']
})
export class EditPasswordComponent implements OnInit {

  newPassword: string = "";
  confirmPassword: string = "";
  password: string = "";
  PasswordMatch: boolean;

  constructor(private userService: UserService, private settingsService: SettingsService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit() {
  }

  verifyPasswordChange() {
    if (this.checkPasswordMatch()) {
      this.PasswordMatch = true;
      var user: User = this.userService.getCurrentUser();
      // user.setPassword(this.password);
      user.setPassword(this.password);
      this.userService.verifyUser(user).subscribe(
        (data: any) => {
          this.changePassword()
        },
        error => {
          console.log(error.status)
          if (error.status == '401') {
            //this will happen if the user inputted the wrong password
          }
          else {
            //this will happen if the server failed
          }
        }
      )
    } else {
      this.PasswordMatch = false;
    }

  }

  checkPasswordMatch() {
    if (this.newPassword !== this.confirmPassword) {
      console.log("broked");
      return false;
    }
    return true;
  }

  changePassword() {
    this.settingsService.changePassword(this.userService.getCurrentUser().getEmail(), this.password, this.newPassword)
      .subscribe((data: User) => {
        console.log(data);
        this.router.navigate(['home']);
      })
  }

  cancel() {
    this.router.navigate(['settings']);
  }

}
