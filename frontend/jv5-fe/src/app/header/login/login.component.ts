import { Component, OnInit } from '@angular/core';
import { Validators, FormGroup, FormBuilder } from '@angular/forms';
import { SessionService } from 'src/app/services/session.service';
import { UserService } from 'src/app/services/user.service';
import { User } from 'src/app/models/User';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  messageForm: FormGroup;
  submitted = false;
  success = true;


  constructor(private formBuilder: FormBuilder, private sessionService: SessionService, private userService: UserService) { }

  ngOnInit() {
    this.messageForm = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    });
  }

  login() {
    this.submitted = true;
    this.userService.loginUser
    (this.messageForm.controls.username.value, this.messageForm.controls.password.value).subscribe((data: User) => {
      console.log(data);
      var tempUser: User = data;
      this.userService.setCurrentUser(tempUser);
      this.setUserInfo()
    });
  }
  
  setUserInfo() {
    if (this.messageForm.invalid) {
      return;
    }

    console.log(this.userService.getCurrentUser());
    if (this.userService.getCurrentUser() == null) {
      console.log('FAILED');
      this.success = false;
      //return;
    }

    this.sessionService.setRegistering(false);
    this.sessionService.setLoggedIn(true);
    this.sessionService.setLoggingIn(false);
  }

  register() {
    this.sessionService.setRegistering(true);
  }
}
