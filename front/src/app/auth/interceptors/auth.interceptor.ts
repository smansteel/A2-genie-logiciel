import { HttpHandlerFn, HttpHeaders, HttpRequest } from "@angular/common/http";
import { AuthService } from "../services/auth.service";
import { inject } from "@angular/core";

export function authInterceptor(req: HttpRequest<unknown>, next: HttpHandlerFn) {
  if (req.url.match(/auth\//)) {
    return next(req);
  }

  const authToken = inject(AuthService).getAccessToken();
  const headers = new HttpHeaders().set("Authorization", `Bearer ${authToken}`);
  const newReq = req.clone({ headers });

  return next(newReq);
}
