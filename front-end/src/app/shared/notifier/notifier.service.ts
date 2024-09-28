import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class NotifierService {
  private notifierSubject = new Subject<string>();

  // Método para emitir notificações
  notify(message: string) {
    this.notifierSubject.next(message);
  }

  // Método para obter o observable
  get notifier$() {
    return this.notifierSubject.asObservable();
  }

}
