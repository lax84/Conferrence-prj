import { Component, Input } from '@angular/core';

@Component({
    selector: 'events-thumbnail',
    template: `
    <div [routerLink]="['/events',event?.eventId]" class="well hoverwell thumbnail">
    <h2>{{event?.name | uppercase}}</h2><br/>
    Event Date : {{event?.date | date: 'y/M/d'}}<br/>

    <div [ngClass]="getStartTimingStyles2()"
    [ngSwitch]="event?.time">
        Event Time : {{event?.time}} - 
        <span *ngSwitchCase="'8:00 am'">Early Start</span>
        <span *ngSwitchCase="'10:00 am'">Late Start</span>
        <span *ngSwitchDefault>Perfect Start</span>
    </div>
    Event Price : {{event?.price | currency:'INR'}}<br/>
    <div [hidden]="!event?.location">
        Event Location : {{event?.location?.address}}, {{event?.location?.city}}, {{event?.location?.country}}<br/>
    </div>
    <div [hidden]="!event?.onlineUrl"><span>onlineURL: {{event?.onlineUrl}}</span></div>
</div>
<!-- Below are the codes used for different approach. This also can be used for only specific tags.
[class.green]="event?.time==='8:00 am'" 
[class.bold]="event?.time==='8:00 am'"


{green: event?.time==='8:00 am',
bold: event?.time==='8:00 am', red: event?.time==='10:00 am',
bold: event?.time==='10:00 am'}
-->
    `,
    styles: [
        `
        .green{color:yellow !important;}
        .bold{font-weight: bold;}
        .red{color:red !important;}
        .thumbnail{min-height:210px;}
        .pad-left{margin-left: 10px;}
        div, pointer {cursor: pointer;}
        `
    ]
})
export class EventsThumbnailComponent {
@Input() event:any;
getStartTimingStyles() {
    const isEarlyStart=this.event && this.event.time ==='8:00 am';
    const isLateStart=this.event && this.event.time ==='10:00 am';
    return{green:isEarlyStart, bold:isEarlyStart,isLateStart, red:isLateStart}
}
getStartTimingStyles1() {
    if(this.event && this.event.time ==='8:00 am'){
        return 'green bold';
    }
    
}
getStartTimingStyles2() {
    if(this.event && this.event.time ==='8:00 am'){
        return ['green', 'bold'];
    }
    
}
}