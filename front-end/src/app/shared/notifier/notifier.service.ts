import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class NotifierService {

  success(txt: string){
    alert('Notifier SUCCESS: ' + txt);
  }

  info(txt: string){
    alert('Notifier INFO: ' + txt);
  }

  error(txt: string){
    alert('Notifier ERROR: ' + txt);
  }

}
