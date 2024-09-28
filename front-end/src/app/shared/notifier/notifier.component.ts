import { Component, ElementRef, OnDestroy, OnInit, ViewChild } from '@angular/core';
import { Subscription } from 'rxjs';
import { NotificationDTO, NotifierService } from './notifier.service';

@Component({
  selector: 'app-notifier',
  standalone: true,
  imports: [],
  templateUrl: './notifier.component.html',
  styleUrl: './notifier.component.css'
})
export class NotifierComponent implements OnInit, OnDestroy {
  @ViewChild('msgDiv') msgDiv!: ElementRef;
  private subscription!: Subscription;
  protected msg: string | undefined;

  constructor(private notifierService: NotifierService) { }

  ngOnInit(): void {
    this.subscription = this.notifierService.notifier$.subscribe((ntf) => {
      console.log(ntf)
      this.handleNotification(ntf);
    });
  }

  private handleNotification(ntf: NotificationDTO) {
    this.setUpMsg(ntf);
    setTimeout(() => {
        this.resetMsg();
    }, 2000);
  }

  setUpMsg(ntf: NotificationDTO){
    this.msg = ntf.type + ' ' + ntf.msg ;
    this.msgDiv.nativeElement.classList.add('alert-msg', ntf.type);
  }

  resetMsg(){
    this.msg = undefined;
    this.msgDiv.nativeElement.classList.remove('alert-msg','success','info','error');
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }


}
