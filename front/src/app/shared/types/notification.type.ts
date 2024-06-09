export type Notification = {
  type: NotificationType;
  title: string;
  description?: string;
  onClicAction?: () => void;
};

export enum NotificationType {
  Error = "error",
  Info = "info",
  Success = "success",
  Warning = "warning",
  Normal = "normal",
}
