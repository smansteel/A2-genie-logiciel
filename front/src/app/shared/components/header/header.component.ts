import { Component, OnInit } from "@angular/core";
import { User } from "../../types/User.type";
import { UserService } from "../../services/user/user.service";


@Component({
  selector: 'app-header',
  standalone: true,
  imports: [],
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent implements OnInit {
  protected user: User | null = null;

  constructor(private userService: UserService) {
  }

  ngOnInit(): void {
    
  }
}
