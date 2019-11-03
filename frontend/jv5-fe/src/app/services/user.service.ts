import { Injectable } from '@angular/core';
import { User } from '../models/User';

import { HttpHeaders, HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  url = "http://localhost:8080/api/users/";
  private currentUser: User;

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

  loginUser(email: string, password: string) {
    let u = new Map();
    //u.set(username, password);
    var user: User = new User();
    user.setEmail(email);
    user.setPassword(password);

    return this.http.post<User>(this.url + "loginUser", user);
  }

  setCurrentUser(user: User) {
    this.currentUser = user;
  }

  getCurrentUser() {
    return this.currentUser;
  }
}
