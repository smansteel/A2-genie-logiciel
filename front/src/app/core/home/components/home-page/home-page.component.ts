import { Component } from "@angular/core";
import { UserService } from "../../../../shared/services/user/user.service";
import { User } from "../../../../shared/types/User.type";
import { HomeWalletsComponent } from "../home-wallets/home-wallets.component";

@Component({
  selector: "app-home-page",
  standalone: true,
  imports: [HomeWalletsComponent],
  templateUrl: "./home-page.component.html",
  styleUrl: "./home-page.component.css",
})
export class HomePageComponent {
  user!: User;

  constructor(private userService: UserService) {
    this.user = this.getFakeUser();
    return;

    this.user = this.userService.get();
  }

  private getFakeUser(): User {
    const user: User = {
      id: 0,
      username: "mdelarue",
      firstName: "Matthieu",
      name: "Dlr",
    };
    return user;
  }
}
