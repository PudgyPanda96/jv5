import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { SettingsService } from 'src/app/services/settings.service';
import { User } from 'src/app/models/User';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-edit-email',
  templateUrl: './edit-email.component.html',
  styleUrls: ['./edit-email.component.css']
})
export class EditEmailComponent implements OnInit {

  newEmail: string = "";
  confirmEmail: string = "";
  password: string = "";
  emailMatch: boolean;

  constructor(private userService: UserService, private settingsService: SettingsService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit() {
  }

  verifyEmailChange() {
    if (this.checkEmailMatch()) {
      this.emailMatch = true;
      var user: User = this.userService.getCurrentUser();
      // user.setPassword(this.password);
      user.setPassword(this.password);
      this.userService.verifyUser(user).subscribe(
        (data: any) => {
          this.changeEmail()
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
      this.emailMatch = false;
    }

  }

  checkEmailMatch() {
    if (this.newEmail !== this.confirmEmail) {
      console.log("broked");
      return false;
    }
    return true;
  }

  changeEmail() {
    console.log("test");
    this.settingsService.changeEmail(this.userService.getCurrentUser().getEmail(), this.password, this.newEmail)
      .subscribe((data: User) => {
        console.log(data);
        this.router.navigate(['home']);
      })
  }

  cancel() {
    this.router.navigate(['settings']);
  }

}
