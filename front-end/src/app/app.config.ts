import { ApplicationConfig, importProvidersFrom } from '@angular/core';
import { provideRouter } from '@angular/router';
import { HttpClientModule, provideHttpClient, withInterceptors } from '@angular/common/http';

import { routes } from './app.routes';
import { CommonModule } from '@angular/common';
import { authInterceptor  } from './interceptors/auth-interceptor';
import { errorInterceptor } from './interceptors/error-interceptor';

export const appConfig: ApplicationConfig = {
  providers: [
    provideHttpClient(withInterceptors([authInterceptor,errorInterceptor])),
    importProvidersFrom(HttpClientModule),  
    importProvidersFrom(CommonModule),  
    provideRouter(routes)]
};
