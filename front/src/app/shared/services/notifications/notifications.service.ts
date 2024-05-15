import { Injectable } from "@angular/core";
import { Notification } from "../../types/notification.type";

@Injectable({
  providedIn: "root",
})
export class NotificationsService {
  notifications: Set<Notification> = new Set();

  constructor() {}

  public add(notification: Notification, duration: number = 5) {
    this.notifications.add(notification);
    setTimeout(() => {
      this.remove(notification);
    }, duration * 1000);
  }

  public remove(notification: Notification) {
    this.notifications.delete(notification);
  }
}
