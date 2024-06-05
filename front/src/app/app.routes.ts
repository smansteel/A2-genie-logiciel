import { Routes } from "@angular/router";
//import { isNotLoggedInGuard } from "./auth/guards/is-not-logged-in.guard";

export const routes: Routes = [
  {
    path: "login",
    loadComponent: () => import("./auth/components/login-form/login-form.component").then(m => m.LoginFormComponent),
  },
  {
    path: "register",
    loadComponent: () => import("./auth/components/register-form/register-form.component").then(m => m.RegisterFormComponent),
  },
  {
    path: "recover-password",
    loadComponent: () =>
      import("./auth/components/recover-password/recover-password.component").then(m => m.RecoverPasswordComponent),
  },
  {
    path: "wallet/:id",
    loadComponent: () => import("./core/wallet/components/wallet-page/wallet-page.component").then(m => m.WalletPageComponent),
  },
  {
    path: "admin/modules",
    loadComponent: () => import("./core/modules/components/module-page/module-page.component").then(m => m.ModulePageComponent),
  },
  {
    path: "**",
    redirectTo: "home",
  },
];
