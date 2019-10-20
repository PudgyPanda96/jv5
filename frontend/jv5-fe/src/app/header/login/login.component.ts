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
  success = false;


  constructor(private formBuilder: FormBuilder, private sessionService: SessionService, private userService:  UserService) { }

  ngOnInit() {
    this.messageForm = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    });
  }

  login() {
    console.log('clicked');
    this.userService.loginUser(this.messageForm.controls.username.value, this.messageForm.controls.password.value).subscribe((data: User) => {
      console.log(data)
      this.userService.setCurrentUser(data)
    });
    this.sessionService.setRegistering(false)
    this.sessionService.setLoggedIn(true);
    this.sessionService.setLoggingIn(false);
  }

  register() {
    this.sessionService.setRegistering(true);
  }

  onSubmit() {
    this.submitted = true;

    if (this.messageForm.invalid) {
      return;
    }
    this.success = true;
  }

}
