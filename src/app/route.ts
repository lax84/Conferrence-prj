import {Routes} from '@angular/router'
import { EventsListComponent } from './events/events-list.component';
import { EventDetailsComponent } from './events/event-details/event-details.component';
import { CreateEventComponent } from './events/create-event.component';
import { Error404Component } from './404.component';
import { EventRouteActivator } from './events/event-details/event-route.service';
import { LoginComponent } from './users/login.component';

export const appRoutes:Routes = [
    // array of JS objects.
    {path: 'events/new', component:CreateEventComponent},
    {path:'events', component:EventsListComponent},
    {path:'user/login', component:LoginComponent},
    {canActivate:[EventRouteActivator], path: 'events/:id', component:EventDetailsComponent},
    {path: '404', component:Error404Component},
    {path: '',redirectTo: 'events', pathMatch:'full'} //Path Match can be mentioned FULL OR PREFIX
];