import { Component } from "@angular/core";
import { FormBuilder, FormsModule, ReactiveFormsModule, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { AuthService } from "../../services/auth.service";
import { CommonModule } from "@angular/common";

@Component({
  selector: "app-register-form",
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: "./register-form.component.html",
  styleUrl: "./register-form.component.css",
})
export class RegisterFormComponent {
  registerForm = this.fb.group({
    email: ["", [Validators.required, Validators.email, Validators.minLength(5)]],
    profileName: ["", [Validators.required, Validators.minLength(3)]],
    password: ["", [Validators.required, Validators.minLength(8)]],
    confirmPassword: ["", [Validators.required, Validators.minLength(8)]],
    terms: [false, Validators.requiredTrue],
  });

  constructor(
    private router: Router,
    private auth: AuthService,
    private fb: FormBuilder,
  ) {}

  redirectToLogin() {
    this.router.navigate(["/login"]);
  }

  createAccount() {
    const formValues = this.registerForm.value;
    if (this.registerForm.invalid || formValues.password !== formValues.confirmPassword) return;

    this.auth.register(formValues.email!, formValues.password!);

    console.log("OK");
  }
}
