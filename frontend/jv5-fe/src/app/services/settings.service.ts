import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { User } from '../models/User';

@Injectable({
  providedIn: 'root'
})
export class SettingsService {

  constructor(private http: HttpClient) { }

  url: string = "http://localhost:8080/api/settings/"

  httpOptions  = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json',
      'Authorization': 'Basic anY1X3N5c2FkbWluOnAzbnIwczM=',
      'Access-Control-Allow-Origin': '*'
    })
  };

  changeAlias(email: string, password: string, newAlias: string) {
    var changeAliasUrl = this.url + "changeAlias?email=" + email + "&password=" + password + "&newAlias=" + newAlias;
    return this.http.put<User>(changeAliasUrl, null);
  }

  changePassword(email: string, password: string, newPassword: string) {
    var changePasswordUrl = this.url + "changePassword?email=" + email + "&password=" + password + "&newPassword=" + newPassword;
    return this.http.put<User>(changePasswordUrl, null);
  }

  changeEmail(email: string, password: string, newEmail: string) {
    var changeEmailUrl = this.url + "changeEmail?email=" + email + "&password=" + password + "&newEmail=" + newEmail;
    return this.http.put<User>(changeEmailUrl, null);
  }

  deleteUser(user: User) {
    var deleteUrl = this.url + "delete?email=" + user.getEmail() + "&password=" + user.getPassword();
    return this.http.delete<any>(deleteUrl, this.httpOptions);
  }
}
