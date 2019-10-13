import { Injectable } from '@angular/core';
import { HttpClient, HttpClientModule, HttpHeaders } from '@angular/common/http';
import { User } from '../models/User';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  
  url = "http://localhost:8080/api/users/";
  currentUser: User;

  constructor(private http: HttpClient) { }

  registerUser(user: User) {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
        'Authorization': 'Basic anY1X3N5c2FkbWluOnAzbnIwczM='
      })
    };
    return this.http.post<any>(this.url + "registerUser/", user, httpOptions);
  }

  loginUser(username: string, password: string) {
    let u = new Map();
    u.set(username, password);

    return this.http.post<User>(this.url + "loginUser", u);
  }

  setCurrentUser(user: User) {
    this.currentUser = user;
  }
}
