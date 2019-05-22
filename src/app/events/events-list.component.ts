import { Component, OnInit } from '@angular/core';
import { EventService } from './shared/event.service';

@Component({
  selector: 'events-list',
  providers: [EventService],
  //templateUrl: './events.component.html',
  template: `
  <div>
    <h1>The Angular Events.
    <br/></h1><hr>
    <div class="row">
    <div *ngFor="let oneEvent of events" class="col-md-5">
    <events-thumbnail [event]="oneEvent"></events-thumbnail>

    <!-- Safe Traversal Operator = ? 
    Parent component is forwarding the data.
    Child component is getting data from parent, this is known as (unknown/undefined data)
    -->
    </div>
    </div>
    <!-- The above line says, the *ngFor is used to loop through the events Data. this says copy the Events to Event -->
</div>

  `
  //styleUrls: ['./events.component.css']
})
export class EventsListComponent implements OnInit {

  //events:any[];
  events;
  // = new EventService();
  constructor(private eventService: EventService) {
    console.log('Inside Constructor');
  }

  ngOnInit() {
    console.log('Inside ngOnInit');
    //this.events = this.eventService.getEvents();
    this.eventService.getEvents().subscribe(
      (data)=>{
        this.events=data;
      }
    );
  }
}
