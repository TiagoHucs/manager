import { Component } from '@angular/core';

@Component({
  selector: 'app-notifier',
  standalone: true,
  imports: [],
  templateUrl: './notifier.component.html',
  styleUrl: './notifier.component.css'
})
export class NotifierComponent {

  test(){
    console.log('testeou')
  }

}
