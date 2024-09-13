import { HttpErrorResponse, HttpInterceptorFn } from '@angular/common/http';
import { HttpRequest, HttpHandlerFn, HttpEvent } from '@angular/common/http';
import { inject } from '@angular/core';
import { Router } from '@angular/router';
import { catchError, Observable, throwError } from 'rxjs';

export const authInterceptor: HttpInterceptorFn = (req: HttpRequest<any>, next: HttpHandlerFn): Observable<HttpEvent<any>> => {
  const router = inject(Router); // Injetar o Router aqui
  console.log('Intercepting...')

// Ignora requisições para rotas de autenticação
if (req.url.includes('/auth')) {
  return next(req);
}

const token = localStorage.getItem('token');

let authReq = req;
if (token) {
  authReq = req.clone({
    setHeaders: {
      Authorization: `${token}`
    }
  });
}

return next(authReq).pipe(
  catchError((error: HttpErrorResponse) => {
    console.log(authReq)
    console.log(error)
    if (error.status === 401) {
      console.log('É 401 kaári!!!')
      // Obtém a instância do Router
      //const router = new Router();
      // Redireciona para a página de signin
      router.navigate(['/signin']);
    }
    return throwError(() => new Error(error.message));
  })
);
};