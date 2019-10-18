import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  url = "http://restcountries.eu/rest/v2/all";

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json: charset=utf-8',
      'Access-Control-Allow-Origin': '*',
      "Access-Control-Allow_methods": "POST,GET,PUT,DELETE",
     })
  };

  constructor(private http: HttpClient ) { }

  getAllCountries() {
    return this.http.get<any[]>(this.url);
  }

  getAllStates() {
    // return this.http.get<any[]>("https://api.printful.com/countries");
    return ['Alabama','Alaska','American Samoa','Arizona','Arkansas','California','Colorado','Connecticut','Delaware','District of Columbia','Federated States of Micronesia','Florida','Georgia','Guam','Hawaii','Idaho','Illinois','Indiana','Iowa','Kansas','Kentucky','Louisiana','Maine','Marshall Islands','Maryland','Massachusetts','Michigan','Minnesota','Mississippi','Missouri','Montana','Nebraska','Nevada','New Hampshire','New Jersey','New Mexico','New York','North Carolina','North Dakota','Northern Mariana Islands','Ohio','Oklahoma','Oregon','Palau','Pennsylvania','Puerto Rico','Rhode Island','South Carolina','South Dakota','Tennessee','Texas','Utah','Vermont','Virgin Island','Virginia','Washington','West Virginia','Wisconsin','Wyoming'];

  }

}
