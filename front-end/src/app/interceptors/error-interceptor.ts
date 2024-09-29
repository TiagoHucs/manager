import { HttpErrorResponse, HttpEvent, HttpHandlerFn, HttpInterceptorFn, HttpRequest } from '@angular/common/http';
import { inject } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import { NotifierService } from '../shared/notifier/notifier.service';

export const errorInterceptor: HttpInterceptorFn = (req: HttpRequest<any>, next: HttpHandlerFn): Observable<HttpEvent<any>> => {
  const notifier = inject(NotifierService); // Injetando o serviço dentro do interceptor
  console.log('Error Intercepting...')

return next(req).pipe(
  catchError((response: HttpErrorResponse) => {
    console.log('Error Tratando...')
    notifier.notify('error',response.error.error)
    return throwError(() => new Error(response.message));
  })
);
};