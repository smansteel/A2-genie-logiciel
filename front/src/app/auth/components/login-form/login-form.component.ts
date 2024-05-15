import { Component } from "@angular/core";
import { FormBuilder, ReactiveFormsModule, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { AuthService } from "../../services/auth.service";

@Component({
  selector: "app-login-form",
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: "./login-form.component.html",
  styleUrl: "./login-form.component.css",
})
export class LoginFormComponent {
  loginForm = this.fb.group({
    email: ["", [Validators.required, Validators.minLength(5)]],
    password: ["", [Validators.required, Validators.minLength(8)]],
  });

  constructor(
    private router: Router,
    private auth: AuthService,
    private fb: FormBuilder,
  ) {}

  login() {
    const formValues = this.loginForm.value;
    if (this.loginForm.invalid) return;

    this.auth.login(formValues.email!, formValues.password!);
  }

  register() {
    this.router.navigate(["/register"]);
  }

  forgotPassword() {
    this.router.navigate(["/recover-password"]);
  }
}
