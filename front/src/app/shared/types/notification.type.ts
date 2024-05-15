export type Notification = {
  type: NotificationType;
  title: string;
  description?: string;
  primaryAction?: () => void;
  secondaryAction?: () => void;
};

export enum NotificationType {
  Error = "error",
  Info = "info",
  Success = "success",
  Warning = "warning",
  Normal = "normal",
}
