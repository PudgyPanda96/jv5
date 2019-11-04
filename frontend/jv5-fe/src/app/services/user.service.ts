import { Injectable } from '@angular/core';
import { User } from '../models/User';

import { HttpHeaders, HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  url = "http://localhost:8080/api/user/";
  settingsUrl = "http://localhost:8080/api/settings/delete/"
  private currentUser: User;

  constructor(private http: HttpClient) { }

  httpOptions  = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json',
      'Authorization': 'Basic anY1X3N5c2FkbWluOnAzbnIwczM='
    })
  };


  registerUser(user: User) {
    return this.http.post<any>(this.url + "registerUser", user, this.httpOptions);
  }

  loginUser(email: string, password: string) {
    let u = new Map();
    //u.set(username, password);
    var user: User = new User();
    user.setEmail(email);
    user.setPassword(password);

    return this.http.post<User>(this.url + "loginUser", user);
  }

  deleteUser(user: User) {
    return this.http.delete<any>(this.settingsUrl + user['userId'], this.httpOptions);
  }

  setCurrentUser(user: User) {
    this.currentUser = user;
  }

  getCurrentUser() {
    return this.currentUser;
  }
}
