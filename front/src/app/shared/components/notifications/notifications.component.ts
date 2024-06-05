import { CommonModule } from "@angular/common";
import { Component } from "@angular/core";
import { NotificationsService } from "../../services/notifications/notifications.service";

@Component({
  selector: "app-notifications",
  standalone: true,
  imports: [CommonModule],
  templateUrl: "./notifications.component.html",
  styleUrl: "./notifications.component.css",
})
export class NotificationsComponent {
  constructor(public notificationsServices: NotificationsService) {}
}
