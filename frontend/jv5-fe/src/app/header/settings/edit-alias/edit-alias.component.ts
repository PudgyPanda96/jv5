import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { User } from 'src/app/models/User';
import { HttpErrorResponse } from '@angular/common/http';
import { throwError } from 'rxjs';

@Component({
  selector: 'app-edit-alias',
  templateUrl: './edit-alias.component.html',
  styleUrls: ['./edit-alias.component.css']
})
export class EditAliasComponent implements OnInit {

  newAlias: string = "";
  confirmAlias: string = "";
  password: string = "";

  constructor(private userService: UserService) { }

  ngOnInit() {

  }

  changeAlias() {
    console.log(this.password);
    console.log(this.changeAlias);
    console.log(this.confirmAlias);
    var user: User = this.userService.getCurrentUser();
    // user.setPassword(this.password);
    user.setPassword("dsfsaft");
    this.userService.verifyUser(user).subscribe(
      (data: any) => {
        console.log("we did it :D");
    },
      error => console.log(error.status)
    )
    
  }
  private handleError(error: HttpErrorResponse) {
    if (error.error instanceof ErrorEvent) {
      // A client-side or network error occurred. Handle it accordingly.
      console.error('An error occurred:', error.error.message);
    } else {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong,
      console.error(
        `Backend returned code ${error.status}, ` +
        `body was: ${error.error}`);
    }
    // return an observable with a user-facing error message
    return throwError(
      'Something bad happened; please try again later.');
  };


  setNewAlias(event) {
    console.log(event);
    this.newAlias = this.newAlias + event.key
    console.log(this.newAlias);
  }

  setConfirmAlias(event) {

  }

  setPassword(event) {

  }



}
