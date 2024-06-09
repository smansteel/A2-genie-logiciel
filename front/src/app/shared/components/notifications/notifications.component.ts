import { CommonModule } from "@angular/common";
import { Component } from "@angular/core";
import { NotificationsService } from "../../services/notifications/notifications.service";
import { Notification } from "../../types/notification.type";

@Component({
  selector: "app-notifications",
  standalone: true,
  imports: [CommonModule],
  templateUrl: "./notifications.component.html",
  styleUrl: "./notifications.component.css",
})
export class NotificationsComponent {
  constructor(public notificationsServices: NotificationsService) {}

  onclick(notification: Notification) {
    this.notificationsServices.remove(notification);

    if (notification.onClicAction) {
      notification.onClicAction;
    }
  }
}
