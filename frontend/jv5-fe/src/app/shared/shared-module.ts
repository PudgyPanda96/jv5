import { NgModule } from '@angular/core';
import { MatToolbarModule, MatIconModule, MatSidenavModule, MatListModule, MatButtonModule } from  '@angular/material';
import {VirtualScrollerModule} from 'primeng/virtualscroller';
import {DropdownModule} from 'primeng/dropdown';
import {MatSelectModule} from '@angular/material/select';
import {DialogModule} from 'primeng/dialog';
import {MatInputModule} from '@angular/material/input';
import {InputTextModule} from 'primeng/inputtext';
import {MatMenuModule} from '@angular/material/menu';


@NgModule({
    imports: [
        MatToolbarModule,
        MatIconModule,
        MatSidenavModule,
        MatListModule,
        MatButtonModule,
        VirtualScrollerModule,
        DropdownModule,
        MatSelectModule,
        DialogModule,
        MatInputModule,
        InputTextModule,
        MatMenuModule
],
    exports: [
        MatToolbarModule,
        MatIconModule,
        MatSidenavModule,
        MatListModule,
        MatButtonModule,
        VirtualScrollerModule,
        DropdownModule,
        MatSelectModule,
        DialogModule,
        MatInputModule,
        InputTextModule,
        MatMenuModule
],
  })
  export class SharedModule { }