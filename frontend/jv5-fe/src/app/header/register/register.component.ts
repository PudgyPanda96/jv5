import { Component, OnInit } from '@angular/core';
import { RegisterService } from 'src/app/services/register.service';
import { UserService } from 'src/app/services/user.service';
import { User } from 'src/app/models/User';
import { Router, ActivatedRoute } from '@angular/router';
import { SessionService } from 'src/app/services/session.service';

export interface Countries {
  name: string;
  value: string;
}

export interface States {
  code: string;
  name: string;
}

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user: User = new User();
  selectedCountry: String;
  countries: Countries[] = [];
  states: States[] = [];
  showStatesNCities: boolean = false;

  constructor(private registerService: RegisterService, private userService: UserService, private router: Router, private route: ActivatedRoute, private sessionService: SessionService) { }

  ngOnInit() {
    this.registerService.getAllCountries().subscribe((data: any[]) => {
      console.log(data)
      this.populateCountryTable(data);
    });

    this.populateStateTable(this.registerService.getAllStates());
  }

  populateCountryTable(data: any[]) {
    for (let num in data) {
      var tempCountry: Countries = {
        name: data[num]['name'],
        value: data[num]['name']
      }
      this.countries.push(tempCountry);
    }
  }

  populateStateTable(data) {
    for (let s in data) {
      console.log(data[s]);
      var tempState: States = {
        name: data[s],
        code: data[s]
      }
      this.states.push(tempState);
    }
  }

  selectCountry(countryName: string) {
    this.user.country = countryName;
    if (countryName == "United States of America") {
      this.showStatesNCities = true;
    }
    else {
      this.showStatesNCities = false;
      this.user.state = null;
      this.user.city = null;
    }
  }

  selectState(stateName: string) {
    this.user.state = stateName
  }

  registerUser() {
    this.userService.registerUser(this.user).subscribe((data: any) => {
      console.log(data);
      this.userService.setCurrentUser(this.user);
    });
    this.sessionService.setRegistering(false)
    this.sessionService.setLoggedIn(true);
    this.router.navigate(['home']);
  }

  cancel() {
    this.sessionService.setRegistering(false);
    this.router.navigate(['home']);
  }

}
