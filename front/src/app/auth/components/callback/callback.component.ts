import { Component, OnInit } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
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
  ) {}

  async ngOnInit() {
    this.token = this.route.snapshot.params["ticket"];
    const jwt = await this.auth.sendTokenToAuth(this.token);
    this.auth.setJWT(jwt);
  }
}
