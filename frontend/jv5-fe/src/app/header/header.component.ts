import { Component, OnInit } from '@angular/core';
import { SessionService } from '../services/session.service';
import { Router, ActivatedRoute } from '@angular/router';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  showLogin = false;
  showRegister = false;
  constructor(private sessionService: SessionService, private router: Router, private route: ActivatedRoute, private userService: UserService) { }

  ngOnInit() {

  }

  login() {
    this.sessionService.setLoggingIn(true);
    // this.showLogin = true;
  }

  register() {
    this.sessionService.setRegistering(true);
    this.showLogin = false;
    this.router.navigate(['register'], { relativeTo: this.route });
  }

  signOut() {
    this.userService.setCurrentUser(null);
    this.sessionService.setLoggedIn(false);
  }

}
