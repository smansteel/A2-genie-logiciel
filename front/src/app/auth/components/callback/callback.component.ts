import { Component, OnInit } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import { AuthService } from "../../services/auth.service";

@Component({
  selector: "app-callback",
  standalone: true,
  imports: [],
  templateUrl: "./callback.component.html",
  styleUrl: "./callback.component.css",
})
export class CallbackComponent implements OnInit {
  token: string = "";

  constructor(
    private route: ActivatedRoute,
    private auth: AuthService,
    private router: Router,
  ) {}

  async ngOnInit() {
    this.route.queryParams.subscribe(async params => {
      this.token = params["ticket"]; // Assuming the parameter name is 'ticket'
      console.log(this.token);
      const jwt = await this.auth.sendTokenToAuth(this.token);
      this.auth.setJWT(jwt);
      this.router.navigate(["/home"]);
    });
  }
}
