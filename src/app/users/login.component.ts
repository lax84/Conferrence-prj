import { Component } from '@angular/core';
import { LoginService } from './login.service';
import { Router } from '@angular/router';

@Component({
    templateUrl: './login.component.html',
    styles:[`
    em {float: right; color: RED; padding-left:10px;}
    `]
})
export class LoginComponent{
    userName;
    password;

    constructor (private loginService: LoginService, private route:Router){

    }
    loginFormHandler(formObject) {
        //alert("This is test.");
        console.log(formObject);
        this.loginService.loginForm(formObject.userName, formObject.password);
        this.route.navigate(['events']);
    }
    cancel(){
        this.route.navigate(['events']);
    }
}
/*
() --> Means Event binding
[] --> One way binding
[()] --> Two way data binding
*/