import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

//import { AppRoutingModule } from './app-routing.module';
import { EventsAppComponent } from './events-app.component';
import { NavBarComponent } from './nav/nav-bar.component';
import { EventsListComponent } from './events/events-list.component';
import { EventsThumbnailComponent } from './events/events-thumbnail.component';
import { EventService } from './events/shared/event.service';
import { EventDetailsComponent } from './events/event-details/event-details.component';
import { RouterModule } from '@angular/router';
import { appRoutes } from './route';
import { CreateEventComponent } from './events/create-event.component'
import { Error404Component } from './404.component';
import { EventRouteActivator } from './events/event-details/event-route.service';
import { LoginComponent } from './users/login.component';
import { FormsModule } from '@angular/forms'
import { LoginService } from './users/login.service';
import { HttpClientModule } from '@angular/common/http'

@NgModule({
  declarations: [
    EventsAppComponent,
    NavBarComponent,
    EventsListComponent,
    EventsThumbnailComponent,
    EventDetailsComponent,
    CreateEventComponent,
    Error404Component,
    LoginComponent
  ],
  imports: [
    FormsModule, BrowserModule,RouterModule.forRoot(appRoutes), HttpClientModule
  ],
  providers: [EventRouteActivator,EventService, LoginService], //One way of injection of service using Angular to inject the service
  bootstrap: [EventsAppComponent]
})
export class AppModule { }
