import { HttpEvent, HttpHandlerFn, HttpInterceptorFn, HttpRequest } from '@angular/common/http';
import { inject } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

/**
 * Responsavel apenas por adicionar token nas requisições que nao forem logar ou criar conta
 */
export const authInterceptor: HttpInterceptorFn = (req: HttpRequest<any>, next: HttpHandlerFn): Observable<HttpEvent<any>> => {
  const router = inject(Router); // Injetar o Router aqui

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

return next(authReq);
};