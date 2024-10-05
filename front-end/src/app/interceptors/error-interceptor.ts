import { HttpErrorResponse, HttpEvent, HttpHandlerFn, HttpInterceptorFn, HttpRequest } from '@angular/common/http';
import { inject } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import { NotifierService } from '../shared/notifier/notifier.service';
import { Router } from '@angular/router';

export const errorInterceptor: HttpInterceptorFn = (req: HttpRequest<any>, next: HttpHandlerFn): Observable<HttpEvent<any>> => {
  const notifier = inject(NotifierService); // Injetando o serviço dentro do interceptor
  const router = inject(Router); // Injetar o Router aqui
  console.log('Error Intercepting...')

  return next(req).pipe(
    catchError((response: HttpErrorResponse) => {
      console.log('Error Tratando...')
      console.log(response)
      if (response.status == 401) {
        const msg = response.error == null || response.error.error == null ? 
        'Usuario não autorizado' : response.error.error;
        notifier.notify('error', msg);
        router.navigate(['/signin']);
      } else {
        notifier.notify('error', response.error.error);
      }
      return throwError(() => new Error(response.message));
    })
  );


};

