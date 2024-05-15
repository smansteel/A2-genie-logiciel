import { Component } from "@angular/core";
import { FormsModule } from "@angular/forms";
import { Router } from "@angular/router";
import { AuthService } from "../../services/auth.service";

@Component({
  selector: "app-login-form",
  standalone: true,
  imports: [FormsModule],
  templateUrl: "./login-form.component.html",
  styleUrl: "./login-form.component.css",
})
export class LoginFormComponent {
  email: string = "";
  password: string = "";

  constructor(
    private router: Router,
    private auth: AuthService,
  ) {}

  login() {
    console.log("OK");
    this.auth.login(this.email, this.password);
  }

  register() {
    this.router.navigate(["/register"]);
  }

  forgotPassword() {
    this.router.navigate(["/recover-password"]);
  }
}
