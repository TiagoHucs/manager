import { Component, ElementRef, OnDestroy, OnInit, ViewChild } from '@angular/core';
import { Subscription } from 'rxjs';
import { NotifierService } from './notifier.service';

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
    this.subscription = this.notifierService.notifier$.subscribe((msg) => {
      this.handleNotification(msg);
    });
  }

  private handleNotification(msg: string) {
    this.msg = msg;
    this.msgDiv.nativeElement.classList.add('alert-msg');
    setTimeout(() => {
        this.msg = undefined;
        this.msgDiv.nativeElement.classList.remove('alert-msg');
    }, 2000); // Popup aparece por 2 segundos

  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }


}
