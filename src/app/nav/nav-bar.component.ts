import { Component } from '@angular/core'
import { LoginService } from '../users/login.service';

@Component({
  selector: 'nav-bar',
  templateUrl: './nav-bar.component.html',
  styles: [`
    .nav.navbar-nav {font-size: 15px;}
    #searchForm {margin-right: 100px;}
    @media (max-width: 1200px) {#searchForm {display:none}}
  `]
})
export class NavBarComponent {
  constructor (private loginService:LoginService){
    
  }
}