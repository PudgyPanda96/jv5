import { Component, OnInit } from '@angular/core';
import { SessionService } from '../services/session.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  showLogin: boolean = false;
  showRegister: boolean = false;
  constructor(private sessionService: SessionService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit() {
    console.log("reee")
  }

  login() {
    this.showLogin = true;
  }

  register() {
    this.sessionService.setRegistering(true);
    this.showLogin = false;
    this.router.navigate(['register'], { relativeTo: this.route });
  }

}
