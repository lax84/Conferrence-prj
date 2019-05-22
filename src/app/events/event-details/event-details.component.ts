import { Component, OnInit } from '@angular/core';
import { EventService } from '../shared/event.service';
import { ActivatedRoute } from '@angular/router';
import { appRoutes } from 'src/app/route';

@Component({
  providers:[EventService],
  selector: 'app-event-details',
  templateUrl: './event-details.component.html',
  //styleUrls: ['./event-details.component.css']
  styles:[`
  .container { padding-left:20px; padding-right: 20px; }
  .event-image { height: 100px; }
`]
})
export class EventDetailsComponent implements OnInit {
  event:any;
  constructor(private eventSerice:EventService, private activatedRoute:ActivatedRoute) {

  }

  ngOnInit() {
    this.event = this.eventSerice.getEvent(+this.activatedRoute.snapshot.params['id']).subscribe(
      (data)=>{
        this.event=data;
      }
    );
  }

}
