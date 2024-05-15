import { Component } from "@angular/core";
import { FormBuilder, ReactiveFormsModule, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { AuthService } from "../../services/auth.service";
import { CommonModule } from "@angular/common";

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
  status = "";

  constructor(
    private router: Router,
    private auth: AuthService,
    private fb: FormBuilder,
  ) {}

  async login() {
    this.status = "loading";
    const formValues = this.loginForm.value;
    if (this.loginForm.invalid) return;

    this.status = await this.auth.login(formValues.email!, formValues.password!);
  }

  register() {
    this.router.navigate(["/register"]);
  }

  forgotPassword() {
    this.router.navigate(["/recover-password"]);
  }
}
