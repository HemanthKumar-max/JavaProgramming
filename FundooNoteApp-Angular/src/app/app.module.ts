import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule }    from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

// used to create fake backend
import { fakeBackendProvider } from './_helpers';

import { AppComponent }  from './app.component';
import { routing }        from './app.routing';
import { AlertComponent } from './_directives';
import { AuthGuard } from './_guards';
import { JwtInterceptor, ErrorInterceptor } from './_helpers';
import { AlertService, AuthenticationService, UserService } from './_services';
import { HomeComponent } from './home';
import { LoginComponent } from './login';
import { RegisterComponent } from './register';
import { AllRegisteredUsersComponent } from './all-registered-users/all-registered-users.component';
import { UserloginComponent } from './userlogin/userlogin.component';
import { ForgotpasswordComponent } from './forgotpassword/forgotpassword.component';
import { ResetpasswordComponent } from './resetpassword/resetpassword.component';
import { LayoutModule } from '@angular/cdk/layout';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatSliderModule } from '@angular/material/slider';
import { MatIconModule } from '@angular/material/icon';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatListModule } from '@angular/material/list';
import { FormsModule } from '@angular/forms';
import { MatMenuModule } from '@angular/material/menu';
import { AddNoteComponent } from './add-note/add-note.component';
import { MatCardModule } from '@angular/material/card';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import { DisplayNoteComponent } from './display-note/display-note.component';
import { MatDialogModule } from '@angular/material/dialog';







@NgModule({
    imports: [
        BrowserModule,
        ReactiveFormsModule,
        HttpClientModule,
        routing,
        LayoutModule,
        MatToolbarModule ,
        MatButtonModule ,
        MatSidenavModule,
        MatSliderModule,
        MatIconModule,
        BrowserAnimationsModule,
        MatListModule,
        FormsModule,
        MatMenuModule,
        MatCardModule,
        MatFormFieldModule,
        MatInputModule,
        MatDialogModule

       
        
    ],

    declarations: [
         AppComponent,
        AlertComponent,
        HomeComponent,
        LoginComponent,
        RegisterComponent,
       AllRegisteredUsersComponent,
       UserloginComponent,
       ForgotpasswordComponent,
       ResetpasswordComponent,
       AddNoteComponent,
       DisplayNoteComponent
      
      
      
      ],
    providers: [
        AuthGuard,
        AlertService,
        AuthenticationService,
        UserService,
        JwtInterceptor,
        AuthGuard,
       { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true },
        { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true },

        
    ],
    bootstrap: [AppComponent]
})

export class AppModule { }