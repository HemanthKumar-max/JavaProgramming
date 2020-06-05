import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { environment } from '../../environments/environment';
import { User } from '../_models';
import { Login } from '../userlogin/login';
import { forgotpwd } from '../_models/forgotpwd';
import { resetpwd } from '../_models/resetpwd';
import { Observable } from 'rxjs';
import { Note } from '../_models/note';

@Injectable()
export class UserService {
    constructor(private http: HttpClient) { }

    getAllRegisters() {
        return this.http.get(`${environment.apiUrl}/getUserList`);
    }

    getById(id: number) {
        return this.http.get(`${environment.apiUrl}/Register/` + id);
    }

    register(user: User) {
        return this.http.post(`${environment.apiUrl}/RegisterUser`, user,{responseType:'text' as 'json'});
    }

    update(user: User) {
        return this.http.put(`${environment.apiUrl}/users/` + user.id, user);
    }

    delete(id: number) {
        return this.http.delete(`${environment.apiUrl}/Delete/` + id);
    }

    loginUser(login: Login) {
        return this.http.post(`${environment.apiUrl}/LoginUser`,login,{responseType:'text' as 'json'});
    }

    forgotpassword(email: forgotpwd) {
        return this.http.post(`${environment.apiUrl}/forgotpassword`,email);
    }
    
    resetpassword(password: resetpwd){
        return this.http.post(`${environment.apiUrl}/updatepassword`,password);
    }
    
    addNote(note: Note,id:number) {
        return this.http.post(`${environment.apiUrl}/addNote/`+id,note);
    }
    
    getAllNotes() {
        return this.http.get(`${environment.apiUrl}/getNoteList`);
    }  

    deleteNoteById(id: number) {
        return this.http.delete(`${environment.apiUrl}/getNoteList/delete/` + id);
    }

}