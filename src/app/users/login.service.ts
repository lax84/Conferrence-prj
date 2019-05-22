import { Injectable } from '@angular/core';
import { IUser } from './user.model';


@Injectable()
export class LoginService{
    currentUser: IUser;
    loginForm(userName:string, password:string){
        this.currentUser={
            id:1,
            userName:'lax',
            firstName: 'Lakshman',
            lastName: 'N',
            password: 'Laddu'
        }
    }
    isAuthenticated(){
        return !!this.currentUser;
    }
}