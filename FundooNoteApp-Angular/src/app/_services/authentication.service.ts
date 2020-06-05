import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { environment } from 'src/environments/environment';

@Injectable({ providedIn: 'root' })
export class AuthenticationService {
    constructor(private http: HttpClient) { }

    login(username: string, password: string) {
         // login successful if there's a jwt token in the response
        return this.http.post<any>(`${environment.apiUrl}/login`, { username, password },{responseType:'text' as 'json'})
        };
    
 logout() {
        // remove user from local storage to log user out
        localStorage.removeItem('currentUser');
    }
}