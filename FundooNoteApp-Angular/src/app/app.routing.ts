import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './home';
import { LoginComponent } from './login';
import { RegisterComponent } from './register';
import { AuthGuard } from './_guards';
import { AllRegisteredUsersComponent } from './all-registered-users/all-registered-users.component';
import { UserloginComponent } from './userlogin/userlogin.component';
import { ForgotpasswordComponent } from './forgotpassword/forgotpassword.component';
import { ResetpasswordComponent } from './resetpassword/resetpassword.component';
import { AddNoteComponent } from './add-note/add-note.component';
import { DisplayNoteComponent } from './display-note/display-note.component';





const appRoutes: Routes = [
   
    { path: '', component: HomeComponent, canActivate: [AuthGuard] },
    { path: 'login', component: LoginComponent },
    { path: 'register', component: RegisterComponent },
    { path: 'home', component: HomeComponent },
    {path: 'app-all-registered-users', component: AllRegisteredUsersComponent},
    {path: 'app-userlogin', component: UserloginComponent},
    {path: 'app-forgotpassword', component: ForgotpasswordComponent},
    {path: 'app-resetpassword/:userId', component: ResetpasswordComponent},
    {path: 'app-add-note', component: AddNoteComponent},
    {path: 'app-display-note', component: DisplayNoteComponent},  

    
    
     

    

    // otherwise redirect to home
    { path: '**', redirectTo: '' }
];

export const routing = RouterModule.forRoot(appRoutes);