import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  sampleText = 'this is test data';
  edit = false;

  constructor() { }

  ngOnInit() {
    // check whos logged in through session service
    // compare user with which profile you are viewing

  }

  editText() {

    this.sampleText = NewText
  }
}
