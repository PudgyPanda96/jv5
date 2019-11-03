import { NgModule } from '@angular/core';
import { MatToolbarModule, MatIconModule, MatSidenavModule, MatListModule, MatButtonModule } from  '@angular/material';
import {VirtualScrollerModule} from 'primeng/virtualscroller';
import {DropdownModule} from 'primeng/dropdown';
import {MatSelectModule} from '@angular/material/select';
import {DialogModule} from 'primeng/dialog';
import {MatInputModule} from '@angular/material/input';
import {InputTextModule} from 'primeng/inputtext';
import {MatMenuModule} from '@angular/material/menu';
import {PanelModule} from 'primeng/panel';


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
        MatMenuModule,
        PanelModule
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
        MatMenuModule,
        PanelModule
],
  })
  export class SharedModule { }