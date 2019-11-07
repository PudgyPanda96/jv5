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
      var user: User = this.fillUserData(data);
      this.setUserInfo(user)
    });
  }

  fillUserData(data) {
    console.log(data);
    var user: User = new User();
    user.setEmail(data['email'])
    user.setFirstName(data['firstName'])
    user.setLastName(data['lastName']);
    user.setPassword(data['password']);
    user.setState(data['state']);
    user.setUserId(data['userId']);
    user.setCity(data['city']);
    user.setCountry(data['country']);
    user.setAlias(data['alias']);
    return user;
  }
  
  setUserInfo(user: User) {
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
    this.userService.setCurrentUser(user);
  }

  register() {
    this.sessionService.setRegistering(true);
  }
}
