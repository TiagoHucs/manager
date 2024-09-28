import { HttpErrorResponse, HttpEvent, HttpHandlerFn, HttpInterceptorFn, HttpRequest } from '@angular/common/http';
import { inject } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import { NotifierService } from '../shared/notifier/notifier.service';

export const errorInterceptor: HttpInterceptorFn = (req: HttpRequest<any>, next: HttpHandlerFn): Observable<HttpEvent<any>> => {
  const notifier = inject(NotifierService); // Injetando o serviço dentro do interceptor
  console.log('error Intercepting...')

return next(req).pipe(
  catchError((response: HttpErrorResponse) => {
    console.log(req)
    console.log(response)
    if (response.status === 400) {
      notifier.notify(response.error.error)
    }
    return throwError(() => new Error(response.message));
  })
);
};