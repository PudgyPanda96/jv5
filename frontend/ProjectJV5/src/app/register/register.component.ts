import { Component, OnInit } from '@angular/core';
import { User } from '../models/User';
import { UserService } from '../services/user.service';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  user: User = new User();

  constructor(private userService: UserService) { }

  ngOnInit() { }

  setRegisteredUser() {
    this.userService.registerUser(this.user).subscribe((data: any) => {
      console.log(data);
      this.userService.setCurrentUser(this.user);
    });
  }
}
