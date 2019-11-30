import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { User } from 'src/app/models/User';
import { HttpErrorResponse } from '@angular/common/http';
import { throwError } from 'rxjs';
import { SettingsService } from 'src/app/services/settings.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-edit-alias',
  templateUrl: './edit-alias.component.html',
  styleUrls: ['./edit-alias.component.css']
})
export class EditAliasComponent implements OnInit {

  newAlias: string = "";
  confirmAlias: string = "";
  password: string = "";
  aliasMatch: boolean;

  constructor(private userService: UserService, private settingsService: SettingsService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit() {

  }

  verifyAliasChange() {
    if (this.checkAliasMatch()) {
      this.aliasMatch = true;
      var user: User = this.userService.getCurrentUser();
      // user.setPassword(this.password);
      user.setPassword(this.password);
      this.userService.verifyUser(user).subscribe(
        (data: any) => {
          this.changeAlias()
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
      this.aliasMatch = false;
    }

  }

  checkAliasMatch() {
    if (this.newAlias !== this.confirmAlias) {
      console.log("broked");
      return false;
    }
    return true;
  }

  changeAlias() {
    this.settingsService.changeAlias(this.userService.getCurrentUser().getEmail(), this.password, this.newAlias)
      .subscribe((data: User) => {
        console.log(data);
        this.router.navigate(['home']);
      })
  }

  cancel() {
    console.log("test")
    this.router.navigate(['/settings']);
  }

}
