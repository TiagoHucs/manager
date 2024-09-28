import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

// Defina a interface para o objeto de notificação
export interface NotificationDTO {
  msg: string;
  type: string;
}


@Injectable({
  providedIn: 'root'
})
export class NotifierService {
  private notifierSubject = new Subject<NotificationDTO>();

  notify(ntfType: string, ntfMsg: string) {
    const ntf: NotificationDTO = {type: ntfType , msg: ntfMsg };
    this.notifierSubject.next(ntf);
  }

  // Método para obter o observable
  get notifier$() {
    return this.notifierSubject.asObservable();
  }

}
