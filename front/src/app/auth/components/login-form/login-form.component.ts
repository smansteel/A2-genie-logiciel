import { Component } from "@angular/core";
import { FormBuilder, ReactiveFormsModule, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { AuthService } from "../../services/auth.service";
import { CommonModule } from "@angular/common";
import { NotificationsService } from "../../../shared/services/notifications/notifications.service";
import { NotificationType } from "../../../shared/types/notification.type";

@Component({
  selector: "app-login-form",
  standalone: true,
  imports: [ReactiveFormsModule, CommonModule],
  templateUrl: "./login-form.component.html",
  styleUrl: "./login-form.component.css",
})
export class LoginFormComponent {
  loginForm = this.fb.group({
    email: ["", [Validators.required, Validators.minLength(5)]],
    password: ["", [Validators.required]],
  });

  constructor(
    private router: Router,
    private auth: AuthService,
    private fb: FormBuilder,
    private notification: NotificationsService,
  ) {}

  async login() {
    const formValues = this.loginForm.value;
    if (this.loginForm.invalid) return;

    const result = await this.auth.login(formValues.email!, formValues.password!);
    if (result === "OK") {
      this.router.navigate(["/"]);
    } else {
      this.notification.add({
        type: NotificationType.Error,
        title: "Impossible de se connecter",
        description: result,
      });
    }
  }

  register() {
    this.router.navigate(["/register"]);
  }

  forgotPassword() {
    this.router.navigate(["/recover-password"]);
  }
}
