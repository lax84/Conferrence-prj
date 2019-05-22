import { Injectable } from '@angular/core';
import { EventService } from '../shared/event.service';
import { ActivatedRouteSnapshot, Router, CanActivate } from '@angular/router';

@Injectable()
export class EventRouteActivator implements CanActivate{
    constructor (private eventService:EventService, private router:Router){

    }

    //return type of this method is boolean
    canActivate(route:ActivatedRouteSnapshot){
        console.log(route.params['id']);
        console.log(+route.params['id']);
        console.log(!this.eventService.getEvent(+route.params['id']))
        console.log(!!this.eventService.getEvent(+route.params['id']))

        const eventObjExist=!!this.eventService.getEvent(+route.params['id']);
        if (!eventObjExist){
            this.router.navigateByUrl('/404');
        }
        return true;
    }
}