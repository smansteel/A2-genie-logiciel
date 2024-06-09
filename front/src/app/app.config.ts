import { ApplicationConfig } from "@angular/core";
import { provideRouter } from "@angular/router";

import { routes } from "./app.routes";
import { provideClientHydration } from "@angular/platform-browser";
import { HTTP_INTERCEPTORS, provideHttpClient, withInterceptors, withInterceptorsFromDi } from "@angular/common/http";
import { authInterceptor } from "./auth/interceptors/auth.interceptor";
import { BaseUrlInterceptor } from "./auth/interceptors/base-url.interceptor";
import { provideAnimationsAsync } from "@angular/platform-browser/animations/async";

export const appConfig: ApplicationConfig = {
  providers: [
    provideRouter(routes),
    provideClientHydration(),
    provideHttpClient(withInterceptors([authInterceptor]), withInterceptorsFromDi()),
    { provide: "BASE_API_URL", useValue: "http://localhost:8080" },
    { provide: HTTP_INTERCEPTORS, useClass: BaseUrlInterceptor, multi: true },
    provideAnimationsAsync(),
  ],
};
