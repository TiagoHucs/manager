import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { NotifierComponent } from './shared/notifier/notifier.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [NotifierComponent, RouterOutlet],
  providers: [],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Manager';
}
